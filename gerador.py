from LinguagemListener import LinguagemListener
from LinguagemParser import LinguagemParser

class GeradorCodigo(LinguagemListener):
    def __init__(self, nome_classe="Program"):
        self.nome_classe = nome_classe
        
        # --- ARQUITETURA DE BUFFERS ---
        self.main_code = ""      
        self.methods_code = ""   
        self.inside_method = False 
        
        # --- CONTROLE DE FLUXO ---
        self.for_increment_buffer = [] 
        self.capturing_increment = False 
        self.current_increment_code = "" 
        self.for_config_stack = [] 
        self.loop_labels = [] 
        
        # Pilha para controlar IFs aninhados
        self.if_stack = [] 

        self.switch_stack = []

        self.var_map_main = {}   
        self.var_map_local = {}  
        self.next_var_index = 1 
        self.label_counter = 0
        self.em_console_log = False
        self.last_type = 'int'
        
        # NOVO: Lista para guardar nomes de funções e impedir que sejam lidas como variáveis
        self.defined_functions = set()
        # NOVO: Flag para retorno implícito de Arrow Function
        self.is_arrow_return = False

        # --- NOVO: CONTROLE DE DELETE ---
        self.pending_delete = False      # Indica que estamos dentro de um "delete ..."
        self.delete_handled = False      # Indica se o delete foi consumido com sucesso por um objeto

        # --- Pilha para Operador Ternário ---
        self.ternary_stack = []
        
    def get_codigo(self):
        full_code = f".class public {self.nome_classe}\n"
        full_code += ".super java/lang/Object\n\n"
        
        full_code += ".method public <init>()V\n"
        full_code += "   aload_0\n"
        full_code += "   invokenonvirtual java/lang/Object/<init>()V\n"
        full_code += "   return\n"
        full_code += ".end method\n\n"

        full_code += self.methods_code

        full_code += ".method public static main([Ljava/lang/String;)V\n"
        full_code += "   .limit stack 300\n"
        full_code += "   .limit locals 300\n"
        full_code += self.main_code
        full_code += "   return\n"
        full_code += ".end method\n"
        return full_code
    
    def emit(self, instruction):
        if self.capturing_increment:
            self.current_increment_code += instruction
        elif self.inside_method:
            self.methods_code += instruction
        else:
            self.main_code += instruction

    def get_next_label(self):
        label = f"L{self.label_counter}"
        self.label_counter += 1
        return label

    # -----------------------------------------------------------
    # LÓGICA DO IF / ELSE
    # -----------------------------------------------------------
    def enterIfStatement(self, ctx):
        lbl_else = self.get_next_label()
        lbl_end = self.get_next_label()
        
        expr_ctx = ctx.expression()
        stmt_true = ctx.statement(0)
        
        self.if_stack.append({
            'lbl_else': lbl_else,
            'lbl_end': lbl_end,
            'expr_id': id(expr_ctx),
            'stmt_true_id': id(stmt_true)
        })

    def exitIfStatement(self, ctx):
        config = self.if_stack.pop()
        self.emit(f"{config['lbl_end']}:\n")

    # -----------------------------------------------------------
    # LÓGICA DO FOR
    # -----------------------------------------------------------
    def enterForStatement(self, ctx):
        lbl_start = self.get_next_label()
        lbl_end = self.get_next_label()
        self.loop_labels.append((lbl_start, lbl_end))
        
        children = [c for c in ctx.getChildren()]
        semi_indices = [i for i, c in enumerate(children) if c.getText() == ';']
        cond_ctx = None
        inc_ctx = None
        
        if len(semi_indices) >= 2:
            idx_semi1 = semi_indices[0]
            idx_semi2 = semi_indices[1]
            if idx_semi2 > idx_semi1 + 1:
                cond_ctx = children[idx_semi1 + 1]
            if children[idx_semi2 + 1].getText() != ')':
                inc_ctx = children[idx_semi2 + 1]

        self.for_config_stack.append({
            'cond_id': id(cond_ctx) if cond_ctx else None,
            'inc_id': id(inc_ctx) if inc_ctx else None
        })
        
        if not ctx.forInit():
            self.emit(f"{lbl_start}:\n")

    def exitForInit(self, ctx):
        if self.loop_labels:
            lbl_start, _ = self.loop_labels[-1]
            self.emit(f"{lbl_start}:\n")

    def enterExpression(self, ctx):
        if self.for_config_stack:
            config = self.for_config_stack[-1]
            if id(ctx) == config['inc_id']:
                self.capturing_increment = True
                self.current_increment_code = "" 

    def exitExpression(self, ctx):
        # 1. Verifica se é condição de IF
        if self.if_stack:
            config = self.if_stack[-1]
            if id(ctx) == config['expr_id']:
                self.emit("   checkcast java/lang/Number\n")
                self.emit("   invokevirtual java/lang/Number/intValue()I\n")
                self.emit(f"   ifeq {config['lbl_else']}\n")

        # 2. Verifica se é config de FOR
        if self.for_config_stack:
            config = self.for_config_stack[-1]
            if id(ctx) == config['cond_id']:
                _, lbl_end = self.loop_labels[-1]
                self.emit("   checkcast java/lang/Number\n")
                self.emit("   invokevirtual java/lang/Number/intValue()I\n")
                self.emit(f"   ifeq {lbl_end}\n")

            elif id(ctx) == config['inc_id']:
                self.capturing_increment = False
                self.for_increment_buffer.append(self.current_increment_code)
                self.current_increment_code = ""


            # verifica se é condição de WHILE
        if hasattr(self, 'while_config_stack') and self.while_config_stack:
            config = self.while_config_stack[-1]
            if id(ctx) == config['expr_id']:
                _, lbl_end = self.loop_labels[-1]
                self.emit("   checkcast java/lang/Number\n")
                self.emit("   invokevirtual java/lang/Number/intValue()I\n")
                self.emit(f"   ifeq {lbl_end}\n")

                # NOVO: Verifica se é a expressão de controle de um SWITCH
        if hasattr(self, 'switch_stack') and self.switch_stack:
            config = self.switch_stack[-1]
            
            # 1. Se acabamos de calcular a expressão principal do switch (ex: dia)
            if id(ctx) == config['main_expr_id']:
                self.emit(f"   astore {config['expr_index']}\n")
                return

            # 2. Se acabamos de calcular o valor de um CASE (ex: 1)
            if id(ctx) == config['current_case_expr_id']:
                # O valor do case (1) está no topo da pilha.
                # O valor do switch (3) está na variável guardada.
                
                idx_case_temp = self.next_var_index + 205
                self.emit(f"   astore {idx_case_temp}\n") # Salva o 1 temporariamente
                
                self.emit(f"   aload {config['expr_index']}\n") # Carrega o 3
                self.emit(f"   aload {idx_case_temp}\n")       # Carrega o 1
                
                # Compara
                self.emit("   invokevirtual java/lang/Object/equals(Ljava/lang/Object;)Z\n")
                
                # SE FOR FALSO (0), PULA para o próximo label
                self.emit(f"   ifeq {config['lbl_next_case']}\n")
                
                # Limpa o ID para não confundir com outras expressões
                config['current_case_expr_id'] = None
                return
            
        parent = ctx.parentCtx
        # Verifica se o pai é um ternário
        if parent and hasattr(parent, 'QUESTION') and parent.QUESTION():
            # Verifica se somos a expressão do meio (entre ? e :)
            # Estrutura: [Condição] ? [ExpressãoTrue] : [ExpressãoFalse]
            # Indices:      0      1        2         3        4
            if parent.getChild(2) is ctx:
                config = self.ternary_stack[-1]
                
                # Terminamos a parte verdadeira, então GOTO FIM
                self.emit(f"   goto {config['lbl_end']}\n")
                
                # Aqui começa a parte falsa (o label para onde o IFEQ lá de cima pulou)
                self.emit(f"{config['lbl_false']}:\n")

    def exitForStatement(self, ctx):
        lbl_start, lbl_end = self.loop_labels.pop()
        config = self.for_config_stack.pop()
        
        if config['inc_id']:
            inc_code = self.for_increment_buffer.pop()
            self.emit(inc_code)
            
        self.emit(f"   goto {lbl_start}\n")
        self.emit(f"{lbl_end}:\n")

    # -----------------------------------------------------------
    # CORREÇÃO: STATEMENT com IF sem ELSE
    # -----------------------------------------------------------
    def exitStatement(self, ctx):
        # Verificamos se acabamos de sair do bloco "TRUE" de um IF
        if self.if_stack:
            config = self.if_stack[-1]
            if id(ctx) == config['stmt_true_id']:
                # CORREÇÃO: Verifica se tem ELSE
                parent = ctx.parentCtx
                has_else = False
                
                # Busca o ifStatement pai e verifica statement count
                while parent:
                    if hasattr(parent, 'getRuleIndex'):
                        try:
                            # Se for ifStatement e tiver 2+ statements, tem else
                            if hasattr(parent, 'statement') and len(parent.statement()) > 1:
                                has_else = True
                                break
                        except:
                            pass
                    parent = parent.parentCtx
                
                if has_else:
                    self.emit(f"   goto {config['lbl_end']}\n")
                    self.emit(f"{config['lbl_else']}:\n")
                else:
                    # CORREÇÃO: Sem else, apenas emite o label
                    self.emit(f"{config['lbl_else']}:\n")
        
        # CORREÇÃO: Console.log SEM conversão booleana (1 é 1, não "true")
        if self.em_console_log and ctx.getText().startswith("console.log"):
            self.emit("   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V\n")
            self.em_console_log = False
            return
        
        # Descarta valores de expressões statement
        if ctx.expression() and ctx.SEMI():
            is_assignment = False
            expr = ctx.expression()
            if expr.assignmentExpression() and expr.assignmentExpression().assignmentOperator():
                is_assignment = True
            
            texto_expr = expr.getText()
            
            if not is_assignment and 'console.log' not in ctx.getText() and not self.capturing_increment:
                self.emit("   pop\n")

    def process_template_literal(self, template):
        content = template[1:-1]
        
        if '${' not in content:
            self.emit(f'   ldc "{content}"\n')
            return
        
        parts = []
        current = ""
        i = 0
        
        while i < len(content):
            if i < len(content) - 1 and content[i:i+2] == '${':
                if current:
                    parts.append(('string', current))
                    current = ""
                
                i += 2
                expr = ""
                brace_count = 1
                while i < len(content) and brace_count > 0:
                    if content[i] == '{':
                        brace_count += 1
                    elif content[i] == '}':
                        brace_count -= 1
                        if brace_count == 0:
                            break
                    expr += content[i]
                    i += 1
                
                parts.append(('expr', expr.strip()))
            else:
                current += content[i]
            i += 1
        
        if current:
            parts.append(('string', current))
        
        if not parts:
            self.emit('   ldc ""\n')
            return
        
        first = parts[0]
        if first[0] == 'string':
            self.emit(f'   ldc "{first[1]}"\n')
        else:
            var_name = first[1]
            if self.inside_method and var_name in self.var_map_local:
                idx = self.var_map_local[var_name]['index']
                self.emit(f"   aload {idx}\n")
            elif var_name in self.var_map_main:
                idx = self.var_map_main[var_name]['index']
                self.emit(f"   aload {idx}\n")
            
            self.emit("   invokestatic java/lang/String/valueOf(Ljava/lang/Object;)Ljava/lang/String;\n")
        
        for part_type, part_value in parts[1:]:
            if part_type == 'string':
                self.emit(f'   ldc "{part_value}"\n')
            else:
                var_name = part_value
                if self.inside_method and var_name in self.var_map_local:
                    idx = self.var_map_local[var_name]['index']
                    self.emit(f"   aload {idx}\n")
                elif var_name in self.var_map_main:
                    idx = self.var_map_main[var_name]['index']
                    self.emit(f"   aload {idx}\n")
                
                self.emit("   invokestatic java/lang/String/valueOf(Ljava/lang/Object;)Ljava/lang/String;\n")
            
            self.emit("   invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String;\n")

# ============= FIM DA PARTE 1 =============
# Continue na PARTE 2...

# ============= PARTE 2 - Cole após a PARTE 1 =============
    # -----------------------------------------------------------
    # CRIAÇÃO DE OBJETOS (NEW)
    # -----------------------------------------------------------
    def exitNewExpression(self, ctx):
        # Pega o nome da classe. Dependendo da sua gramática, pode ser:
        # ctx.singleExpression().getText() ou ctx.Identifier().getText()
        # Vou usar um método seguro que pega o texto do filho apropriado
        
        texto = ctx.getText() # Ex: "new Date()"
        
        # Extrai o nome da classe (remove o 'new ' e os '()')
        # Forma simplificada: verificar string contains
        
        if "Date" in texto:
            self.emit("   new java/util/Date\n")
            self.emit("   dup\n")
            self.emit("   invokespecial java/util/Date/<init>()V\n")
            return

        # Exemplo para Arrays via construtor: new Array()
        if "Array" in texto or "ArrayList" in texto:
            self.emit("   new java/util/ArrayList\n")
            self.emit("   dup\n")
            self.emit("   invokespecial java/util/ArrayList/<init>()V\n")
            return
            
    # -----------------------------------------------------------
    # FUNÇÕES
    # -----------------------------------------------------------
    def enterFunctionDeclaration(self, ctx):
        if ctx.Identifier():
            nome_funcao = ctx.Identifier().getText()
            self.methods_code += f".method public static {nome_funcao}(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;\n"
            self.methods_code += "   .limit stack 300\n"
            self.methods_code += "   .limit locals 300\n"
            self.inside_method = True
            self.var_map_local = {} 
            self.next_var_index = 0 

    def exitFunctionDeclaration(self, ctx):
        self.emit("   aconst_null\n")
        self.emit("   areturn\n")
        
        self.methods_code += ".end method\n\n"
        self.inside_method = False
        self.next_var_index = 1

    def enterVariableDeclarator(self, ctx):
        texto = ctx.getText()
        
        # Lógica para ARROW FUNCTION (=>) ou FUNCTION tradicional
        if "=>" in texto or ("function" in texto and ctx.ASSIGN()):
            nome_funcao = ctx.Identifier().getText()
            
            # --- NOVO: Registra que este nome é uma função ---
            self.defined_functions.add(nome_funcao)
            # -------------------------------------------------

            # Cria assinatura do método
            self.methods_code += f".method public static {nome_funcao}(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;\n"
            self.methods_code += "   .limit stack 300\n"
            self.methods_code += "   .limit locals 300\n"
            self.inside_method = True
            self.var_map_local = {} 
            
            # --- Extração de Parâmetros da Arrow Function ---
            if "=>" in texto:
                # Pega o que está antes da seta
                parte_params = texto.split("=>")[0]
                # Remove o nome da variável e o igual
                parte_params = parte_params.split("=")[1].strip()
                
                # Remove parênteses se houver
                parte_params = parte_params.replace("(", "").replace(")", "")
                
                idx = 0
                if parte_params:
                    params = parte_params.split(",")
                    for p in params:
                        p_nome = p.strip()
                        if p_nome:
                            self.var_map_local[p_nome] = {'index': idx}
                            idx += 1
                self.next_var_index = idx

                # Verifica se é retorno direto (sem chaves)
                parte_corpo = texto.split("=>")[1].strip()
                if not parte_corpo.startswith("{"):
                    self.is_arrow_return = True
                else:
                    self.is_arrow_return = False
            else:
                self.next_var_index = 0 
                self.is_arrow_return = False

    def exitVariableDeclarator(self, ctx):
        # Se estávamos dentro de um método (Arrow ou Function)
        if self.inside_method:
            
            if self.is_arrow_return:
                # Se for arrow function curta (=> a+b), o valor já está na pilha.
                # Apenas retornamos ele.
                self.emit("   areturn\n")
                self.is_arrow_return = False
            else:
                # Se for bloco normal, garante retorno nulo caso falte return explícito
                self.emit("   aconst_null\n")
                self.emit("   areturn\n")
            
            self.methods_code += ".end method\n\n"
            self.inside_method = False
            self.next_var_index = 1
            
            # TRUQUE PARA EVITAR VERIFY ERROR NO MAIN:
            # Como transformamos a variável em um método estático,
            # ela tecnicamente "não existe" como variável local no main.
            # Mas o 'VariableDeclarator' espera um valor para o 'astore'.
            # Se não fizermos nada, o código do main fica quebrado.
            # Vamos apenas colocar um null e salvar na variável do main para satisfazer a JVM.
            nome = ctx.Identifier().getText()
            if nome not in self.var_map_main:
                self.var_map_main[nome] = {'index': self.next_var_index}
                self.next_var_index += 1
            info = self.var_map_main[nome]
            
            # Adiciona ao MAIN CODE, não ao methods_code
            self.main_code += "   aconst_null\n"
            self.main_code += f"   astore {info['index']}\n"

        else:
            # Lógica para variáveis normais (int a = 10;)
            nome = ctx.Identifier().getText()
            if "function" not in ctx.getText() and "=>" not in ctx.getText():
                if nome not in self.var_map_main:
                    self.var_map_main[nome] = {'index': self.next_var_index}
                    self.next_var_index += 1
                info = self.var_map_main[nome]
                if ctx.ASSIGN():
                    self.emit(f"   astore {info['index']}\n")
                else:
                    self.emit("   aconst_null\n")
                    self.emit(f"   astore {info['index']}\n")

    def enterParamList(self, ctx):
        if self.inside_method:
            idx = 0
            for param in ctx.Identifier():
                self.var_map_local[param.getText()] = {'index': idx}
                idx += 1
            self.next_var_index = idx

    def exitReturnStatement(self, ctx):
        self.emit("   areturn\n")

    # -----------------------------------------------------------
    # POSTFIX OPERATIONS
    # -----------------------------------------------------------
    def exitPostfixOp(self, ctx):
        # -----------------------------------------------------------
        # 1. CHAMADAS DE FUNÇÃO: parseInt, Math, substring, etc.
        # -----------------------------------------------------------
        if ctx.LPAREN():
            parent = ctx.parentCtx
            texto_completo = parent.getText()
            
            # --- parseInt ---
            if "parseInt(" in texto_completo:
                idx_temp = self.next_var_index + 80
                lbl_is_number = self.get_next_label()
                lbl_end = self.get_next_label()
                self.emit(f"   astore {idx_temp}\n")
                self.emit(f"   aload {idx_temp}\n")
                self.emit("   instanceof java/lang/Number\n")
                self.emit(f"   ifne {lbl_is_number}\n")
                self.emit(f"   aload {idx_temp}\n")
                self.emit("   checkcast java/lang/String\n")
                self.emit("   invokestatic java/lang/Double/parseDouble(Ljava/lang/String;)D\n")
                self.emit("   d2i\n")
                self.emit("   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n")
                self.emit(f"   goto {lbl_end}\n")
                self.emit(f"{lbl_is_number}:\n")
                self.emit(f"   aload {idx_temp}\n")
                self.emit("   checkcast java/lang/Number\n")
                self.emit("   invokevirtual java/lang/Number/intValue()I\n")
                self.emit("   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n")
                self.emit(f"{lbl_end}:\n")
                return

            # --- parseFloat ---
            if "parseFloat(" in texto_completo:
                self.emit("   checkcast java/lang/String\n")
                self.emit("   invokestatic java/lang/Double/parseDouble(Ljava/lang/String;)D\n")
                self.emit("   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;\n")
                return

            # --- Math.pow ---
            if "Math.pow" in texto_completo:
                self.emit("   invokestatic java/lang/Math/pow(DD)D\n")
                self.emit("   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;\n")
                return

            # --- Math.sqrt ---
            if "Math.sqrt" in texto_completo:
                self.emit("   checkcast java/lang/Number\n")
                self.emit("   invokevirtual java/lang/Number/doubleValue()D\n")
                self.emit("   invokestatic java/lang/Math/sqrt(D)D\n")
                self.emit("   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;\n")
                return
            
            # --- .toUpperCase ---
            if ".toUpperCase" in texto_completo:
                self.emit("   checkcast java/lang/String\n")
                self.emit("   invokevirtual java/lang/String/toUpperCase()Ljava/lang/String;\n")
                return

            # --- .substring ---
            if ".substring" in texto_completo:
                idx_fim = self.next_var_index + 10
                idx_inicio = self.next_var_index + 11
                self.emit(f"   istore {idx_fim}\n")
                self.emit(f"   istore {idx_inicio}\n")
                self.emit("   checkcast java/lang/String\n")
                self.emit(f"   iload {idx_inicio}\n")
                self.emit(f"   iload {idx_fim}\n")
                self.emit("   invokevirtual java/lang/String/substring(II)Ljava/lang/String;\n")
                return

            # --- Funções do Usuário ---
            if hasattr(parent, 'primaryExpression'):
                nome_funcao = parent.primaryExpression().getText()
                ignorar = ['console', 'Math', 'parseInt', 'parseFloat', 'BigInt']
                if nome_funcao not in ignorar:
                    self.emit(f"   invokestatic {self.nome_classe}/{nome_funcao}(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;\n")
            return

        # -----------------------------------------------------------
        # 2. INCREMENTO / DECREMENTO (++ / --)
        # -----------------------------------------------------------
        op = None
        if ctx.INC(): op = 'inc'
        elif ctx.DEC(): op = 'dec'
        
        if op:
            parent = ctx.parentCtx
            if hasattr(parent, 'primaryExpression'):
                prim = parent.primaryExpression()
                if prim and prim.Identifier():
                    nome = prim.Identifier().getText()
                    if self.inside_method and nome in self.var_map_local: 
                        info = self.var_map_local[nome]
                    else: 
                        info = self.var_map_main.get(nome)
                    
                    if info:
                        if self.capturing_increment:
                            self.emit("   checkcast java/lang/Number\n")
                            self.emit("   invokevirtual java/lang/Number/doubleValue()D\n")
                            self.emit("   dconst_1\n")
                            if op == 'inc': self.emit("   dadd\n")
                            else: self.emit("   dsub\n")
                            self.emit("   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;\n")
                            self.emit(f"   astore {info['index']}\n")
                        else:
                            idx_temp_old = self.next_var_index + 26
                            self.emit("   dup\n")
                            self.emit(f"   astore {idx_temp_old}\n")
                            self.emit("   checkcast java/lang/Number\n")
                            self.emit("   invokevirtual java/lang/Number/doubleValue()D\n")
                            self.emit("   dconst_1\n")
                            if op == 'inc': self.emit("   dadd\n")
                            else: self.emit("   dsub\n")
                            self.emit("   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;\n")
                            self.emit(f"   astore {info['index']}\n")
                            self.emit(f"   aload {idx_temp_old}\n")
            return

        # -----------------------------------------------------------
        # 3. ACESSO A PROPRIEDADES (. e ?.)
        # -----------------------------------------------------------
        if ctx.DOT() or ctx.OPTIONAL_CHAIN():
            # CORREÇÃO CRÍTICA: Ignorar .log e .pow/.sqrt manuais
            # Se não ignorarmos, ele tenta acessar essas propriedades no objeto System.out ou Math
            # o que corrompe a pilha e causa VerifyError.
            parent_txt = ctx.parentCtx.getText()
            if parent_txt.startswith("console.") or parent_txt.startswith("Math."):
                return

            prop_name = ctx.Identifier().getText()
            is_optional = (ctx.OPTIONAL_CHAIN() is not None)
            
            # Verifica se este é o último operador (para o delete)
            parent = ctx.parentCtx
            is_last_op = False
            if hasattr(parent, 'postfixOp'):
                ops = parent.postfixOp()
                if ops and ops[-1] is ctx:
                    is_last_op = True
            
            # === CENÁRIO A: DELETE (delete obj.prop) ===
            if self.pending_delete and is_last_op:
                if is_optional:
                    lbl_is_null = self.get_next_label()
                    lbl_end = self.get_next_label()
                    self.emit("   dup\n")
                    self.emit(f"   ifnull {lbl_is_null}\n")
                    self.emit("   checkcast java/util/Map\n") 
                    self.emit(f'   ldc "{prop_name}"\n')
                    self.emit("   invokeinterface java/util/Map/remove(Ljava/lang/Object;)Ljava/lang/Object; 2\n") 
                    self.emit("   pop\n")
                    self.emit(f"   goto {lbl_end}\n")
                    self.emit(f"{lbl_is_null}:\n")
                    self.emit("   pop\n")
                    self.emit(f"{lbl_end}:\n")
                    self.emit("   iconst_1\n") 
                    self.emit("   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n")
                else:
                    self.emit("   checkcast java/util/Map\n") 
                    self.emit(f'   ldc "{prop_name}"\n')
                    self.emit("   invokeinterface java/util/Map/remove(Ljava/lang/Object;)Ljava/lang/Object; 2\n")
                    self.emit("   pop\n")
                    self.emit("   iconst_1\n") 
                    self.emit("   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n")
                
                self.delete_handled = True
                self.pending_delete = False 
                return

            # === CENÁRIO B: ACESSO NORMAL (GET) ===
            if is_optional:
                lbl_is_null = self.get_next_label()
                lbl_continue = self.get_next_label()
                self.emit("   dup\n") 
                self.emit(f"   ifnull {lbl_is_null}\n")
                self.emit("   checkcast java/util/Map\n") 
                self.emit(f'   ldc "{prop_name}"\n')
                self.emit("   invokeinterface java/util/Map/get(Ljava/lang/Object;)Ljava/lang/Object; 2\n")
                self.emit(f"   goto {lbl_continue}\n")
                self.emit(f"{lbl_is_null}:\n")
                self.emit("   pop\n")       
                self.emit("   aconst_null\n")
                self.emit(f"{lbl_continue}:\n")
            else:
                self.emit("   checkcast java/util/Map\n")
                self.emit(f'   ldc "{prop_name}"\n')
                self.emit("   invokeinterface java/util/Map/get(Ljava/lang/Object;)Ljava/lang/Object; 2\n")

    def enterPostfixExpression(self, ctx):
        if ctx.getText().startswith("console.log"):
            self.em_console_log = True
            self.emit("   getstatic java/lang/System/out Ljava/io/PrintStream;\n")

# ============= FIM DA PARTE 2 =============
# Continue na PARTE 3...

# ============= PARTE 3 - Cole após a PARTE 2 =============

    # -----------------------------------------------------------
    # PRIMARY EXPRESSIONS
    # -----------------------------------------------------------
    # -----------------------------------------------------------
    # PRIMARY EXPRESSIONS (CORRIGIDO)
    # -----------------------------------------------------------
    def enterPrimaryExpression(self, ctx):
        # --- PARTE NOVA: Instanciação (NEW) ---
        if ctx.NEW():
            nome_classe = ctx.Identifier().getText()
            
            if nome_classe == "Date":
                self.emit("   new java/util/Date\n")
                self.emit("   dup\n")
            elif nome_classe == "Array" or nome_classe == "ArrayList":
                self.emit("   new java/util/ArrayList\n")
                self.emit("   dup\n")
            
            # Importante: Retorna aqui para não executar a lógica de variáveis/literais abaixo
            return 
        # --------------------------------------

        if ctx.Literal():
            val = ctx.Literal().getText()
            
            if val.startswith('`'):
                self.process_template_literal(val)
                return
            
            if val.startswith('"') or val.startswith("'"):
                self.emit(f"   ldc {val}\n")
                return
            
            elif val == 'true':
                self.emit("   iconst_1\n")
                self.emit("   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n")
                return
            
            elif val == 'false':
                self.emit("   iconst_0\n")
                self.emit("   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n")
                return
            
            elif val == 'null' or val == 'undefined':
                self.emit("   aconst_null\n")
                return
            
            else:
                if '.' in val:
                    self.emit(f'   ldc "{val}"\n')
                    return
                else:
                    try:
                        num = int(val)
                        if 0 <= num <= 5:
                            self.emit(f"   iconst_{num}\n")
                        elif -128 <= num <= 127:
                            self.emit(f"   bipush {num}\n")
                        else:
                            self.emit(f"   ldc {num}\n")
                        self.emit("   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n")
                    except:
                        pass
                return
        
        elif ctx.BigIntLiteral():
            val = ctx.BigIntLiteral().getText().replace('n', '')
            self.emit(f"   ldc2_w {val}\n")
            self.emit("   invokestatic java/lang/Long/valueOf(J)Ljava/lang/Long;\n")
            return

        elif ctx.Identifier():
            nome = ctx.Identifier().getText()
            if nome in ['console', 'Math']:
                return

            # --- CORREÇÃO DEFINITIVA ---
            # Se o nome for de uma função definida por nós (estática),
            # NÃO carregue ela na pilha. O invokestatic cuidará disso.
            if nome in self.defined_functions:
                return
            # ---------------------------

            if self.inside_method and nome in self.var_map_local:
                idx = self.var_map_local[nome]['index']
                self.emit(f"   aload {idx}\n")
            elif nome in self.var_map_main:
                idx = self.var_map_main[nome]['index']
                self.emit(f"   aload {idx}\n")

    def exitPrimaryExpression(self, ctx):
        # Finaliza o NEW chamando o construtor
        if ctx.NEW():
            nome_classe = ctx.Identifier().getText()
            
            # Verifica se tem argumentos (argList)
            # Na JVM, a assinatura muda dependendo dos argumentos.
            # Para simplificar, vamos assumir construtores vazios por enquanto,
            # ou você terá que contar os argumentos em argList.
            
            if nome_classe == "Date":
                self.emit("   invokespecial java/util/Date/<init>()V\n")
            elif nome_classe == "Array" or nome_classe == "ArrayList":
                self.emit("   invokespecial java/util/ArrayList/<init>()V\n")


    def enterUnaryExpression(self, ctx):
        if hasattr(ctx, 'DELETE') and ctx.DELETE():
            self.pending_delete = True
            self.delete_handled = False

    # -----------------------------------------------------------
    # CORREÇÃO: PRÉ-INCREMENTO (++x retorna NOVO valor)
    # -----------------------------------------------------------
    def exitUnaryExpression(self, ctx):
        # --- IMPLEMENTAÇÃO DO DELETE ---
        if hasattr(ctx, 'DELETE') and ctx.DELETE():
            # Se o delete já foi tratado no exitPostfixOp (removeu propriedade), 
            # apenas reseta a flag, pois o "true" já está na pilha.
            if self.delete_handled:
                self.delete_handled = False
                self.pending_delete = False
                return

            # Caso contrário (ex: delete 42;), remove o valor e retorna true.
            self.emit("   pop\n")
            self.emit("   iconst_1\n")
            self.emit("   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n")
            
            self.pending_delete = False
            return
        
        # --- IMPLEMENTAÇÃO DO TYPEOF ---
        if hasattr(ctx, 'TYPEOF') and ctx.TYPEOF():
            idx_temp = self.next_var_index + 150
            lbl_num = self.get_next_label()
            lbl_str = self.get_next_label()
            lbl_bool = self.get_next_label()
            lbl_list = self.get_next_label() # Array é object
            lbl_map = self.get_next_label()  # Object é object
            lbl_end = self.get_next_label()

            self.emit(f"   astore {idx_temp}\n") # Salva o valor do topo

            # Verifica Number
            self.emit(f"   aload {idx_temp}\n")
            self.emit("   instanceof java/lang/Number\n")
            self.emit(f"   ifne {lbl_num}\n")

            # Verifica String
            self.emit(f"   aload {idx_temp}\n")
            self.emit("   instanceof java/lang/String\n")
            self.emit(f"   ifne {lbl_str}\n")

            # Verifica Boolean (Assumindo Integer 0 ou 1 como bool ou classe Boolean)
            # Se você usa Integer 0/1 para bool, typeof retornará "number". 
            # Se usa java/lang/Boolean:
            self.emit(f"   aload {idx_temp}\n")
            self.emit("   instanceof java/lang/Boolean\n")
            self.emit(f"   ifne {lbl_bool}\n")

            # Verifica Objetos (List ou Map)
            self.emit(f"   aload {idx_temp}\n")
            self.emit("   instanceof java/util/List\n")
            self.emit(f"   ifne {lbl_list}\n")
            self.emit(f"   aload {idx_temp}\n")
            self.emit("   instanceof java/util/Map\n")
            self.emit(f"   ifne {lbl_map}\n")

            # Default: undefined (se for null)
            self.emit('   ldc "undefined"\n')
            self.emit(f"   goto {lbl_end}\n")

            self.emit(f"{lbl_num}:\n")
            self.emit('   ldc "number"\n')
            self.emit(f"   goto {lbl_end}\n")

            self.emit(f"{lbl_str}:\n")
            self.emit('   ldc "string"\n')
            self.emit(f"   goto {lbl_end}\n")
            
            self.emit(f"{lbl_bool}:\n")
            self.emit('   ldc "boolean"\n')
            self.emit(f"   goto {lbl_end}\n")

            self.emit(f"{lbl_list}:\n")
            self.emit(f"{lbl_map}:\n")
            self.emit('   ldc "object"\n') # Arrays e Maps são objects em JS

            self.emit(f"{lbl_end}:\n")
            return

        # --- IMPLEMENTAÇÃO DO DELETE ---
        # Nota: Delete real em compiladores requer acesso à referência (L-Value).
        # Esta implementação assume que o comando anterior colocou o MAP e a CHAVE na pilha.
        # Ex: delete obj["idade"] -> Se o parser tratar isso como uma operação binária, ok.
        # Se for unário simples, geralmente apenas retorna true sem efeito em implementações simples.
        if hasattr(ctx, 'DELETE') and ctx.DELETE():
            # Remove o valor do topo da pilha (fingindo que deletou)
            self.emit("   pop\n")
            # Retorna true (delete sempre retorna true em JS, exceto frozen)
            self.emit("   iconst_1\n")
            self.emit("   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n")
            return
        if ctx.INC() or ctx.DEC():
            primeiro = ctx.getChild(1)
            if hasattr(primeiro, 'getText'):
                nome = primeiro.getText()
                if self.inside_method and nome in self.var_map_local:
                    info = self.var_map_local[nome]
                else:
                    info = self.var_map_main.get(nome)
                
                if info:
                    idx_temp = self.next_var_index + 25
                    # CORREÇÃO: Não assumir que há valor na pilha
                    self.emit(f"   aload {info['index']}\n")
                    self.emit("   checkcast java/lang/Number\n")
                    self.emit("   invokevirtual java/lang/Number/doubleValue()D\n")
                    self.emit("   dconst_1\n")
                    if ctx.INC():
                        self.emit("   dadd\n")
                    else:
                        self.emit("   dsub\n")
                    self.emit(f"   dstore {idx_temp}\n")
                    self.emit(f"   dload {idx_temp}\n")
                    self.emit("   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;\n")
                    self.emit(f"   astore {info['index']}\n")
                    # Retorna NOVO valor
                    self.emit(f"   dload {idx_temp}\n")
                    self.emit("   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;\n")
            return

        elif ctx.TILDE():
            primeiro = ctx.getChild(1)
            if hasattr(primeiro, 'getText'):
                nome = primeiro.getText()
                if self.inside_method and nome in self.var_map_local:
                    info = self.var_map_local[nome]
                else:
                    info = self.var_map_main.get(nome)
                
                if info:
                    self.emit(f"   aload {info['index']}\n")
                    self.emit("   checkcast java/lang/Number\n")
                    self.emit("   invokevirtual java/lang/Number/intValue()I\n")
                    self.emit("   iconst_m1\n")
                    self.emit("   ixor\n")
                    self.emit("   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n")
            return
        
        if ctx.MINUS():
            self.emit("   checkcast java/lang/Number\n")
            self.emit("   invokevirtual java/lang/Number/doubleValue()D\n")
            self.emit("   dneg\n")
            self.emit("   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;\n")
            return
        
        if ctx.BANG():
            idx_temp = self.next_var_index + 75
            lbl_true = self.get_next_label()
            lbl_false = self.get_next_label()
            lbl_end = self.get_next_label()
            
            self.emit(f"   astore {idx_temp}\n")
            self.emit(f"   aload {idx_temp}\n")
            self.emit(f"   ifnull {lbl_true}\n")
            
            self.emit(f"   aload {idx_temp}\n")
            self.emit("   instanceof java/lang/Number\n")
            self.emit(f"   ifeq {lbl_false}\n")
            
            self.emit(f"   aload {idx_temp}\n")
            self.emit("   checkcast java/lang/Number\n")
            self.emit("   invokevirtual java/lang/Number/doubleValue()D\n")
            self.emit("   dconst_0\n")
            self.emit("   dcmpl\n")
            self.emit(f"   ifeq {lbl_true}\n")
            
            self.emit(f"{lbl_false}:\n")
            self.emit("   iconst_0\n")
            self.emit(f"   goto {lbl_end}\n")
            
            self.emit(f"{lbl_true}:\n")
            self.emit("   iconst_1\n")
            
            self.emit(f"{lbl_end}:\n")
            self.emit("   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n")

    # -----------------------------------------------------------
    # COMPARAÇÕES E OPERADORES
    # -----------------------------------------------------------
    def exitRelationalExpression(self, ctx):
        # --- IMPLEMENTAÇÃO DO INSTANCEOF ---
        # --- IMPLEMENTAÇÃO DO INSTANCEOF (CORRIGIDO) ---
        if hasattr(ctx, 'INSTANCEOF') and ctx.INSTANCEOF():
            tipo_nome = ctx.getChild(2).getText() # Ex: "Date", "Array" ou uma variável "MinhaClasse"
            
            # CORREÇÃO: Só faz POP se o lado direito for uma variável que colocou valor na pilha.
            # Se for apenas um nome de tipo (como Date, Array), o listener de Identifier não gerou código, 
            # então não temos nada para remover.
            is_variavel_local = self.inside_method and tipo_nome in self.var_map_local
            is_variavel_global = tipo_nome in self.var_map_main
            
            if is_variavel_local or is_variavel_global:
                self.emit("   pop\n") # Remove o valor da variável da pilha, pois instanceof só quer o nome da classe fixo
            
            lbl_true = self.get_next_label()
            lbl_false = self.get_next_label()
            lbl_end = self.get_next_label()
            
            if tipo_nome == 'Array':
                self.emit("   instanceof java/util/ArrayList\n")
            elif tipo_nome == 'Object':
                # Object em JS inclui Objetos (Map), Arrays (List) e Datas (Date)
                lbl_obj_true = self.get_next_label()
                lbl_obj_out = self.get_next_label()

                # 1. Verifica se é Map
                self.emit("   dup\n")
                self.emit("   instanceof java/util/Map\n")
                self.emit(f"   ifne {lbl_obj_true}\n")

                # 2. Verifica se é List (Array)
                self.emit("   dup\n")
                self.emit("   instanceof java/util/List\n")
                self.emit(f"   ifne {lbl_obj_true}\n")
                
                # 3. Verifica se é Date (o dup anterior é consumido aqui)
                self.emit("   instanceof java/util/Date\n")
                # Se for Date, o resultado (1) fica na pilha e vai pro final
                # Se não for, o resultado (0) fica na pilha e vai pro final
                self.emit(f"   goto {lbl_obj_out}\n")

                self.emit(f"{lbl_obj_true}:\n")
                self.emit("   pop\n")     # Remove o objeto duplicado da pilha
                self.emit("   iconst_1\n") # Coloca TRUE (1) como resultado

                self.emit(f"{lbl_obj_out}:\n")
            elif tipo_nome == 'Date':
                # Nota: Seu código precisa suportar 'new Date' para isso funcionar 100%
                self.emit("   instanceof java/util/Date\n")
            elif tipo_nome == 'String':
                self.emit("   instanceof java/lang/String\n")
            else:
                self.emit("   instanceof java/lang/Object\n")

            self.emit(f"   ifne {lbl_true}\n")
            self.emit(f"{lbl_false}:\n")
            self.emit("   iconst_0\n")
            self.emit(f"   goto {lbl_end}\n")
            self.emit(f"{lbl_true}:\n")
            self.emit("   iconst_1\n")
            self.emit(f"{lbl_end}:\n")
            self.emit("   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n")
            return

        # --- IMPLEMENTAÇÃO DO IN ( "prop" in obj ) ---
        # --- IMPLEMENTAÇÃO DO IN ( "prop" in obj ) ---
        if hasattr(ctx, 'IN') and ctx.IN():
            # Pilha esperada: [String "prop", Object obj] (O Map está no topo)
            
            # CORREÇÃO: Verificamos se é Map ANTES de fazer o swap
            self.emit("   checkcast java/util/Map\n") 
            
            # Agora sim invertemos para preparar a chamada da função
            self.emit("   swap\n") # Agora: [Object obj, String "prop"]
            
            # Verificamos se a chave é válida (Object)
            self.emit("   checkcast java/lang/Object\n") 
            
            # Chama containsKey(key) -> consome Map e Key (2 itens)
            self.emit("   invokeinterface java/util/Map/containsKey(Ljava/lang/Object;)Z 2\n")
            
            lbl_true = self.get_next_label()
            lbl_end = self.get_next_label()
            
            self.emit(f"   ifne {lbl_true}\n")
            self.emit("   iconst_0\n")
            self.emit(f"   goto {lbl_end}\n")
            self.emit(f"{lbl_true}:\n")
            self.emit("   iconst_1\n")
            self.emit(f"{lbl_end}:\n")
            self.emit("   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n")
            return
        
        if ctx.LT() or ctx.GT() or ctx.LE() or ctx.GE():
            idx_temp = self.next_var_index + 20
            
            self.emit("   checkcast java/lang/Number\n")
            self.emit("   invokevirtual java/lang/Number/doubleValue()D\n")
            self.emit(f"   dstore {idx_temp}\n")
            
            self.emit("   checkcast java/lang/Number\n")
            self.emit("   invokevirtual java/lang/Number/doubleValue()D\n")
            self.emit(f"   dload {idx_temp}\n")
            
            self.emit("   dcmpg\n")
            
            lbl_true = self.get_next_label()
            lbl_end = self.get_next_label()
            
            if ctx.LT():
                self.emit(f"   iflt {lbl_true}\n")
            elif ctx.GT():
                self.emit(f"   ifgt {lbl_true}\n")
            elif ctx.LE():
                self.emit(f"   ifle {lbl_true}\n")
            elif ctx.GE():
                self.emit(f"   ifge {lbl_true}\n")
            
            self.emit("   iconst_0\n")
            self.emit(f"   goto {lbl_end}\n")
            self.emit(f"{lbl_true}:\n")
            self.emit("   iconst_1\n")
            self.emit(f"{lbl_end}:\n")
            self.emit("   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n")

    def exitAdditiveExpression(self, ctx):
        num_plus = len(ctx.PLUS()) if ctx.PLUS() else 0
        num_minus = len(ctx.MINUS()) if ctx.MINUS() else 0
        
        if num_plus > 0:
            for i in range(num_plus):
                lbl_concat = self.get_next_label()
                lbl_add = self.get_next_label()
                lbl_fim = self.get_next_label()
                idx_temp1 = self.next_var_index + 20
                idx_temp2 = self.next_var_index + 21
                
                self.emit(f"   astore {idx_temp2}\n")
                self.emit(f"   astore {idx_temp1}\n")
                
                self.emit(f"   aload {idx_temp1}\n")
                self.emit("   instanceof java/lang/String\n")
                self.emit(f"   ifne {lbl_concat}\n")
                self.emit(f"   aload {idx_temp2}\n")
                self.emit("   instanceof java/lang/String\n")
                self.emit(f"   ifne {lbl_concat}\n")
                
                self.emit(f"   goto {lbl_add}\n")
                
                self.emit(f"{lbl_concat}:\n")
                self.emit(f"   aload {idx_temp1}\n")
                self.emit("   invokestatic java/lang/String/valueOf(Ljava/lang/Object;)Ljava/lang/String;\n")
                self.emit(f"   aload {idx_temp2}\n")
                self.emit("   invokestatic java/lang/String/valueOf(Ljava/lang/Object;)Ljava/lang/String;\n")
                self.emit("   invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String;\n")
                self.emit(f"   goto {lbl_fim}\n")
                
                self.emit(f"{lbl_add}:\n")
                self.emit(f"   aload {idx_temp1}\n")
                self.emit("   checkcast java/lang/Number\n")
                self.emit("   invokevirtual java/lang/Number/doubleValue()D\n")
                self.emit(f"   aload {idx_temp2}\n")
                self.emit("   checkcast java/lang/Number\n")
                self.emit("   invokevirtual java/lang/Number/doubleValue()D\n")
                self.emit("   dadd\n")
                self.emit("   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;\n")
                
                self.emit(f"{lbl_fim}:\n")
        
        elif num_minus > 0:
            for i in range(num_minus):
                idx_temp = self.next_var_index + 20
                self.emit(f"   astore {idx_temp}\n")
                self.emit("   checkcast java/lang/Number\n")
                self.emit("   invokevirtual java/lang/Number/doubleValue()D\n")
                self.emit(f"   aload {idx_temp}\n")
                self.emit("   checkcast java/lang/Number\n")
                self.emit("   invokevirtual java/lang/Number/doubleValue()D\n")
                self.emit("   dsub\n")
                self.emit("   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;\n")

    def exitMultiplicativeExpression(self, ctx):
        if ctx.STAR() or ctx.SLASH() or ctx.PERCENT():
            idx_temp = self.next_var_index + 20
            self.emit(f"   astore {idx_temp}\n")
            self.emit("   checkcast java/lang/Number\n")
            self.emit("   invokevirtual java/lang/Number/doubleValue()D\n")
            self.emit(f"   aload {idx_temp}\n")
            self.emit("   checkcast java/lang/Number\n")
            self.emit("   invokevirtual java/lang/Number/doubleValue()D\n")
            if ctx.STAR():
                self.emit("   dmul\n")
            elif ctx.SLASH():
                self.emit("   ddiv\n")
            elif ctx.PERCENT():
                self.emit("   drem\n")
            self.emit("   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;\n")

    def exitExponentExpression(self, ctx):
        if hasattr(ctx, 'POWER') and ctx.POWER():
            idx_temp = self.next_var_index + 20
            self.emit(f"   astore {idx_temp}\n")
            self.emit("   checkcast java/lang/Number\n")
            self.emit("   invokevirtual java/lang/Number/doubleValue()D\n")
            self.emit(f"   aload {idx_temp}\n")
            self.emit("   checkcast java/lang/Number\n")
            self.emit("   invokevirtual java/lang/Number/doubleValue()D\n")
            self.emit("   invokestatic java/lang/Math/pow(DD)D\n")
            self.emit("   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;\n")

# ============= FIM DA PARTE 3 =============
# Continue na PARTE 4 (FINAL)...

# ============= PARTE 4 FINAL - Cole após a PARTE 3 =============

    # -----------------------------------------------------------
    # LOOPS ADICIONAIS
    # -----------------------------------------------------------
    def enterDoWhileStatement(self, ctx):
        lbl_start = self.get_next_label()
        lbl_end = self.get_next_label()
        self.loop_labels.append((lbl_start, lbl_end))
        self.emit(f"{lbl_start}:\n")

    def exitDoWhileStatement(self, ctx):
        lbl_start, lbl_end = self.loop_labels.pop()
        self.emit("   checkcast java/lang/Number\n")
        self.emit("   invokevirtual java/lang/Number/intValue()I\n")
        self.emit(f"   ifne {lbl_start}\n")
        self.emit(f"{lbl_end}:\n")
    
    def enterWhileStatement(self, ctx):
        lbl_start = self.get_next_label()
        lbl_end = self.get_next_label()
        self.loop_labels.append((lbl_start, lbl_end))
        self.emit(f"{lbl_start}:\n")
        
        # Salva o ID da expressão de condição
        if not hasattr(self, 'while_config_stack'):
            self.while_config_stack = []
        
        expr_ctx = ctx.expression()
        self.while_config_stack.append({
            'expr_id': id(expr_ctx)
        })

    def exitWhileStatement(self, ctx):
        lbl_start, lbl_end = self.loop_labels.pop()
        self.while_config_stack.pop()
        
        # Volta para o início do loop
        self.emit(f"   goto {lbl_start}\n")
        # Label de saída
        self.emit(f"{lbl_end}:\n")

    # -----------------------------------------------------------
    # CORREÇÃO: SWITCH STATEMENT
    # -----------------------------------------------------------
    def enterSwitchStatement(self, ctx):
        # Cria label para o final de todo o switch (usado pelo break)
        lbl_end_switch = self.get_next_label()
        
        # Variável temporária para guardar o valor da expressão do switch
        switch_expr_index = self.next_var_index + 200
        
        # Pega o ID da expressão principal (ex: 'dia')
        expr_ctx = ctx.expression()
        
        # Inicia configuração na pilha
        if not hasattr(self, 'switch_stack'):
            self.switch_stack = []
            
        self.switch_stack.append({
            'lbl_break': lbl_end_switch,   # Onde ir se der break
            'expr_index': switch_expr_index, # Onde está salvo o valor de 'dia'
            'main_expr_id': id(expr_ctx),  # ID para identificar a expressão do switch
            'current_case_expr_id': None,  # Vai guardar o ID da expressão do 'case' atual
            'lbl_next_case': None          # Label para pular se o case falhar
        })

    def exitSwitchStatement(self, ctx):
        config = self.switch_stack.pop()
        self.emit(f"{config['lbl_break']}:\n")

    def enterSwitchCase(self, ctx):
        if not self.switch_stack: return
        config = self.switch_stack[-1]
        
        # Pega a expressão deste case (ex: o número 1 ou 2)
        # Nota: SwitchCase geralmente tem children: [CASE, expression, COLON, statement...]
        expr_ctx = ctx.expression() # No ANTLR o método expression() pega a child expression
        
        if expr_ctx:
            # Salva o ID para capturarmos no exitExpression
            config['current_case_expr_id'] = id(expr_ctx)
            
            # Cria um label para pular este case se a comparação falhar
            lbl_skip = self.get_next_label()
            config['lbl_next_case'] = lbl_skip

    def exitSwitchCase(self, ctx):
        if not self.switch_stack: return
        config = self.switch_stack[-1]
        
        # Se tínhamos um label de pulo configurado (casos com expression)
        if config['lbl_next_case']:
            self.emit(f"{config['lbl_next_case']}:\n")
            config['lbl_next_case'] = None

    def enterDefaultCase(self, ctx):
        # Na nova lógica, o label de pulo do caso anterior 
        # já foi posicionado pelo exitSwitchCase.
        # Então, não precisamos fazer nada aqui.
        pass

    def exitDefaultCase(self, ctx):
        pass

    def exitBreakStatement(self, ctx):
        # Verifica se estamos num switch primeiro
        if hasattr(self, 'switch_stack') and self.switch_stack:
            config = self.switch_stack[-1]
            self.emit(f"   goto {config['lbl_break']}\n")
            
        elif self.loop_labels:
            _, lbl_end = self.loop_labels[-1]
            self.emit(f"   goto {lbl_end}\n")

    # -----------------------------------------------------------
    # ASSIGNMENT
    # -----------------------------------------------------------
    def exitAssignmentExpression(self, ctx):
        if ctx.assignmentOperator():
            op = ctx.assignmentOperator()
            nome = ctx.getChild(0).getText()
            if '.' in nome or '[' in nome or '(' in nome:
                return
            if self.inside_method and nome in self.var_map_local:
                info = self.var_map_local[nome]
            else:
                info = self.var_map_main.get(nome)
            
            if info:
                if op.ASSIGN():
                    self.emit(f"   astore {info['index']}\n")
                else:
                    idx_temp = self.next_var_index + 30
                    self.emit(f"   astore {idx_temp}\n")
                    
                    if op.PLUSEQ():
                        lbl_concat = self.get_next_label()
                        lbl_add = self.get_next_label()
                        lbl_fim = self.get_next_label()
                        idx_temp2 = self.next_var_index + 31
                        
                        self.emit(f"   astore {idx_temp2}\n")
                        
                        self.emit(f"   aload {idx_temp2}\n")
                        self.emit("   instanceof java/lang/String\n")
                        self.emit(f"   ifne {lbl_concat}\n")
                        self.emit(f"   aload {idx_temp}\n")
                        self.emit("   instanceof java/lang/String\n")
                        self.emit(f"   ifne {lbl_concat}\n")
                        self.emit(f"   goto {lbl_add}\n")
                        
                        self.emit(f"{lbl_concat}:\n")
                        self.emit(f"   aload {idx_temp2}\n")
                        self.emit("   invokestatic java/lang/String/valueOf(Ljava/lang/Object;)Ljava/lang/String;\n")
                        self.emit(f"   aload {idx_temp}\n")
                        self.emit("   invokestatic java/lang/String/valueOf(Ljava/lang/Object;)Ljava/lang/String;\n")
                        self.emit("   invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String;\n")
                        self.emit(f"   goto {lbl_fim}\n")
                        
                        self.emit(f"{lbl_add}:\n")
                        self.emit(f"   aload {idx_temp2}\n")
                        self.emit("   checkcast java/lang/Number\n")
                        self.emit("   invokevirtual java/lang/Number/doubleValue()D\n")
                        self.emit(f"   aload {idx_temp}\n")
                        self.emit("   checkcast java/lang/Number\n")
                        self.emit("   invokevirtual java/lang/Number/doubleValue()D\n")
                        self.emit("   dadd\n")
                        self.emit("   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;\n")
                        
                        self.emit(f"{lbl_fim}:\n")
                        
                    elif op.MINUSEQ() or op.STAREQ() or op.SLASHEQ() or op.PERCENTEQ():
                        self.emit("   checkcast java/lang/Number\n")
                        self.emit("   invokevirtual java/lang/Number/doubleValue()D\n")
                        self.emit(f"   aload {idx_temp}\n")
                        self.emit("   checkcast java/lang/Number\n")
                        self.emit("   invokevirtual java/lang/Number/doubleValue()D\n")
                        
                        if op.MINUSEQ():
                            self.emit("   dsub\n")
                        elif op.STAREQ():
                            self.emit("   dmul\n")
                        elif op.SLASHEQ():
                            self.emit("   ddiv\n")
                        elif op.PERCENTEQ():
                            self.emit("   drem\n")
                        
                        self.emit("   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;\n")
                    
                    elif op.POWEQ():
                        self.emit("   checkcast java/lang/Number\n")
                        self.emit("   invokevirtual java/lang/Number/doubleValue()D\n")
                        self.emit(f"   aload {idx_temp}\n")
                        self.emit("   checkcast java/lang/Number\n")
                        self.emit("   invokevirtual java/lang/Number/doubleValue()D\n")
                        self.emit("   invokestatic java/lang/Math/pow(DD)D\n")
                        self.emit("   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;\n")
                    
                    self.emit(f"   astore {info['index']}\n")

    def exitEqualityExpression(self, ctx):
        if ctx.EQ() or ctx.SEQ() or ctx.NE() or ctx.SNE():
            is_loose = ctx.EQ() or ctx.NE()
            is_strict = ctx.SEQ() or ctx.SNE()
            is_negated = ctx.NE() or ctx.SNE()
            
            idx_temp1 = self.next_var_index + 60
            idx_temp2 = self.next_var_index + 61
            
            self.emit(f"   astore {idx_temp2}\n")
            self.emit(f"   astore {idx_temp1}\n")
            
            if is_loose:
                lbl_string_to_num1 = self.get_next_label()
                lbl_string_to_num2 = self.get_next_label()
                lbl_use_equals = self.get_next_label()
                lbl_true = self.get_next_label()
                lbl_false = self.get_next_label()
                lbl_end = self.get_next_label()
                
                self.emit(f"   aload {idx_temp1}\n")
                self.emit("   instanceof java/lang/Number\n")
                self.emit(f"   ifeq {lbl_string_to_num2}\n")
                self.emit(f"   aload {idx_temp2}\n")
                self.emit("   instanceof java/lang/String\n")
                self.emit(f"   ifeq {lbl_string_to_num2}\n")
                
                self.emit(f"   goto {lbl_string_to_num1}\n")
                
                self.emit(f"{lbl_string_to_num2}:\n")
                self.emit(f"   aload {idx_temp1}\n")
                self.emit("   instanceof java/lang/String\n")
                self.emit(f"   ifeq {lbl_use_equals}\n")
                self.emit(f"   aload {idx_temp2}\n")
                self.emit("   instanceof java/lang/Number\n")
                self.emit(f"   ifeq {lbl_use_equals}\n")
                
                self.emit(f"   aload {idx_temp1}\n")
                self.emit("   checkcast java/lang/String\n")
                self.emit("   invokestatic java/lang/Double/parseDouble(Ljava/lang/String;)D\n")
                self.emit(f"   aload {idx_temp2}\n")
                self.emit("   checkcast java/lang/Number\n")
                self.emit("   invokevirtual java/lang/Number/doubleValue()D\n")
                self.emit("   dcmpl\n")
                
                if is_negated:
                    self.emit(f"   ifne {lbl_true}\n")
                else:
                    self.emit(f"   ifeq {lbl_true}\n")
                self.emit(f"   goto {lbl_false}\n")
                
                self.emit(f"{lbl_string_to_num1}:\n")
                self.emit(f"   aload {idx_temp1}\n")
                self.emit("   checkcast java/lang/Number\n")
                self.emit("   invokevirtual java/lang/Number/doubleValue()D\n")
                self.emit(f"   aload {idx_temp2}\n")
                self.emit("   checkcast java/lang/String\n")
                self.emit("   invokestatic java/lang/Double/parseDouble(Ljava/lang/String;)D\n")
                self.emit("   dcmpl\n")
                
                if is_negated:
                    self.emit(f"   ifne {lbl_true}\n")
                else:
                    self.emit(f"   ifeq {lbl_true}\n")
                self.emit(f"   goto {lbl_false}\n")
                
                self.emit(f"{lbl_use_equals}:\n")
                self.emit(f"   aload {idx_temp1}\n")
                self.emit(f"   aload {idx_temp2}\n")
                self.emit("   invokevirtual java/lang/Object/equals(Ljava/lang/Object;)Z\n")
                
                if is_negated:
                    self.emit(f"   ifeq {lbl_true}\n")
                else:
                    self.emit(f"   ifne {lbl_true}\n")
                
                self.emit(f"{lbl_false}:\n")
                self.emit("   iconst_0\n")
                self.emit(f"   goto {lbl_end}\n")
                
                self.emit(f"{lbl_true}:\n")
                self.emit("   iconst_1\n")
                
                self.emit(f"{lbl_end}:\n")
                self.emit("   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n")
                
            else:
                self.emit(f"   aload {idx_temp1}\n")
                self.emit(f"   aload {idx_temp2}\n")
                self.emit("   invokevirtual java/lang/Object/equals(Ljava/lang/Object;)Z\n")
                
                lbl_true = self.get_next_label()
                lbl_end = self.get_next_label()
                
                if is_negated:
                    self.emit(f"   ifeq {lbl_true}\n")
                else:
                    self.emit(f"   ifne {lbl_true}\n")
                    
                self.emit("   iconst_0\n")
                self.emit(f"   goto {lbl_end}\n")
                self.emit(f"{lbl_true}:\n")
                self.emit("   iconst_1\n")
                self.emit(f"{lbl_end}:\n")
                self.emit("   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n")

    # -----------------------------------------------------------
    # OPERADOR TERNÁRIO ( ? : )
    # -----------------------------------------------------------
    def enterConditionalExpression(self, ctx):
        if ctx.QUESTION():
            # Se tem '?', é um ternário. Criamos os labels.
            lbl_false = self.get_next_label()
            lbl_end = self.get_next_label()
            
            self.ternary_stack.append({
                'lbl_false': lbl_false,
                'lbl_end': lbl_end
            })

    def exitConditionalExpression(self, ctx):
        if ctx.QUESTION():
            # Finaliza o ternário colocando o label de FIM
            config = self.ternary_stack.pop()
            self.emit(f"{config['lbl_end']}:\n")

    # Operadores bitwise e lógicos (mantidos iguais)
    def exitBitwiseAndExpression(self, ctx):
        if ctx.B_AND():
            num_ops = len(ctx.B_AND())
            for _ in range(num_ops):
                idx_temp = self.next_var_index + 20
                self.emit("   checkcast java/lang/Number\n")
                self.emit("   invokevirtual java/lang/Number/intValue()I\n")
                self.emit(f"   istore {idx_temp}\n")
                self.emit("   checkcast java/lang/Number\n")
                self.emit("   invokevirtual java/lang/Number/intValue()I\n")
                self.emit(f"   iload {idx_temp}\n")
                self.emit("   iand\n")
                self.emit("   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n")

    def exitBitwiseOrExpression(self, ctx):
        if ctx.B_OR():
            num_ops = len(ctx.B_OR())
            for _ in range(num_ops):
                idx_temp = self.next_var_index + 20
                self.emit("   checkcast java/lang/Number\n")
                self.emit("   invokevirtual java/lang/Number/intValue()I\n")
                self.emit(f"   istore {idx_temp}\n")
                self.emit("   checkcast java/lang/Number\n")
                self.emit("   invokevirtual java/lang/Number/intValue()I\n")
                self.emit(f"   iload {idx_temp}\n")
                self.emit("   ior\n")
                self.emit("   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n")

    def exitBitwiseXorExpression(self, ctx):
        if ctx.CARET():
            num_ops = len(ctx.CARET())
            for _ in range(num_ops):
                idx_temp = self.next_var_index + 20
                self.emit("   checkcast java/lang/Number\n")
                self.emit("   invokevirtual java/lang/Number/intValue()I\n")
                self.emit(f"   istore {idx_temp}\n")
                self.emit("   checkcast java/lang/Number\n")
                self.emit("   invokevirtual java/lang/Number/intValue()I\n")
                self.emit(f"   iload {idx_temp}\n")
                self.emit("   ixor\n")
                self.emit("   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n")

    def exitShiftExpression(self, ctx):
        if ctx.LSHIFT() or ctx.RSHIFT():
            num_ops = len(ctx.LSHIFT()) if ctx.LSHIFT() else len(ctx.RSHIFT())
            for i in range(num_ops):
                idx_temp = self.next_var_index + 20
                self.emit("   checkcast java/lang/Number\n")
                self.emit("   invokevirtual java/lang/Number/intValue()I\n")
                self.emit(f"   istore {idx_temp}\n")
                self.emit("   checkcast java/lang/Number\n")
                self.emit("   invokevirtual java/lang/Number/intValue()I\n")
                self.emit(f"   iload {idx_temp}\n")
                if ctx.LSHIFT():
                    self.emit("   ishl\n")
                else:
                    self.emit("   ishr\n")
                self.emit("   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n")

    def exitLogicalAndExpression(self, ctx):
        if ctx.AND():
            num_ops = len(ctx.AND())
            for _ in range(num_ops):
                idx_temp1 = self.next_var_index + 76
                idx_temp2 = self.next_var_index + 77
                lbl_check_second = self.get_next_label()
                lbl_return_first = self.get_next_label()
                lbl_end = self.get_next_label()
                
                self.emit(f"   astore {idx_temp2}\n")
                self.emit(f"   astore {idx_temp1}\n")
                
                self.emit(f"   aload {idx_temp1}\n")
                self.emit(f"   ifnull {lbl_return_first}\n")
                
                self.emit(f"   aload {idx_temp1}\n")
                self.emit("   instanceof java/lang/Number\n")
                self.emit(f"   ifeq {lbl_check_second}\n")
                
                self.emit(f"   aload {idx_temp1}\n")
                self.emit("   checkcast java/lang/Number\n")
                self.emit("   invokevirtual java/lang/Number/doubleValue()D\n")
                self.emit("   dconst_0\n")
                self.emit("   dcmpl\n")
                self.emit(f"   ifeq {lbl_return_first}\n")
                
                self.emit(f"{lbl_check_second}:\n")
                self.emit(f"   aload {idx_temp2}\n")
                self.emit(f"   goto {lbl_end}\n")
                
                self.emit(f"{lbl_return_first}:\n")
                self.emit(f"   aload {idx_temp1}\n")
                
                self.emit(f"{lbl_end}:\n")

    def exitLogicalOrExpression(self, ctx):
        if ctx.OR():
            num_ops = len(ctx.OR())
            for _ in range(num_ops):
                idx_temp1 = self.next_var_index + 78
                idx_temp2 = self.next_var_index + 79
                lbl_check_second = self.get_next_label()
                lbl_return_first = self.get_next_label()
                lbl_end = self.get_next_label()
                
                self.emit(f"   astore {idx_temp2}\n")
                self.emit(f"   astore {idx_temp1}\n")
                
                self.emit(f"   aload {idx_temp1}\n")
                self.emit(f"   ifnull {lbl_check_second}\n")
                
                self.emit(f"   aload {idx_temp1}\n")
                self.emit("   instanceof java/lang/Number\n")
                self.emit(f"   ifeq {lbl_return_first}\n")
                
                self.emit(f"   aload {idx_temp1}\n")
                self.emit("   checkcast java/lang/Number\n")
                self.emit("   invokevirtual java/lang/Number/doubleValue()D\n")
                self.emit("   dconst_0\n")
                self.emit("   dcmpl\n")
                self.emit(f"   ifne {lbl_return_first}\n")
                
                self.emit(f"{lbl_check_second}:\n")
                self.emit(f"   aload {idx_temp2}\n")
                self.emit(f"   goto {lbl_end}\n")
                
                self.emit(f"{lbl_return_first}:\n")
                self.emit(f"   aload {idx_temp1}\n")
                
                self.emit(f"{lbl_end}:\n")
        
        parent = ctx.parentCtx
        # Verifica se o pai é um ConditionalExpression (tem '?') e se nós somos a condição (primeiro filho)
        if parent and hasattr(parent, 'QUESTION') and parent.QUESTION():
            if parent.getChild(0) is ctx:
                config = self.ternary_stack[-1]
                
                self.emit("   checkcast java/lang/Number\n")
                self.emit("   invokevirtual java/lang/Number/intValue()I\n")
                # Se a condição for falsa (0), pula para o bloco do ':', senão segue reto
                self.emit(f"   ifeq {config['lbl_false']}\n")

    def exitArrayLiteral(self, ctx):
        self.emit("   new java/util/ArrayList\n")
        self.emit("   dup\n")
        self.emit("   invokespecial java/util/ArrayList/<init>()V\n")
        
        idx_list = self.next_var_index + 100
        self.emit(f"   astore {idx_list}\n")
        
        # CORREÇÃO: Processar expressões na ordem correta
        if ctx.expression():
            exprs = list(ctx.expression())
            num_exprs = len(exprs)
            
            # Guarda valores em ordem REVERSA (pilha é LIFO)
            for i in range(num_exprs - 1, -1, -1):
                idx = self.next_var_index + 110 + i
                self.emit(f"   astore {idx}\n")
            
            # Adiciona na lista em ordem NORMAL (0, 1, 2...)
            for i in range(num_exprs):
                idx = self.next_var_index + 110 + i
                self.emit(f"   aload {idx_list}\n")
                self.emit(f"   aload {idx}\n")
                self.emit("   invokeinterface java/util/List/add(Ljava/lang/Object;)Z 2\n")
                self.emit("   pop\n")
        
        self.emit(f"   aload {idx_list}\n")

    def exitObjectLiteral(self, ctx):
        self.emit("   new java/util/HashMap\n")
        self.emit("   dup\n")
        self.emit("   invokespecial java/util/HashMap/<init>()V\n")
        
        idx_map = self.next_var_index + 101
        self.emit(f"   astore {idx_map}\n")
        
        # CORREÇÃO: Processar propriedades na ordem correta
        if ctx.objProp():
            props = list(ctx.objProp())
            num_props = len(props)
            
            # Guarda valores em ordem REVERSA
            for i in range(num_props - 1, -1, -1):
                idx_val = self.next_var_index + 110 + i
                self.emit(f"   astore {idx_val}\n")
            
            # Adiciona no HashMap em ordem NORMAL
            for i, prop in enumerate(props):
                key = prop.Identifier().getText()
                idx_val = self.next_var_index + 110 + i
                
                self.emit(f"   aload {idx_map}\n")
                self.emit(f'   ldc "{key}"\n')
                self.emit(f"   aload {idx_val}\n")
                self.emit("   invokevirtual java/util/HashMap/put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;\n")
                self.emit("   pop\n")
        
        self.emit(f"   aload {idx_map}\n")
# ============= FIM DO ARQUIVO =============



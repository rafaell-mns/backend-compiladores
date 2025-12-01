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
        
        # NOVO: Pilha para controlar IFs aninhados
        self.if_stack = [] 
        
        self.var_map_main = {}   
        self.var_map_local = {}  
        self.next_var_index = 1 
        self.label_counter = 0
        self.em_console_log = False
        self.last_type = 'int'

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
    # LÓGICA DO IF / ELSE (ADICIONADO AGORA)
    # -----------------------------------------------------------
    def enterIfStatement(self, ctx):
        lbl_else = self.get_next_label()
        lbl_end = self.get_next_label()
        
        # Identifica os filhos para saber quando gerar os pulos
        expr_ctx = ctx.expression()
        stmt_true = ctx.statement(0)
        
        # Guarda na pilha para usar nos exits correspondentes
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
    # LÓGICA DO FOR (MANTIDA)
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

    # --- EXPRESSÕES (Com suporte a IF e FOR) ---
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
                # Se expressão for falsa (0), pula para o Else
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

    def exitForStatement(self, ctx):
        lbl_start, lbl_end = self.loop_labels.pop()
        config = self.for_config_stack.pop()
        
        if config['inc_id']:
            inc_code = self.for_increment_buffer.pop()
            self.emit(inc_code)
            
        self.emit(f"   goto {lbl_start}\n")
        self.emit(f"{lbl_end}:\n")

    def is_boolean_expression(self, ctx):
        """Detecta se a expressão é booleana (comparação, lógica, etc)"""
        if not ctx:
            return False
        
        texto = ctx.getText()
        
        # Verifica operadores booleanos
        boolean_ops = ['==', '!=', '===', '!==', '<', '>', '<=', '>=', 
                    '&&', '||', '!', 'true', 'false']
        
        return any(op in texto for op in boolean_ops)

    def exitStatement(self, ctx):
        # ... (código do IF e console.log que você já tem) ...
        # Lógica do console.log
        if self.em_console_log and ctx.getText().startswith("console.log"):
            # Lidar com múltiplos argumentos no console.log é complexo no Jasmin simples.
            # O ideal é imprimir apenas o topo ou concatenar. 
            # Sua lógica atual imprime um e retorna. Certifique-se de que consome tudo da pilha.
            # Para este exercício, assumiremos que seu console.log atual funciona para 1 argumento.
            if hasattr(ctx, 'expression') and ctx.expression():
                expr = ctx.expression()
                if self.is_boolean_expression(expr):
                    self.convert_boolean_to_string()
            
            self.emit("   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V\n")
            self.em_console_log = False
            return
        
        if ctx.expression() and ctx.SEMI():
            # VERIFICAÇÃO CRÍTICA:
            # Se for uma atribuição (ex: x = 10), o exitAssignmentExpression já fez 'astore'.
            # A pilha está vazia. Não devemos dar POP.
            is_assignment = False
            expr = ctx.expression()
            # Navega na árvore para ver se tem operador de atribuição
            if expr.assignmentExpression() and expr.assignmentExpression().assignmentOperator():
                is_assignment = True
            
            # Verifica outras condições
            texto_expr = expr.getText()
            starts_compound = texto_expr.startswith('{') or texto_expr.startswith('[') or texto_expr.startswith('function')
            is_call = texto_expr.endswith(')') and ('=' not in texto_expr)
            
            # Só dá POP se NÃO for atribuição
            if 'console.log' not in ctx.getText() and not self.capturing_increment and (not starts_compound) and (not is_call) and (not is_assignment):
                self.emit("   pop\n")

    def convert_boolean_to_string(self):
        """Converte Integer(0) -> 'false' e Integer(1) -> 'true' antes de imprimir"""
        idx_temp = self.next_var_index + 50
        lbl_is_int = self.get_next_label()
        lbl_check_value = self.get_next_label()
        lbl_is_false = self.get_next_label()
        lbl_is_true = self.get_next_label()
        lbl_end = self.get_next_label()
        
        # Salva o valor
        self.emit(f"   astore {idx_temp}\n")
        self.emit(f"   aload {idx_temp}\n")
        
        # Verifica se é Integer
        self.emit("   instanceof java/lang/Integer\n")
        self.emit(f"   ifne {lbl_is_int}\n")
        
        # Não é Integer - mantém original
        self.emit(f"   aload {idx_temp}\n")
        self.emit(f"   goto {lbl_end}\n")
        
        # É Integer - verifica o valor
        self.emit(f"{lbl_is_int}:\n")
        self.emit(f"   aload {idx_temp}\n")
        self.emit("   checkcast java/lang/Integer\n")
        self.emit("   invokevirtual java/lang/Integer/intValue()I\n")
        self.emit("   dup\n")
        
        # Se for 0, converte para "false"
        self.emit(f"   ifeq {lbl_is_false}\n")
        
        # Se for 1, converte para "true"
        self.emit("   iconst_1\n")
        self.emit(f"   if_icmpeq {lbl_is_true}\n")
        
        # Se não for 0 nem 1, mantém o Integer original
        self.emit(f"   aload {idx_temp}\n")
        self.emit(f"   goto {lbl_end}\n")
        
        # Converte 0 -> "false"
        self.emit(f"{lbl_is_false}:\n")
        self.emit("   pop\n")
        self.emit('   ldc "false"\n')
        self.emit(f"   goto {lbl_end}\n")
        
        # Converte 1 -> "true"
        self.emit(f"{lbl_is_true}:\n")
        self.emit('   ldc "true"\n')
        
        self.emit(f"{lbl_end}:\n")

    def process_template_literal(self, template):
        """
        Processa template literals: `texto ${var} mais texto`
        Converte para: "texto " + var + " mais texto"
        """
        # Remove os backticks
        content = template[1:-1]
        
        # Se não tem interpolação, trata como string normal
        if '${' not in content:
            self.emit(f'   ldc "{content}"\n')
            return
        
        # Divide o template em partes
        parts = []
        current = ""
        i = 0
        
        while i < len(content):
            if i < len(content) - 1 and content[i:i+2] == '${':
                # Encontrou início de interpolação
                if current:
                    parts.append(('string', current))
                    current = ""
                
                # Encontra o fim da interpolação
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
        
        # Gera código para concatenar as partes
        if not parts:
            self.emit('   ldc ""\n')
            return
        
        # Primeiro elemento
        first = parts[0]
        if first[0] == 'string':
            self.emit(f'   ldc "{first[1]}"\n')
        else:
            # Carrega a variável
            var_name = first[1]
            if self.inside_method and var_name in self.var_map_local:
                idx = self.var_map_local[var_name]['index']
                self.emit(f"   aload {idx}\n")
            elif var_name in self.var_map_main:
                idx = self.var_map_main[var_name]['index']
                self.emit(f"   aload {idx}\n")
            
            # Converte para String
            self.emit("   invokestatic java/lang/String/valueOf(Ljava/lang/Object;)Ljava/lang/String;\n")
        
        # Concatena com os demais elementos
        for part_type, part_value in parts[1:]:
            if part_type == 'string':
                self.emit(f'   ldc "{part_value}"\n')
            else:
                # Carrega a variável
                var_name = part_value
                if self.inside_method and var_name in self.var_map_local:
                    idx = self.var_map_local[var_name]['index']
                    self.emit(f"   aload {idx}\n")
                elif var_name in self.var_map_main:
                    idx = self.var_map_main[var_name]['index']
                    self.emit(f"   aload {idx}\n")
                
                # Converte para String
                self.emit("   invokestatic java/lang/String/valueOf(Ljava/lang/Object;)Ljava/lang/String;\n")
            
            # Concatena
            self.emit("   invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String;\n")

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
        # CORREÇÃO: Adiciona return null se a função não tem return explícito
        self.emit("   aconst_null\n")
        self.emit("   areturn\n")
        
        self.methods_code += ".end method\n\n"
        self.inside_method = False
        self.next_var_index = 1

    def enterVariableDeclarator(self, ctx):
        if ctx.expression() and ctx.expression().assignmentExpression():
            if "function" in ctx.getText() and ctx.ASSIGN():
                nome_funcao = ctx.Identifier().getText()
                self.methods_code += f".method public static {nome_funcao}(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;\n"
                self.methods_code += "   .limit stack 300\n"  # Alterado para 300
                self.methods_code += "   .limit locals 300\n" # Alterado para 300
                self.inside_method = True
                self.var_map_local = {} 
                self.next_var_index = 0 

    def exitVariableDeclarator(self, ctx):
        if self.inside_method:
            # CORREÇÃO: Adiciona return null
            self.emit("   aconst_null\n")
            self.emit("   areturn\n")
            
            self.methods_code += ".end method\n\n"
            self.inside_method = False
            self.next_var_index = 1
        else:
            nome = ctx.Identifier().getText()
            if "function" not in ctx.getText():
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

    def exitPostfixOp(self, ctx):
        if ctx.LPAREN():
            parent = ctx.parentCtx
            texto_completo = parent.getText()
            
            # parseInt - Converte string para inteiro
            if "parseInt(" in texto_completo:
                idx_temp = self.next_var_index + 80
                lbl_is_string = self.get_next_label()
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
        
            # parseFloat - Converte string para decimal
            if "parseFloat(" in texto_completo:
                idx_temp = self.next_var_index + 81
                lbl_is_string = self.get_next_label()
                lbl_is_number = self.get_next_label()
                lbl_end = self.get_next_label()
                
                self.emit(f"   astore {idx_temp}\n")
                self.emit(f"   aload {idx_temp}\n")
                self.emit("   instanceof java/lang/Number\n")
                self.emit(f"   ifne {lbl_is_number}\n")
                
                self.emit(f"   aload {idx_temp}\n")
                self.emit("   checkcast java/lang/String\n")
                self.emit("   invokestatic java/lang/Double/parseDouble(Ljava/lang/String;)D\n")
                self.emit("   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;\n")
                self.emit(f"   goto {lbl_end}\n")
                
                self.emit(f"{lbl_is_number}:\n")
                self.emit(f"   aload {idx_temp}\n")
                self.emit("   checkcast java/lang/Number\n")
                self.emit("   invokevirtual java/lang/Number/doubleValue()D\n")
                self.emit("   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;\n")
                
                self.emit(f"{lbl_end}:\n")
                return

            if "BigInt(" in texto_completo:
                idx_temp = self.next_var_index + 82
                lbl_is_string = self.get_next_label()
                lbl_is_number = self.get_next_label()
                lbl_end = self.get_next_label()
                
                self.emit(f"   astore {idx_temp}\n")
                self.emit(f"   aload {idx_temp}\n")
                self.emit("   instanceof java/lang/String\n")
                self.emit(f"   ifne {lbl_is_string}\n")
                
                self.emit(f"   aload {idx_temp}\n")
                self.emit("   checkcast java/lang/Number\n")
                self.emit("   invokevirtual java/lang/Number/longValue()J\n")
                self.emit("   invokestatic java/lang/Long/valueOf(J)Ljava/lang/Long;\n")
                self.emit(f"   goto {lbl_end}\n")
                
                self.emit(f"{lbl_is_string}:\n")
                self.emit(f"   aload {idx_temp}\n")
                self.emit("   checkcast java/lang/String\n")
                self.emit("   invokestatic java/lang/Long/parseLong(Ljava/lang/String;)J\n")
                self.emit("   invokestatic java/lang/Long/valueOf(J)Ljava/lang/Long;\n")
                
                self.emit(f"{lbl_end}:\n")
                return

            # Math
            if "Math.pow" in texto_completo:
                idx_b = self.next_var_index + 15
                self.emit("   checkcast java/lang/Number\n")
                self.emit("   invokevirtual java/lang/Number/doubleValue()D\n")
                self.emit(f"   dstore {idx_b}\n")
                self.emit("   checkcast java/lang/Number\n")
                self.emit("   invokevirtual java/lang/Number/doubleValue()D\n")
                self.emit(f"   dload {idx_b}\n")
                self.emit("   invokestatic java/lang/Math/pow(DD)D\n")
                self.emit("   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;\n")
                return

            if "Math.sqrt" in texto_completo:
                self.emit("   checkcast java/lang/Number\n")
                self.emit("   invokevirtual java/lang/Number/doubleValue()D\n")
                self.emit("   invokestatic java/lang/Math/sqrt(D)D\n")
                self.emit("   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;\n")
                return
            
            # String
            if ".toUpperCase" in texto_completo:
                self.emit("   checkcast java/lang/String\n")
                self.emit("   invokevirtual java/lang/String/toUpperCase()Ljava/lang/String;\n")
                return

            if ".substring" in texto_completo:
                idx_fim = self.next_var_index + 10
                idx_inicio = self.next_var_index + 11
                self.emit("   checkcast java/lang/Number\n")
                self.emit("   invokevirtual java/lang/Number/intValue()I\n")
                self.emit(f"   istore {idx_fim}\n")
                self.emit("   checkcast java/lang/Number\n")
                self.emit("   invokevirtual java/lang/Number/intValue()I\n")
                self.emit(f"   istore {idx_inicio}\n")
                self.emit("   checkcast java/lang/String\n")
                self.emit(f"   iload {idx_inicio}\n")
                self.emit(f"   iload {idx_fim}\n")
                self.emit("   invokevirtual java/lang/String/substring(II)Ljava/lang/String;\n")
                return

            if hasattr(parent, 'primaryExpression'):
                nome_funcao = parent.primaryExpression().getText()
                if nome_funcao in ['console', 'Math', 'parseInt', 'parseFloat', 'BigInt']: 
                    return
                self.emit(f"   invokestatic {self.nome_classe}/{nome_funcao}(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;\n")
            return

        # PÓS-INCREMENTO E PÓS-DECREMENTO
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
                        # CORREÇÃO: Detecta se está no incremento do for
                        is_for_increment = self.capturing_increment
                        
                        if is_for_increment:
                            # NO FOR: A variável já está na pilha (primaryExpression carregou)
                            # Apenas incrementa SEM carregar novamente
                            self.emit("   checkcast java/lang/Number\n")
                            self.emit("   invokevirtual java/lang/Number/doubleValue()D\n")
                            self.emit("   dconst_1\n")
                            if op == 'inc': 
                                self.emit("   dadd\n")
                            else: 
                                self.emit("   dsub\n")
                            self.emit("   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;\n")
                            self.emit(f"   astore {info['index']}\n")
                        else:
                            # NORMAL: retorna valor antigo (pós-incremento)
                            idx_temp_old = self.next_var_index + 26
                            
                            self.emit("   dup\n")
                            self.emit(f"   astore {idx_temp_old}\n")
                            self.emit("   checkcast java/lang/Number\n")
                            self.emit("   invokevirtual java/lang/Number/doubleValue()D\n")
                            self.emit("   dconst_1\n")
                            if op == 'inc': 
                                self.emit("   dadd\n")
                            else: 
                                self.emit("   dsub\n")
                            self.emit("   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;\n")
                            self.emit(f"   astore {info['index']}\n")
                            self.emit(f"   aload {idx_temp_old}\n")

    # --- CONSOLE.LOG ---
    def enterPostfixExpression(self, ctx):
        if ctx.getText().startswith("console.log"):
            self.em_console_log = True
            self.emit("   getstatic java/lang/System/out Ljava/io/PrintStream;\n")

    # --- EXPRESSÕES ---
    def enterPrimaryExpression(self, ctx):
        if ctx.Literal():
            val = ctx.Literal().getText()
            
            # NOVO: Processa template literals
            if val.startswith('`'):
                self.process_template_literal(val)
                return  # IMPORTANTE: return aqui para não processar o resto
            
            # Strings normais
            if val.startswith('"') or val.startswith("'"):
                self.emit(f"   ldc {val}\n")
                return  # Adiciona return
                
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
                    self.emit(f"   ldc2_w {val}\n")
                    self.emit("   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;\n")
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
            
            if self.inside_method and nome in self.var_map_local:
                idx = self.var_map_local[nome]['index']
                self.emit(f"   aload {idx}\n")
            elif nome in self.var_map_main:
                idx = self.var_map_main[nome]['index']
                self.emit(f"   aload {idx}\n")

        # acesso a propriedade: obj.prop (suporte simples em cadeia)
        # nota: ctx.getText() pode juntar tokens; essa implementação supõe primaryExpression com dots
        children = list(ctx.getChildren())
        if len(children) >= 3:
            # detecta padrão Identifier . Identifier (. Identifier)*
            seq = [c.getText() for c in children]
            if '.' in seq:
                # o walker normalmente já carregou a base (Identifier) acima;
                # garantimos comportamento por segurança: se base é variável, já foi carregada.
                # para cada acesso .prop fazemos get() do HashMap
                # não tentamos carregar um novo valor da var_map aqui (redução de complexidade)
                # assumimos stack: [objeto]
                for i, tok in enumerate(seq):
                    if tok == '.':
                        prop = seq[i+1]
                        self.emit("   checkcast java/util/HashMap\n")
                        self.emit(f'   ldc "{prop}"\n')
                        self.emit("   invokevirtual java/util/HashMap/get(Ljava/lang/Object;)Ljava/lang/Object;\n")

    # --- UNÁRIO ---
    def exitUnaryExpression(self, ctx):
        if ctx.INC() or ctx.DEC():
            self.emit("   pop\n") # <--- ADICIONE ISSO (Limpa o valor automático)

            primeiro = ctx.getChild(1)
            if hasattr(primeiro, 'getText'):
                nome = primeiro.getText()
                if self.inside_method and nome in self.var_map_local: info = self.var_map_local[nome]
                else: info = self.var_map_main.get(nome)
                if info:
                    idx_temp = self.next_var_index + 25
                    self.emit(f"   aload {info['index']}\n") # Carrega manual
                    self.emit("   checkcast java/lang/Number\n")
                    self.emit("   invokevirtual java/lang/Number/doubleValue()D\n")
                    self.emit("   dconst_1\n")
                    if ctx.INC(): self.emit("   dadd\n")
                    else: self.emit("   dsub\n")
                    self.emit(f"   dstore {idx_temp}\n")
                    self.emit(f"   dload {idx_temp}\n")
                    self.emit("   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;\n")
                    self.emit(f"   astore {info['index']}\n")
                    self.emit(f"   dload {idx_temp}\n")
                    self.emit("   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;\n") 

        elif ctx.TILDE():
            self.emit("   pop\n") # <--- ADICIONE ISSO AQUI TAMBÉM

            primeiro = ctx.getChild(1)
            if hasattr(primeiro, 'getText'):
                nome = primeiro.getText()
                if self.inside_method and nome in self.var_map_local: info = self.var_map_local[nome]
                else: info = self.var_map_main.get(nome)
                
                if info:
                    self.emit(f"   aload {info['index']}\n")
                    self.emit("   checkcast java/lang/Number\n")
                    self.emit("   invokevirtual java/lang/Number/intValue()I\n")
                    self.emit("   iconst_m1\n") # -1
                    self.emit("   ixor\n")       # Bitwise XOR
                    self.emit("   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n")

    # --- COMPARAÇÃO ---
    def exitRelationalExpression(self, ctx):
        if ctx.LT() or ctx.GT() or ctx.LE() or ctx.GE():
            # Desempilha e converte para Double
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
            
            if ctx.LT(): self.emit(f"   iflt {lbl_true}\n") 
            elif ctx.GT(): self.emit(f"   ifgt {lbl_true}\n")
            elif ctx.LE(): self.emit(f"   ifle {lbl_true}\n")
            elif ctx.GE(): self.emit(f"   ifge {lbl_true}\n")
                
            self.emit("   iconst_0\n")
            self.emit(f"   goto {lbl_end}\n")
            self.emit(f"{lbl_true}:\n")
            self.emit("   iconst_1\n")
            self.emit(f"{lbl_end}:\n")
            self.emit("   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n")

    # --- MATEMÁTICA ---
    def exitAdditiveExpression(self, ctx):
        # Conta quantas operações PLUS ou MINUS existem
        num_plus = len(ctx.PLUS()) if ctx.PLUS() else 0
        num_minus = len(ctx.MINUS()) if ctx.MINUS() else 0
        
        # Se houver operação de PLUS
        if num_plus > 0:
            # Para cada operação PLUS (processa da direita para esquerda na pilha)
            for i in range(num_plus):
                lbl_concat = self.get_next_label()
                lbl_add = self.get_next_label()
                lbl_fim = self.get_next_label()
                idx_temp1 = self.next_var_index + 20
                idx_temp2 = self.next_var_index + 21
                
                # Salva os dois operandos em variáveis temporárias
                self.emit(f"   astore {idx_temp2}\n")  # Segundo operando
                self.emit(f"   astore {idx_temp1}\n")  # Primeiro operando
                
                # Verifica se algum é String
                self.emit(f"   aload {idx_temp1}\n")
                self.emit("   instanceof java/lang/String\n")
                self.emit(f"   ifne {lbl_concat}\n")
                self.emit(f"   aload {idx_temp2}\n")
                self.emit("   instanceof java/lang/String\n")
                self.emit(f"   ifne {lbl_concat}\n")
                
                # Ambos são números - fazer adição
                self.emit(f"   goto {lbl_add}\n")
                
                # Label de concatenação
                self.emit(f"{lbl_concat}:\n")
                self.emit(f"   aload {idx_temp1}\n")
                self.emit("   invokestatic java/lang/String/valueOf(Ljava/lang/Object;)Ljava/lang/String;\n")
                self.emit(f"   aload {idx_temp2}\n")
                self.emit("   invokestatic java/lang/String/valueOf(Ljava/lang/Object;)Ljava/lang/String;\n")
                self.emit("   invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String;\n")
                self.emit(f"   goto {lbl_fim}\n")
                
                # Label de adição numérica
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
        
        # Se houver operação de MINUS
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
        # CORREÇÃO: Adicionado suporte para PERCENT (%)
        # A gramática já tem: (STAR | SLASH | PERCENT)
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
                self.emit("   drem\n")  # Operador de resto para doubles
            self.emit("   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;\n")

    def exitExponentExpression(self, ctx):
        # Nome correto da regra: exponentExpression (não exponentiationExpression)
        # Token correto: POWER (não POW)
        if hasattr(ctx, 'POWER') and ctx.POWER():
            idx_temp = self.next_var_index + 20
            # O segundo operando (expoente) está no topo da pilha
            self.emit(f"   astore {idx_temp}\n")
            # O primeiro operando (base) está abaixo
            self.emit("   checkcast java/lang/Number\n")
            self.emit("   invokevirtual java/lang/Number/doubleValue()D\n")
            # Carrega o expoente
            self.emit(f"   aload {idx_temp}\n")
            self.emit("   checkcast java/lang/Number\n")
            self.emit("   invokevirtual java/lang/Number/doubleValue()D\n")
            # Chama Math.pow(base, expoente)
            self.emit("   invokestatic java/lang/Math/pow(DD)D\n")
            self.emit("   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;\n")

    def enterDoWhileStatement(self, ctx):
        lbl_start = self.get_next_label()
        lbl_end = self.get_next_label()
        self.loop_labels.append((lbl_start, lbl_end))
        self.emit(f"{lbl_start}:\n")

    def exitDoWhileStatement(self, ctx):
        lbl_start, lbl_end = self.loop_labels.pop()
        # A expressão já está na pilha (foi processada pelo exitExpression)
        self.emit("   checkcast java/lang/Number\n")
        self.emit("   invokevirtual java/lang/Number/intValue()I\n")
        # Se a condição for verdadeira (!=0), volta para o início
        self.emit(f"   ifne {lbl_start}\n")
        # Label de saída (quando a condição é falsa)
        self.emit(f"{lbl_end}:\n")
        
    def enterWhileStatement(self, ctx):
        lbl_start = self.get_next_label()
        lbl_end = self.get_next_label()
        self.loop_labels.append((lbl_start, lbl_end))
        self.emit(f"{lbl_start}:\n")

    def exitWhileStatement(self, ctx):
        pass

    def exitAssignmentExpression(self, ctx):
        if ctx.assignmentOperator():
            op = ctx.assignmentOperator()
            nome = ctx.getChild(0).getText()
            if '.' in nome or '[' in nome or '(' in nome: return
            if self.inside_method and nome in self.var_map_local: info = self.var_map_local[nome]
            else: info = self.var_map_main.get(nome)
            
            if info:
                # Atribuição simples (=)
                if op.ASSIGN():
                    self.emit(f"   astore {info['index']}\n")
                
                # Atribuições compostas (+=, -=, *=, /=, %=, **=)
                else:
                    idx_temp = self.next_var_index + 30
                    
                    # O valor da expressão à direita está no topo da pilha
                    # O valor de x (à esquerda) está abaixo
                    self.emit(f"   astore {idx_temp}\n")  # Salva valor direito
                    
                    # Agora x está no topo. Precisamos fazer a operação.
                    
                    # Para += com strings, trata concatenação
                    if op.PLUSEQ():
                        lbl_concat = self.get_next_label()
                        lbl_add = self.get_next_label()
                        lbl_fim = self.get_next_label()
                        idx_temp2 = self.next_var_index + 31
                        
                        self.emit(f"   astore {idx_temp2}\n")  # Salva x
                        
                        # Verifica se algum é String
                        self.emit(f"   aload {idx_temp2}\n")
                        self.emit("   instanceof java/lang/String\n")
                        self.emit(f"   ifne {lbl_concat}\n")
                        self.emit(f"   aload {idx_temp}\n")
                        self.emit("   instanceof java/lang/String\n")
                        self.emit(f"   ifne {lbl_concat}\n")
                        self.emit(f"   goto {lbl_add}\n")
                        
                        # Concatenação
                        self.emit(f"{lbl_concat}:\n")
                        self.emit(f"   aload {idx_temp2}\n")
                        self.emit("   invokestatic java/lang/String/valueOf(Ljava/lang/Object;)Ljava/lang/String;\n")
                        self.emit(f"   aload {idx_temp}\n")
                        self.emit("   invokestatic java/lang/String/valueOf(Ljava/lang/Object;)Ljava/lang/String;\n")
                        self.emit("   invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String;\n")
                        self.emit(f"   goto {lbl_fim}\n")
                        
                        # Adição numérica
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
                        
                    # Operações aritméticas (-=, *=, /=, %=)
                    elif op.MINUSEQ() or op.STAREQ() or op.SLASHEQ() or op.PERCENTEQ():
                        # x está na pilha, valor direito em temp
                        self.emit("   checkcast java/lang/Number\n")
                        self.emit("   invokevirtual java/lang/Number/doubleValue()D\n")
                        self.emit(f"   aload {idx_temp}\n")
                        self.emit("   checkcast java/lang/Number\n")
                        self.emit("   invokevirtual java/lang/Number/doubleValue()D\n")
                        
                        if op.MINUSEQ(): self.emit("   dsub\n")
                        elif op.STAREQ(): self.emit("   dmul\n")
                        elif op.SLASHEQ(): self.emit("   ddiv\n")
                        elif op.PERCENTEQ(): self.emit("   drem\n")
                        
                        self.emit("   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;\n")
                    
                    # Exponenciação (**=)
                    elif op.POWEQ():
                        # x está na pilha (base), valor direito em temp (expoente)
                        self.emit("   checkcast java/lang/Number\n")
                        self.emit("   invokevirtual java/lang/Number/doubleValue()D\n")
                        self.emit(f"   aload {idx_temp}\n")
                        self.emit("   checkcast java/lang/Number\n")
                        self.emit("   invokevirtual java/lang/Number/doubleValue()D\n")
                        self.emit("   invokestatic java/lang/Math/pow(DD)D\n")
                        self.emit("   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;\n")
                    
                    # Guarda o resultado na variável
                    self.emit(f"   astore {info['index']}\n")

    def exitEqualityExpression(self, ctx):
        if ctx.EQ() or ctx.SEQ() or ctx.NE() or ctx.SNE():
            is_loose = ctx.EQ() or ctx.NE()  # == ou != (loose)
            is_strict = ctx.SEQ() or ctx.SNE()  # === ou !== (strict)
            is_negated = ctx.NE() or ctx.SNE()  # != ou !==
            
            idx_temp1 = self.next_var_index + 60
            idx_temp2 = self.next_var_index + 61
            
            # Salva os operandos
            self.emit(f"   astore {idx_temp2}\n")  # operando direito
            self.emit(f"   astore {idx_temp1}\n")  # operando esquerdo
            
            if is_loose:
                # Comparação loose (==) - com coerção de tipos
                lbl_both_numbers = self.get_next_label()
                lbl_string_to_num1 = self.get_next_label()
                lbl_string_to_num2 = self.get_next_label()
                lbl_use_equals = self.get_next_label()
                lbl_true = self.get_next_label()
                lbl_false = self.get_next_label()
                lbl_end = self.get_next_label()
                
                # Verifica se temp1 é Number e temp2 é String
                self.emit(f"   aload {idx_temp1}\n")
                self.emit("   instanceof java/lang/Number\n")
                self.emit(f"   ifeq {lbl_string_to_num2}\n")
                self.emit(f"   aload {idx_temp2}\n")
                self.emit("   instanceof java/lang/String\n")
                self.emit(f"   ifeq {lbl_string_to_num2}\n")
                
                # temp1 é Number, temp2 é String - converte String para Number e compara
                self.emit(f"   goto {lbl_string_to_num1}\n")
                
                # Verifica se temp1 é String e temp2 é Number
                self.emit(f"{lbl_string_to_num2}:\n")
                self.emit(f"   aload {idx_temp1}\n")
                self.emit("   instanceof java/lang/String\n")
                self.emit(f"   ifeq {lbl_use_equals}\n")
                self.emit(f"   aload {idx_temp2}\n")
                self.emit("   instanceof java/lang/Number\n")
                self.emit(f"   ifeq {lbl_use_equals}\n")
                
                # temp1 é String, temp2 é Number - converte String para Number
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
                
                # Caso: temp1 é Number, temp2 é String
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
                
                # Usa equals() para outros casos
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
                # Comparação strict (===) - sem coerção
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

    def exitConditionalExpression(self, ctx):
        # conditionalExpression: logicalOrExpression (QUESTION expression COLON assignmentExpression)?
        if ctx.QUESTION() and ctx.COLON():
            # Neste ponto a pilha tem: [condiÃ§Ã£o, valor_se_true, valor_se_false]
            # Precisamos reorganizar para avaliar a condiÃ§Ã£o primeiro
            
            idx_false_val = self.next_var_index + 90
            idx_true_val = self.next_var_index + 91
            idx_condition = self.next_var_index + 92
            
            lbl_true = self.get_next_label()
            lbl_false = self.get_next_label()
            lbl_end = self.get_next_label()
            
            # Salva os valores (ordem: false, true, condiÃ§Ã£o)
            self.emit(f"   astore {idx_false_val}\n")   # valor se falso (Ãºltimo avaliado)
            self.emit(f"   astore {idx_true_val}\n")    # valor se verdadeiro
            self.emit(f"   astore {idx_condition}\n")   # condiÃ§Ã£o
            
            # Avalia a condiÃ§Ã£o
            self.emit(f"   aload {idx_condition}\n")
            
            # Verifica se Ã© null (falsy)
            self.emit(f"   ifnull {lbl_false}\n")
            
            # Verifica se Ã© Number
            self.emit(f"   aload {idx_condition}\n")
            self.emit("   instanceof java/lang/Number\n")
            self.emit(f"   ifeq {lbl_true}\n")  # Se nÃ£o Ã© Number, assume truthy
            
            # Ã‰ Number - verifica se Ã© diferente de 0
            self.emit(f"   aload {idx_condition}\n")
            self.emit("   checkcast java/lang/Number\n")
            self.emit("   invokevirtual java/lang/Number/intValue()I\n")
            self.emit(f"   ifne {lbl_true}\n")  # Se != 0, vai para true
            
            # CondiÃ§Ã£o Ã© falsa - retorna valor false
            self.emit(f"{lbl_false}:\n")
            self.emit(f"   aload {idx_false_val}\n")
            self.emit(f"   goto {lbl_end}\n")
            
            # CondiÃ§Ã£o Ã© verdadeira - retorna valor true
            self.emit(f"{lbl_true}:\n")
            self.emit(f"   aload {idx_true_val}\n")
            
            self.emit(f"{lbl_end}:\n")

    def exitBitwiseAndExpression(self, ctx):
        if ctx.B_AND():
            num_ops = len(ctx.B_AND())
            for _ in range(num_ops):
                idx_temp = self.next_var_index + 20
                # Segundo operando
                self.emit("   checkcast java/lang/Number\n")
                self.emit("   invokevirtual java/lang/Number/intValue()I\n")
                self.emit(f"   istore {idx_temp}\n")
                # Primeiro operando
                self.emit("   checkcast java/lang/Number\n")
                self.emit("   invokevirtual java/lang/Number/intValue()I\n")
                self.emit(f"   iload {idx_temp}\n")
                # Operação AND
                self.emit("   iand\n")
                self.emit("   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n")

    def exitBitwiseOrExpression(self, ctx):
        if ctx.B_OR():
            num_ops = len(ctx.B_OR())
            for _ in range(num_ops):
                idx_temp = self.next_var_index + 20
                # Segundo operando
                self.emit("   checkcast java/lang/Number\n")
                self.emit("   invokevirtual java/lang/Number/intValue()I\n")
                self.emit(f"   istore {idx_temp}\n")
                # Primeiro operando
                self.emit("   checkcast java/lang/Number\n")
                self.emit("   invokevirtual java/lang/Number/intValue()I\n")
                self.emit(f"   iload {idx_temp}\n")
                # Operação OR
                self.emit("   ior\n")
                self.emit("   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n")

    def exitBitwiseXorExpression(self, ctx):
        if ctx.CARET():
            num_ops = len(ctx.CARET())
            for _ in range(num_ops):
                idx_temp = self.next_var_index + 20
                # Segundo operando
                self.emit("   checkcast java/lang/Number\n")
                self.emit("   invokevirtual java/lang/Number/intValue()I\n")
                self.emit(f"   istore {idx_temp}\n")
                # Primeiro operando
                self.emit("   checkcast java/lang/Number\n")
                self.emit("   invokevirtual java/lang/Number/intValue()I\n")
                self.emit(f"   iload {idx_temp}\n")
                # Operação XOR
                self.emit("   ixor\n")
                self.emit("   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n")

    def exitShiftExpression(self, ctx):
        if ctx.LSHIFT() or ctx.RSHIFT():
            num_ops = len(ctx.LSHIFT()) if ctx.LSHIFT() else len(ctx.RSHIFT())
            for i in range(num_ops):
                idx_temp = self.next_var_index + 20
                # Segundo operando (quantidade de bits)
                self.emit("   checkcast java/lang/Number\n")
                self.emit("   invokevirtual java/lang/Number/intValue()I\n")
                self.emit(f"   istore {idx_temp}\n")
                # Primeiro operando (valor)
                self.emit("   checkcast java/lang/Number\n")
                self.emit("   invokevirtual java/lang/Number/intValue()I\n")
                self.emit(f"   iload {idx_temp}\n")
                # Operação shift
                if ctx.LSHIFT():
                    self.emit("   ishl\n")  # shift left
                else:
                    self.emit("   ishr\n")  # shift right (aritmético)
                self.emit("   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n")

    # 1. OPERADOR NOT (!) - Negação Lógica
    def exitUnaryExpression(self, ctx):
       
        if ctx.MINUS():
                # O valor (seja variável, número ou expressão) JÁ ESTÁ na pilha.
                # Ex: [..., 42]
                
                # 1. Converte o topo para double primitivo (Unboxing seguro)
                self.emit("   checkcast java/lang/Number\n")
                self.emit("   invokevirtual java/lang/Number/doubleValue()D\n")
                
                # 2. Inverte o sinal (42.0 -> -42.0)
                self.emit("   dneg\n")
                
                # 3. Empacota de volta para Objeto (Box)
                self.emit("   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;\n")
                return
            
        # ADICIONE ESTE BLOCO para o operador NOT (!):
        if ctx.BANG():
            # O valor já está na pilha
            idx_temp = self.next_var_index + 75
            lbl_is_zero = self.get_next_label()
            lbl_is_null = self.get_next_label()
            lbl_true = self.get_next_label()
            lbl_false = self.get_next_label()
            lbl_end = self.get_next_label()
            
            self.emit(f"   astore {idx_temp}\n")
            self.emit(f"   aload {idx_temp}\n")
            
            # Verifica se é null/undefined
            self.emit(f"   ifnull {lbl_true}\n")  # null é falsy, !null = true
            
            # Verifica se é Number
            self.emit(f"   aload {idx_temp}\n")
            self.emit("   instanceof java/lang/Number\n")
            self.emit(f"   ifeq {lbl_false}\n")  # Se não é Number, assume truthy
            
            # É Number - verifica se é 0
            self.emit(f"   aload {idx_temp}\n")
            self.emit("   checkcast java/lang/Number\n")
            self.emit("   invokevirtual java/lang/Number/doubleValue()D\n")
            self.emit("   dconst_0\n")
            self.emit("   dcmpl\n")
            self.emit(f"   ifeq {lbl_true}\n")  # 0 é falsy, !0 = true
            
            # Não é 0 nem null - é truthy, !truthy = false
            self.emit(f"{lbl_false}:\n")
            self.emit("   iconst_0\n")
            self.emit(f"   goto {lbl_end}\n")
            
            # É 0 ou null - é falsy, !falsy = true
            self.emit(f"{lbl_true}:\n")
            self.emit("   iconst_1\n")
            
            self.emit(f"{lbl_end}:\n")
            self.emit("   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n")

    def exitLogicalAndExpression(self, ctx):
        if ctx.AND():
            num_ops = len(ctx.AND())
            for _ in range(num_ops):
                idx_temp1 = self.next_var_index + 76
                idx_temp2 = self.next_var_index + 77
                lbl_check_second = self.get_next_label()
                lbl_return_first = self.get_next_label()
                lbl_return_second = self.get_next_label()
                lbl_end = self.get_next_label()
                
                # Salva ambos operandos
                self.emit(f"   astore {idx_temp2}\n")  # segundo operando
                self.emit(f"   astore {idx_temp1}\n")  # primeiro operando
                
                # Verifica se o primeiro é falsy
                self.emit(f"   aload {idx_temp1}\n")
                self.emit(f"   ifnull {lbl_return_first}\n")  # null é falsy
                
                # Verifica se é Number igual a 0
                self.emit(f"   aload {idx_temp1}\n")
                self.emit("   instanceof java/lang/Number\n")
                self.emit(f"   ifeq {lbl_check_second}\n")
                
                self.emit(f"   aload {idx_temp1}\n")
                self.emit("   checkcast java/lang/Number\n")
                self.emit("   invokevirtual java/lang/Number/doubleValue()D\n")
                self.emit("   dconst_0\n")
                self.emit("   dcmpl\n")
                self.emit(f"   ifeq {lbl_return_first}\n")  # Se é 0, retorna primeiro (falsy)
                
                # Primeiro é truthy - retorna segundo
                self.emit(f"{lbl_check_second}:\n")
                self.emit(f"   aload {idx_temp2}\n")
                self.emit(f"   goto {lbl_end}\n")
                
                # Primeiro é falsy - retorna primeiro
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
                lbl_return_second = self.get_next_label()
                lbl_end = self.get_next_label()
                
                # Salva ambos operandos
                self.emit(f"   astore {idx_temp2}\n")  # segundo operando
                self.emit(f"   astore {idx_temp1}\n")  # primeiro operando
                
                # Verifica se o primeiro é truthy
                self.emit(f"   aload {idx_temp1}\n")
                self.emit(f"   ifnull {lbl_check_second}\n")  # null é falsy, testa segundo
                
                # Verifica se é Number diferente de 0
                self.emit(f"   aload {idx_temp1}\n")
                self.emit("   instanceof java/lang/Number\n")
                self.emit(f"   ifeq {lbl_return_first}\n")  # Não é Number, assume truthy
                
                self.emit(f"   aload {idx_temp1}\n")
                self.emit("   checkcast java/lang/Number\n")
                self.emit("   invokevirtual java/lang/Number/doubleValue()D\n")
                self.emit("   dconst_0\n")
                self.emit("   dcmpl\n")
                self.emit(f"   ifne {lbl_return_first}\n")  # Se não é 0, retorna primeiro (truthy)
                
                # Primeiro é falsy - retorna segundo
                self.emit(f"{lbl_check_second}:\n")
                self.emit(f"   aload {idx_temp2}\n")
                self.emit(f"   goto {lbl_end}\n")
                
                # Primeiro é truthy - retorna primeiro
                self.emit(f"{lbl_return_first}:\n")
                self.emit(f"   aload {idx_temp1}\n")
                
                self.emit(f"{lbl_end}:\n")

    # ---------------------------
    # Suporte a objetos e arrays
    # ---------------------------
    # -----------------------------------------------------------
    # CORREÇÃO DE ARRAYS E OBJETOS (Usa variável temporária)
    # -----------------------------------------------------------
    def exitArrayLiteral(self, ctx):
        # A pilha contém os valores dos elementos: [Val1, Val2, Val3...]
        # O topo é o último elemento.
        
        # 1. Cria o ArrayList
        self.emit("   new java/util/ArrayList\n")
        self.emit("   dup\n")
        self.emit("   invokespecial java/util/ArrayList/<init>()V\n")
        
        # 2. Salva o ArrayList numa variável temporária para não perder a referência
        idx_list = self.next_var_index + 100
        self.emit(f"   astore {idx_list}\n")
        
        # 3. Adiciona os itens (iterando de trás para frente, pois é Pilha LIFO)
        if ctx.expression():
            exprs = ctx.expression()
            for _ in reversed(exprs):
                # A pilha tem o valor no topo. 
                # Precisamos carregar a lista, fazer swap e adicionar.
                
                self.emit(f"   aload {idx_list}\n") # Stack: [Valor, Lista]
                self.emit("   swap\n")              # Stack: [Lista, Valor]
                self.emit("   invokeinterface java/util/List/add(Ljava/lang/Object;)Z 2\n") # Stack: [boolean]
                self.emit("   pop\n")               # Stack: [] (Limpa o retorno do add)
        
        # 4. Devolve o ArrayList para a pilha principal
        self.emit(f"   aload {idx_list}\n")

    def exitObjectLiteral(self, ctx):
        # A pilha contém os valores: [Val1, Val2...]
        
        self.emit("   new java/util/HashMap\n")
        self.emit("   dup\n")
        self.emit("   invokespecial java/util/HashMap/<init>()V\n")
        
        idx_map = self.next_var_index + 101
        self.emit(f"   astore {idx_map}\n")
        
        # Itera propriedades de trás para frente (LIFO)
        # IMPORTANTE: Certifique-se que sua gramática usa 'objProp' ou o nome correto
        if ctx.objProp(): 
            props = list(ctx.objProp())
            for prop in reversed(props):
                key = prop.Identifier().getText()
                
                # Stack tem: [Valor]
                self.emit(f"   aload {idx_map}\n") # Stack: [Valor, Map]
                self.emit("   swap\n")              # Stack: [Map, Valor]
                self.emit(f'   ldc "{key}"\n')      # Stack: [Map, Valor, Key]
                self.emit("   swap\n")              # Stack: [Map, Key, Valor] (Ordem correta para put)
                self.emit("   invokevirtual java/util/HashMap/put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;\n")
                self.emit("   pop\n")               # Remove retorno do put
        
        self.emit(f"   aload {idx_map}\n")

    def exitMemberIndexExpression(self, ctx):
        # pilha: [lista, índice]
        # precisamos garantir ordem: lista, índice -> get(I)
        # convert index to int
        self.emit("   checkcast java/lang/Number\n")
        self.emit("   invokevirtual java/lang/Number/intValue()I\n")
        # lista must be under the int, so swap if necessary is complex;
        # assumimos padrão gerado pelo parser é [lista, índice] (lista embaixo, índice no topo)
        # convert list and call get
        self.emit("   checkcast java/util/List\n")
        self.emit("   invokeinterface java/util/List/get(I)Ljava/lang/Object; 2\n")

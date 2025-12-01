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
        if ctx.expression() and ctx.expression().assignmentExpression():
            if "function" in ctx.getText() and ctx.ASSIGN():
                nome_funcao = ctx.Identifier().getText()
                self.methods_code += f".method public static {nome_funcao}(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;\n"
                self.methods_code += "   .limit stack 300\n"
                self.methods_code += "   .limit locals 300\n"
                self.inside_method = True
                self.var_map_local = {} 
                self.next_var_index = 0 

    def exitVariableDeclarator(self, ctx):
        if self.inside_method:
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

    # -----------------------------------------------------------
    # POSTFIX OPERATIONS
    # -----------------------------------------------------------
    def exitPostfixOp(self, ctx):
        if ctx.LPAREN():
            parent = ctx.parentCtx
            texto_completo = parent.getText()
            
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

        # PÓS-INCREMENTO/DECREMENTO
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
                        is_for_increment = self.capturing_increment
                        
                        if is_for_increment:
                            # NO FOR: variável já está na pilha
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
                            # NORMAL: pós-incremento (retorna valor antigo)
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
    def enterPrimaryExpression(self, ctx):
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
                # CORREÇÃO: Decimais como string para precisão
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
            
            if self.inside_method and nome in self.var_map_local:
                idx = self.var_map_local[nome]['index']
                self.emit(f"   aload {idx}\n")
            elif nome in self.var_map_main:
                idx = self.var_map_main[nome]['index']
                self.emit(f"   aload {idx}\n")

    # -----------------------------------------------------------
    # CORREÇÃO: PRÉ-INCREMENTO (++x retorna NOVO valor)
    # -----------------------------------------------------------
    def exitUnaryExpression(self, ctx):
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



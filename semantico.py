from LinguagemListener import LinguagemListener
from LinguagemParser import LinguagemParser

class AnalisadorSemantico(LinguagemListener):
    def __init__(self):
        self.tabela_simbolos = [{}] 
        self.erros = []

    def enterScope(self):
        # print("--- Entrando em novo escopo ---")
        self.tabela_simbolos.append({})

    def exitScope(self):
        # print("--- Saindo do escopo ---")
        self.tabela_simbolos.pop()

    def declare(self, nome, tipo_var, linha):
        escopo_atual = self.tabela_simbolos[-1]
        
        if nome in escopo_atual:
            # --- CORREÇÃO PARA HOISTING ---
            # Se já existe e ambos são funções, ignoramos (pois foi registrado pelo pré-processador)
            var_existente = escopo_atual[nome]
            if tipo_var == 'function' and var_existente['tipo'] == 'function':
                return 
            # ------------------------------

            self.erros.append(f"Erro Semântico (linha {linha}): Variável '{nome}' já declarada neste escopo.")
        else:
            escopo_atual[nome] = {'tipo': tipo_var}

    def lookup(self, nome):
        # Procura do escopo mais específico para o global
        for escopo in reversed(self.tabela_simbolos):
            if nome in escopo:
                return escopo[nome]
        return None

    # -------------------------------------------------------------------------
    # LISTENERS
    # -------------------------------------------------------------------------

    # 1. Registro de nomes de função (Mantido para garantir escopo local se necessário)
    # princpialmente em funcões aninhadas dentro da outra
    def enterFunctionDeclaration(self, ctx:LinguagemParser.FunctionDeclarationContext):
        if ctx.Identifier():
            nome_funcao = ctx.Identifier().getText()
            self.declare(nome_funcao, 'function', ctx.start.line)

    # 2. Gerenciamento de Escopo (Blocos) e Parâmetros
    def enterBlock(self, ctx:LinguagemParser.BlockContext):
        self.enterScope()

        # Verifica se este bloco pertence a uma função e registra os parâmetros
        parent = ctx.parentCtx
        eh_declaracao = isinstance(parent, LinguagemParser.FunctionDeclarationContext)
        eh_expressao = isinstance(parent, LinguagemParser.FunctionExpressionContext)

        if eh_declaracao or eh_expressao:
            if parent.paramList():
                for ident in parent.paramList().Identifier():
                    self.declare(ident.getText(), 'param', parent.start.line)

    def exitBlock(self, ctx:LinguagemParser.BlockContext):
        self.exitScope()

    # 3. Arrow Functions (Escopo próprio)
    def enterArrowFunction(self, ctx:LinguagemParser.ArrowFunctionContext):
        self.enterScope()
        if ctx.Identifier(): 
            self.declare(ctx.Identifier().getText(), 'param', ctx.start.line)
        elif ctx.paramList():
            for ident in ctx.paramList().Identifier():
                self.declare(ident.getText(), 'param', ctx.start.line)

    def exitArrowFunction(self, ctx:LinguagemParser.ArrowFunctionContext):
        self.exitScope()

    # 4. Declaração de Variáveis (let, const, var)
    def exitVariableDeclaration(self, ctx:LinguagemParser.VariableDeclarationContext):
        # Pega o tipo (let, const, var)
        tipo_declaracao = ctx.getChild(0).getText() 
        
        for declarator in ctx.variableDeclarator():
            nome = declarator.Identifier().getText()
            linha = declarator.start.line
            self.declare(nome, tipo_declaracao, linha)

    # 5. Validação de Atribuição (Imutabilidade de Constantes)
    def exitAssignmentExpression(self, ctx:LinguagemParser.AssignmentExpressionContext):
        if ctx.assignmentOperator():
            # Pega o identificador à esquerda
            primeiro_filho = ctx.getChild(0)
            nome_var = primeiro_filho.getText()

            # Se for acesso a objeto/array (ex: lista[0] ou obj.prop), ignoramos a checagem de const
            if '.' in nome_var or '(' in nome_var or '[' in nome_var:
                return

            info = self.lookup(nome_var)
            linha = ctx.start.line

            if info:
                if info['tipo'] == 'const':
                    self.erros.append(f"Erro Semântico (linha {linha}): Tentativa de reatribuir constante '{nome_var}'.")
            else:
                self.erros.append(f"Erro Semântico (linha {linha}): Variável '{nome_var}' não declarada.")

    # 6. Uso de Variáveis (Checagem de existência)
    def exitPrimaryExpression(self, ctx:LinguagemParser.PrimaryExpressionContext):
        # Só validamos se for um identificador isolado
        if ctx.Identifier():
            nome = ctx.Identifier().getText()
            
            # Lista de funções/objetos nativos permitidos
            nativas = [
                'console', 'Math', 'parseInt', 'parseFloat', 'window', 'document', 
                'String', 'Number', 'Boolean', 'BigInt', 'Date', 'Object', 'Array'
            ]
            
            info = self.lookup(nome)
            
            # Se não achou na tabela E não é nativa -> ERRO
            if not info and nome not in nativas:
                linha = ctx.start.line
                self.erros.append(f"Erro Semântico (linha {linha}): Variável '{nome}' não declarada (ou fora de escopo).")

# --- LISTENER PARA PRÉ-PROCESSAMENTO ---
class PreProcessadorFuncoes(LinguagemListener):
    def __init__(self, analisador_semantico):
        self.analisador = analisador_semantico

    def enterFunctionDeclaration(self, ctx:LinguagemParser.FunctionDeclarationContext):
        # Registra apenas o nome da função no escopo GLOBAL do analisador principal
        if ctx.Identifier():
            nome_funcao = ctx.Identifier().getText()
            # Usamos linha 0 ou a linha real, tanto faz, pois é só para registro
            self.analisador.declare(nome_funcao, 'function', ctx.start.line)
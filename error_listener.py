from antlr4.error.ErrorListener import ErrorListener

class MyErrorListener(ErrorListener):
    def __init__(self):
        super().__init__()
        self.errors = []

    def syntaxError(self, recognizer, offendingSymbol, line, column, msg, e):
        texto = ""

        if "<EOF>" in msg:
            texto = "Fim inesperado do arquivo. Provavelmente faltou fechar algum bloco, parêntese ou ponto e vírgula."
        
        elif "extraneous input" in msg:
            texto = f"Token inesperado '{offendingSymbol.text}'. Remova ou corrija esse trecho."
        
        elif "mismatched input" in msg:
            texto = (
                f"Símbolo inesperado '{offendingSymbol.text}'. "
                f"Talvez esteja faltando algum fechamento antes ( ) {{ }} ]."
            )
        
        elif "no viable alternative" in msg:
            texto = (
                "Expressão inválida — o parser não conseguiu entender esse trecho."
            )

        else:
            # fallback
            texto = msg

        self.errors.append(f"Erro de Sintaxe (linha {line}): {texto}")

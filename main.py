import sys
import os
from antlr4 import *
from LinguagemLexer import LinguagemLexer
from LinguagemParser import LinguagemParser
from error_listener import MyErrorListener
# Imports dos analisadores semânticos e do gerador
from semantico import AnalisadorSemantico, PreProcessadorFuncoes 
from gerador import GeradorCodigo 

def processar_arquivo(stream, nome_arquivo_saida):
    # 1. Configuração Lexer e Parser
    lexer = LinguagemLexer(stream)
    token_stream = CommonTokenStream(lexer)
    parser = LinguagemParser(token_stream)

    # 2. Tratamento de Erros Sintáticos
    parser.removeErrorListeners()
    error_listener = MyErrorListener()
    parser.addErrorListener(error_listener)
    lexer.removeErrorListeners()
    lexer.addErrorListener(error_listener)

    # 3. Geração da Árvore
    tree = parser.program()

    # Se houver erro de sintaxe, para tudo
    if error_listener.errors:
        for err in error_listener.errors:
            print(err)
        return

    # --------------------------------------------------------
    # 4. ANÁLISE SEMÂNTICA (Estratégia Two-Pass)
    # --------------------------------------------------------
    semantico = AnalisadorSemantico()
    walker = ParseTreeWalker()

    # PASSO 1: Pré-processamento (Hoisting de Funções)
    pre_processador = PreProcessadorFuncoes(semantico)
    walker.walk(pre_processador, tree)

    # PASSO 2: Validação Completa
    walker.walk(semantico, tree)

    if semantico.erros:
        for err in semantico.erros:
            print(err)
        print("Compilação cancelada devido a erros semânticos.")
        return

    # --------------------------------------------------------
    # 5. GERAÇÃO DE CÓDIGO (BACKEND - JASMIN)
    # --------------------------------------------------------
    # print("Semântica OK! Gerando código Jasmin...")
    
    # Extrai o nome da classe baseando-se no nome do arquivo (sem o caminho da pasta)
    nome_base_arquivo = os.path.basename(nome_arquivo_saida) # ex: teste.j
    nome_classe = os.path.splitext(nome_base_arquivo)[0]      # ex: teste
    
    # Instancia o gerador passando o nome da classe dinâmica
    gerador = GeradorCodigo(nome_classe)
    walker.walk(gerador, tree)
    
    codigo_jasmin = gerador.get_codigo()
    
    # Salva o arquivo .j no caminho completo (incluindo pasta backend)
    with open(nome_arquivo_saida, "w") as f:
        f.write(codigo_jasmin)
    
    # Exibe a mensagem formatada conforme solicitado
    print(f"\n• Arquivo Jasmin gerado: {nome_arquivo_saida}")
    print("\nPara compilar e executar:")
    print(f"  • java -jar jasmin.jar -d backend {nome_arquivo_saida}")
    print(f"  • java -cp backend {nome_classe}")
    print("-" * 50)

def main():
    # Garante que a pasta 'backend' existe
    os.makedirs('backend', exist_ok=True)

    # Verifica argumentos de linha de comando
    if len(sys.argv) > 1:
        caminho = sys.argv[1]
        
        # Se for uma PASTA, roda todos os arquivos dentro
        if os.path.isdir(caminho):
            print(f"--- Processando diretório: {caminho} ---")
            arquivos = sorted(os.listdir(caminho))
            for arquivo in arquivos:
                # Filtra apenas arquivos de texto/código fonte da sua linguagem
                # Ajuste as extensões conforme necessário (.txt, .duna, .gyh, etc)
                if arquivo.endswith(".txt") or arquivo.endswith(".js"): 
                    full_path = os.path.join(caminho, arquivo)
                    print(f"Lendo: {arquivo}")
                    
                    # Define nome de saída: backend/arquivo.j
                    nome_base = os.path.splitext(arquivo)[0]
                    nome_saida = os.path.join('backend', nome_base + ".j")
                    
                    try:
                        input_stream = FileStream(full_path, encoding='utf-8')
                        processar_arquivo(input_stream, nome_saida)
                    except Exception as e:
                        print(f"Erro ao ler arquivo: {e}")
        
        # Se for um ARQUIVO único
        elif os.path.isfile(caminho):
            try:
                # Define nome de saída: backend/nome_base.j
                nome_base = os.path.splitext(os.path.basename(caminho))[0]
                nome_saida = os.path.join('backend', nome_base + ".j")

                input_stream = FileStream(caminho, encoding='utf-8')
                processar_arquivo(input_stream, nome_saida)
            except Exception as e:
                print(f"Erro ao abrir arquivo: {e}")
            
        else:
            print(f"Erro: '{caminho}' não encontrado.")

    # Se não tiver argumentos
    else:
        print("---------------------------------------------------")
        print("Nenhum arquivo foi passado.")
        print("Para rodar, digite no terminal:")
        print("python main.py <caminho_do_arquivo_ou_pasta>")
        print("---------------------------------------------------")

if __name__ == "__main__":
    main()
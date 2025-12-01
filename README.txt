# Compilador JavaScript Simplificado - Front-end

Disciplina: Compiladores - 2025.2  
Docente: Glauber Dias Gonçalves 
Discentes: Bernardo de Carvalho Cavalcante e Francisco Rafael Meneses Gonçalves 

---

## 1. Visão Geral
    Este projeto implementa o Front-end (análise léxica, sintática e semântica) para uma linguagem simplificada baseada em JavaScript,  conforme especificado no Trabalho Final da disciplina. O compilador lê o código fonte da entrada padrão, constrói a árvore sintática e valida regras de escopo, tipos e imutabilidade.

## 2. Instalação e Pré-requisitos
    Para executar o compilador, é necessário ter instalado:
        - Python 3.8+
        - ANTLR4 Runtime para Python 3

    ### Instalação das dependências:
        Abra o terminal na pasta do projeto e execute:
            pip install antlr4-python3-runtime

        (Caso seja necessário regenerar os analisadores a partir da gramática, certifique-se de ter a ferramenta ANTLR4 instalada e execute: antlr4 -Dlanguage=Python3 Linguagem.g4)

## 3. Como Executar
    O compilador recebe o caminho do arquivo-fonte como argumento na linha de comando.

    - Se for um arquivo individual, passe o caminho para o arquivo:
        python main.py exemplos_especificacao/acertos/declaracao_variavel.txt

    - Se for uma pasta, o compilador processará todos os arquivos da pasta. Exemplo:
        python main.py exemplos_especificacao/acertos

    Saída esperada:
        Compilado com sucesso.
        ou
        [Erro semantico/sintatico/lexico informando qual linha ocorreu esse erro]

## 4. Testes e Validação
    O projeto inclui duas baterias de testes na pasta exemplos_especificacao/  e exemplos_novos/, ambos divididas em casos de sucesso (acertos) e casos de falha (erros).

    # 4.1 Testes Básicos (Exemplos/especificação)
        Cobrem a especificação inicial da linguagem:
            - Declaração de variáveis (let, const, var).
            - Tipos básicos e derivados (String, Number, BigInt, Array, Object).
            - Estruturas de controle (if, while, for, switch).

    # 4.2 Testes Avançados (Exemplos_novos/) 
        Implementamos testes complexos para validar a robustez do analisador semântico:
            - Shadowing e Escopo Aninhado
            - Callbacks e Recursão
            - Imutabilidade de Objetos

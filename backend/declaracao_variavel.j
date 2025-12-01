.class public declaracao_variavel
.super java/lang/Object

.method public <init>()V
    aload_0
    invokespecial java/lang/Object/<init>()V
    return
.end method

.method public static main([Ljava/lang/String;)V
    .limit stack 20
    .limit locals 20

    bipush 25
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    ; Variável 'idade' -> índice 1
    astore 1
    aload 1
    bipush 26
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    ldc2_w 3.14159
    invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;
    ; Variável 'PI' -> índice 2
    astore 2
    ldc "Ana"
    ; Variável 'nome' -> índice 3
    astore 3
    aload 1
    ldc "texto"
    aload 1
    aload 1
    iconst_1
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    checkcast java/lang/Integer
    invokevirtual java/lang/Integer/intValue()I
    swap
    checkcast java/lang/Integer
    invokevirtual java/lang/Integer/intValue()I
    swap
    iadd
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    aload 1
    getstatic java/lang/System/out Ljava/io/PrintStream;
    swap
    invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
    return
.end method
.class public operadores_aritmeticos
.super java/lang/Object

.method public <init>()V
    aload_0
    invokespecial java/lang/Object/<init>()V
    return
.end method

.method public static main([Ljava/lang/String;)V
    .limit stack 20
    .limit locals 20

    bipush 10
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    iconst_3
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    ; Variável 'a' -> índice 1
    astore 1
    ; Variável 'b' -> índice 2
    astore 2
    aload 1
    aload 2
    checkcast java/lang/Integer
    invokevirtual java/lang/Integer/intValue()I
    swap
    checkcast java/lang/Integer
    invokevirtual java/lang/Integer/intValue()I
    swap
    iadd
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    getstatic java/lang/System/out Ljava/io/PrintStream;
    swap
    invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
    aload 1
    aload 2
    checkcast java/lang/Integer
    invokevirtual java/lang/Integer/intValue()I
    swap
    checkcast java/lang/Integer
    invokevirtual java/lang/Integer/intValue()I
    swap
    isub
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    getstatic java/lang/System/out Ljava/io/PrintStream;
    swap
    invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
    aload 1
    aload 2
    checkcast java/lang/Integer
    invokevirtual java/lang/Integer/intValue()I
    swap
    checkcast java/lang/Integer
    invokevirtual java/lang/Integer/intValue()I
    swap
    imul
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    getstatic java/lang/System/out Ljava/io/PrintStream;
    swap
    invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
    aload 1
    aload 2
    checkcast java/lang/Integer
    invokevirtual java/lang/Integer/intValue()I
    swap
    checkcast java/lang/Integer
    invokevirtual java/lang/Integer/intValue()I
    swap
    idiv
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    getstatic java/lang/System/out Ljava/io/PrintStream;
    swap
    invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
    aload 1
    aload 2
    checkcast java/lang/Integer
    invokevirtual java/lang/Integer/intValue()I
    swap
    checkcast java/lang/Integer
    invokevirtual java/lang/Integer/intValue()I
    swap
    irem
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    getstatic java/lang/System/out Ljava/io/PrintStream;
    swap
    invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
    aload 1
    aload 2
    getstatic java/lang/System/out Ljava/io/PrintStream;
    swap
    invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
    iconst_5
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    ; Variável 'x' -> índice 3
    astore 3
    aload 3
    getstatic java/lang/System/out Ljava/io/PrintStream;
    swap
    invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
    getstatic java/lang/System/out Ljava/io/PrintStream;
    swap
    invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
    aload 3
    getstatic java/lang/System/out Ljava/io/PrintStream;
    swap
    invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
    getstatic java/lang/System/out Ljava/io/PrintStream;
    swap
    invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
    return
.end method
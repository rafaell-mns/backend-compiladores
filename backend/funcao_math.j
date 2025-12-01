.class public funcao_math
.super java/lang/Object

.method public <init>()V
    aload_0
    invokespecial java/lang/Object/<init>()V
    return
.end method

.method public static main([Ljava/lang/String;)V
    .limit stack 20
    .limit locals 20

    iconst_2
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    iconst_3
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    getstatic java/lang/System/out Ljava/io/PrintStream;
    swap
    invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
    bipush 16
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    getstatic java/lang/System/out Ljava/io/PrintStream;
    swap
    invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
    return
.end method
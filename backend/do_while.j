.class public do_while
.super java/lang/Object

.method public <init>()V
    aload_0
    invokespecial java/lang/Object/<init>()V
    return
.end method

.method public static main([Ljava/lang/String;)V
    .limit stack 20
    .limit locals 20

    iconst_0
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    ; Variável 'i' -> índice 1
    astore 1
    aload 1
    getstatic java/lang/System/out Ljava/io/PrintStream;
    swap
    invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
    aload 1
    iconst_5
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    checkcast java/lang/Integer
    invokevirtual java/lang/Integer/intValue()I
    swap
    checkcast java/lang/Integer
    invokevirtual java/lang/Integer/intValue()I
    swap
    if_icmplt L1
    iconst_0
    goto L2
L1:
    iconst_1
L2:
    invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;
    return
.end method
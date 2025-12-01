.class public for
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
L1:
    aload 1
    iconst_5
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    checkcast java/lang/Integer
    invokevirtual java/lang/Integer/intValue()I
    swap
    checkcast java/lang/Integer
    invokevirtual java/lang/Integer/intValue()I
    swap
    if_icmplt L5
    iconst_0
    goto L6
L5:
    iconst_1
L6:
    invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;
    checkcast java/lang/Boolean
    invokevirtual java/lang/Boolean/booleanValue()Z
    ifeq L4
    aload 1
    getstatic java/lang/System/out Ljava/io/PrintStream;
    swap
    invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
    goto L3
L3:
    aload 1
    checkcast java/lang/Integer
    invokevirtual java/lang/Integer/intValue()I
    iconst_1
    iadd
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    astore 1
    goto L1
L4:
    return
.end method
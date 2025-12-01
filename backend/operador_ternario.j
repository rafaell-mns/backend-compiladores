.class public operador_ternario
.super java/lang/Object

.method public <init>()V
    aload_0
    invokespecial java/lang/Object/<init>()V
    return
.end method

.method public static main([Ljava/lang/String;)V
    .limit stack 20
    .limit locals 20

    bipush 18
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    ; Variável 'idade' -> índice 1
    astore 1
    aload 1
    bipush 18
    invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
    checkcast java/lang/Integer
    invokevirtual java/lang/Integer/intValue()I
    swap
    checkcast java/lang/Integer
    invokevirtual java/lang/Integer/intValue()I
    swap
    if_icmpge L1
    iconst_0
    goto L2
L1:
    iconst_1
L2:
    invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;
    ldc "maior de idade"
    ldc "menor de idade"
    ; Variável 'status' -> índice 2
    astore 2
    aload 2
    getstatic java/lang/System/out Ljava/io/PrintStream;
    swap
    invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
    return
.end method
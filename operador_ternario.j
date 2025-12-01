.class public operador_ternario
.super java/lang/Object

.method public <init>()V
   aload_0
   invokenonvirtual java/lang/Object/<init>()V
   return
.end method

.method public static main([Ljava/lang/String;)V
   .limit stack 100
   .limit locals 100
   bipush 18
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   astore 1
   aload 1
   bipush 18
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   dstore 22
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   dload 22
   dcmpg
   ifge L0
   iconst_0
   goto L1
L0:
   iconst_1
L1:
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   ldc "maior de idade"
   ldc "menor de idade"
   astore 92
   astore 93
   astore 94
   aload 94
   ifnull L3
   aload 94
   instanceof java/lang/Number
   ifeq L2
   aload 94
   checkcast java/lang/Number
   invokevirtual java/lang/Number/intValue()I
   ifne L2
L3:
   aload 92
   goto L4
L2:
   aload 93
L4:
   astore 2
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 2
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   return
.end method

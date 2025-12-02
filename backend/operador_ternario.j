.class public operador_ternario
.super java/lang/Object

.method public <init>()V
   aload_0
   invokenonvirtual java/lang/Object/<init>()V
   return
.end method

.method public static main([Ljava/lang/String;)V
   .limit stack 300
   .limit locals 300
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
   ifge L2
   iconst_0
   goto L3
L2:
   iconst_1
L3:
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   checkcast java/lang/Number
   invokevirtual java/lang/Number/intValue()I
   ifeq L0
   ldc "maior de idade"
   goto L1
L0:
   ldc "menor de idade"
L1:
   astore 2
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 2
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   return
.end method

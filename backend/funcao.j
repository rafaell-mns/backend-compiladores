.class public funcao
.super java/lang/Object

.method public <init>()V
   aload_0
   invokenonvirtual java/lang/Object/<init>()V
   return
.end method

.method public static somar(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
   .limit stack 300
   .limit locals 300
   aload 0
   aload 1
   astore 23
   astore 22
   aload 22
   instanceof java/lang/String
   ifne L0
   aload 23
   instanceof java/lang/String
   ifne L0
   goto L1
L0:
   aload 22
   invokestatic java/lang/String/valueOf(Ljava/lang/Object;)Ljava/lang/String;
   aload 23
   invokestatic java/lang/String/valueOf(Ljava/lang/Object;)Ljava/lang/String;
   invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String;
   goto L2
L1:
   aload 22
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   aload 23
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   dadd
   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;
L2:
   areturn
   aconst_null
   areturn
.end method

.method public static main([Ljava/lang/String;)V
   .limit stack 300
   .limit locals 300
   getstatic java/lang/System/out Ljava/io/PrintStream;
   bipush 10
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   ldc 200
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   invokestatic funcao/somar(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   return
.end method

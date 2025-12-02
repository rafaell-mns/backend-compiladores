.class public operadores_atribuicao
.super java/lang/Object

.method public <init>()V
   aload_0
   invokenonvirtual java/lang/Object/<init>()V
   return
.end method

.method public static main([Ljava/lang/String;)V
   .limit stack 300
   .limit locals 300
   bipush 10
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   astore 1
   aload 1
   iconst_5
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   astore 32
   astore 33
   aload 33
   instanceof java/lang/String
   ifne L0
   aload 32
   instanceof java/lang/String
   ifne L0
   goto L1
L0:
   aload 33
   invokestatic java/lang/String/valueOf(Ljava/lang/Object;)Ljava/lang/String;
   aload 32
   invokestatic java/lang/String/valueOf(Ljava/lang/Object;)Ljava/lang/String;
   invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String;
   goto L2
L1:
   aload 33
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   aload 32
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   dadd
   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;
L2:
   astore 1
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 1
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   aload 1
   iconst_3
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   astore 32
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   aload 32
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   dsub
   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;
   astore 1
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 1
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   aload 1
   iconst_2
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   astore 32
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   aload 32
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   dmul
   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;
   astore 1
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 1
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   aload 1
   iconst_4
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   astore 32
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   aload 32
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   ddiv
   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;
   astore 1
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 1
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   aload 1
   iconst_4
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   astore 32
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   aload 32
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   drem
   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;
   astore 1
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 1
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   aload 1
   iconst_3
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   astore 32
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   aload 32
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   invokestatic java/lang/Math/pow(DD)D
   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;
   astore 1
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 1
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   return
.end method

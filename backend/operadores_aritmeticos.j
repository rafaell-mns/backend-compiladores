.class public operadores_aritmeticos
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
   iconst_5
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   astore 2
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 1
   aload 2
   astore 24
   astore 23
   aload 23
   instanceof java/lang/String
   ifne L0
   aload 24
   instanceof java/lang/String
   ifne L0
   goto L1
L0:
   aload 23
   invokestatic java/lang/String/valueOf(Ljava/lang/Object;)Ljava/lang/String;
   aload 24
   invokestatic java/lang/String/valueOf(Ljava/lang/Object;)Ljava/lang/String;
   invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String;
   goto L2
L1:
   aload 23
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   aload 24
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   dadd
   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;
L2:
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 1
   aload 2
   astore 23
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   aload 23
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   dsub
   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 1
   aload 2
   astore 23
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   aload 23
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   dmul
   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 1
   aload 2
   astore 23
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   aload 23
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   ddiv
   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 1
   aload 2
   astore 23
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   aload 23
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   drem
   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 1
   aload 2
   astore 23
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   aload 23
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   invokestatic java/lang/Math/pow(DD)D
   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   iconst_5
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   astore 3
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 3
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   dconst_1
   dadd
   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;
   dup
   astore 3
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   aload 3
   checkcast java/lang/Number
   dup
   invokevirtual java/lang/Number/doubleValue()D
   dconst_1
   dadd
   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;
   astore 3
   pop
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 3
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 3
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   dconst_1
   dsub
   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;
   dup
   astore 3
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   aload 3
   checkcast java/lang/Number
   dup
   invokevirtual java/lang/Number/doubleValue()D
   dconst_1
   dsub
   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;
   astore 3
   pop
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 3
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   return
.end method

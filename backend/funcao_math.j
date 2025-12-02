.class public funcao_math
.super java/lang/Object

.method public <init>()V
   aload_0
   invokenonvirtual java/lang/Object/<init>()V
   return
.end method

.method public static main([Ljava/lang/String;)V
   .limit stack 300
   .limit locals 300
   iconst_2
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   iconst_3
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   dstore 51
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   dload 51
   invokestatic java/lang/Math/pow(DD)D
   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;
   astore 1
   bipush 16
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   invokestatic java/lang/Math/sqrt(D)D
   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;
   astore 2
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 1
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 2
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   return
.end method

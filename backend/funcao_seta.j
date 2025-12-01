.class public funcao_seta
.super java/lang/Object

.method public <init>()V
   aload_0
   invokenonvirtual java/lang/Object/<init>()V
   return
.end method

.method public static multiplicar(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
   .limit stack 300
   .limit locals 300
   aload 0
   aload 1
   astore 22
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   aload 22
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   dmul
   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;
   areturn
   aconst_null
   areturn
.end method

.method public static dividir(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
   .limit stack 300
   .limit locals 300
   aload 0
   aload 1
   astore 22
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   aload 22
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   ddiv
   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;
   areturn
.end method

.method public static main([Ljava/lang/String;)V
   .limit stack 300
   .limit locals 300
   aconst_null
   astore 1
   aconst_null
   astore 1
   getstatic java/lang/System/out Ljava/io/PrintStream;
   bipush 6
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   bipush 7
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   invokestatic funcao_seta/multiplicar(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   getstatic java/lang/System/out Ljava/io/PrintStream;
   bipush 20
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   iconst_4
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   invokestatic funcao_seta/dividir(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   return
.end method

.class public tipos_basicos
.super java/lang/Object

.method public <init>()V
   aload_0
   invokenonvirtual java/lang/Object/<init>()V
   return
.end method

.method public static main([Ljava/lang/String;)V
   .limit stack 300
   .limit locals 300
   ldc "Maria"
   astore 1
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 1
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   ldc "Silva"
   astore 2
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 2
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   ldc "Olá, "
   aload 1
   invokestatic java/lang/String/valueOf(Ljava/lang/Object;)Ljava/lang/String;
   invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String;
   ldc "!"
   invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String;
   astore 3
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 3
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   bipush 25
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   astore 4
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 4
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   ldc "19.99"
   astore 5
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 5
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   bipush 42
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   dneg
   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;
   astore 6
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 6
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   iconst_1
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   astore 7
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 7
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   iconst_0
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   astore 8
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 8
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   aconst_null
   astore 9
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 9
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   aconst_null
   astore 10
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 10
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   ldc2_w 9007199254740991
   invokestatic java/lang/Long/valueOf(J)Ljava/lang/Long;
   astore 11
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 11
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   ldc "9007199254740991"
   astore 12
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 12
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   return
.end method

.class public funcao_string
.super java/lang/Object

.method public <init>()V
   aload_0
   invokenonvirtual java/lang/Object/<init>()V
   return
.end method

.method public static main([Ljava/lang/String;)V
   .limit stack 300
   .limit locals 300
   ldc "JavaScript"
   astore 1
   aload 1
   aload 1
   checkcast java/util/Map
   ldc "toUpperCase"
   invokeinterface java/util/Map/get(Ljava/lang/Object;)Ljava/lang/Object; 2
   checkcast java/lang/String
   invokevirtual java/lang/String/toUpperCase()Ljava/lang/String;
   astore 1
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 1
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   aload 1
   aload 1
   checkcast java/util/Map
   ldc "substring"
   invokeinterface java/util/Map/get(Ljava/lang/Object;)Ljava/lang/Object; 2
   iconst_0
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   iconst_4
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   istore 12
   istore 13
   checkcast java/lang/String
   iload 13
   iload 12
   invokevirtual java/lang/String/substring(II)Ljava/lang/String;
   astore 1
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 1
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   return
.end method

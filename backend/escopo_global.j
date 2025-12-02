.class public escopo_global
.super java/lang/Object

.method public <init>()V
   aload_0
   invokenonvirtual java/lang/Object/<init>()V
   return
.end method

.method public static exibirMensagem(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
   .limit stack 300
   .limit locals 300
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 1
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   aconst_null
   areturn
.end method

.method public static main([Ljava/lang/String;)V
   .limit stack 300
   .limit locals 300
   ldc "Sistema Online"
   astore 1
   iconst_1
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   checkcast java/lang/Number
   invokevirtual java/lang/Number/intValue()I
   ifeq L0
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 1
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   goto L1
L0:
L1:
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 1
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   return
.end method

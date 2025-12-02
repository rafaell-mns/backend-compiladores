.class public switch
.super java/lang/Object

.method public <init>()V
   aload_0
   invokenonvirtual java/lang/Object/<init>()V
   return
.end method

.method public static main([Ljava/lang/String;)V
   .limit stack 300
   .limit locals 300
   iconst_1
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   astore 1
   aload 1
   astore 202
   iconst_1
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   astore 207
   aload 202
   aload 207
   invokevirtual java/lang/Object/equals(Ljava/lang/Object;)Z
   ifeq L1
   getstatic java/lang/System/out Ljava/io/PrintStream;
   ldc "Domingo"
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   goto L0
L1:
   iconst_2
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   astore 207
   aload 202
   aload 207
   invokevirtual java/lang/Object/equals(Ljava/lang/Object;)Z
   ifeq L2
   getstatic java/lang/System/out Ljava/io/PrintStream;
   ldc "Segunda"
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   goto L0
L2:
   getstatic java/lang/System/out Ljava/io/PrintStream;
   ldc "Outro dia"
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
L0:
   return
.end method

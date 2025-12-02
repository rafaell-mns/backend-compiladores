.class public operadores_bit
.super java/lang/Object

.method public <init>()V
   aload_0
   invokenonvirtual java/lang/Object/<init>()V
   return
.end method

.method public static main([Ljava/lang/String;)V
   .limit stack 300
   .limit locals 300
   iconst_5
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   astore 1
   iconst_3
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   astore 2
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 1
   aload 2
   checkcast java/lang/Number
   invokevirtual java/lang/Number/intValue()I
   istore 23
   checkcast java/lang/Number
   invokevirtual java/lang/Number/intValue()I
   iload 23
   iand
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 1
   aload 2
   checkcast java/lang/Number
   invokevirtual java/lang/Number/intValue()I
   istore 23
   checkcast java/lang/Number
   invokevirtual java/lang/Number/intValue()I
   iload 23
   ior
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 1
   aload 2
   checkcast java/lang/Number
   invokevirtual java/lang/Number/intValue()I
   istore 23
   checkcast java/lang/Number
   invokevirtual java/lang/Number/intValue()I
   iload 23
   ixor
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 1
   checkcast java/lang/Number
   invokevirtual java/lang/Number/intValue()I
   iconst_m1
   ixor
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 1
   iconst_1
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   checkcast java/lang/Number
   invokevirtual java/lang/Number/intValue()I
   istore 23
   checkcast java/lang/Number
   invokevirtual java/lang/Number/intValue()I
   iload 23
   ishl
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 1
   iconst_1
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   checkcast java/lang/Number
   invokevirtual java/lang/Number/intValue()I
   istore 23
   checkcast java/lang/Number
   invokevirtual java/lang/Number/intValue()I
   iload 23
   ishr
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   return
.end method

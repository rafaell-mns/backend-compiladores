.class public do_while
.super java/lang/Object

.method public <init>()V
   aload_0
   invokenonvirtual java/lang/Object/<init>()V
   return
.end method

.method public static main([Ljava/lang/String;)V
   .limit stack 100
   .limit locals 100
   iconst_0
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   astore 1
L0:
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 1
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   aload 1
   dup
   astore 28
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   dconst_1
   dadd
   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;
   astore 1
   aload 28
   pop
   aload 1
   iconst_5
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   dstore 22
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   dload 22
   dcmpg
   iflt L2
   iconst_0
   goto L3
L2:
   iconst_1
L3:
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   checkcast java/lang/Number
   invokevirtual java/lang/Number/intValue()I
   ifne L0
L1:
   return
.end method

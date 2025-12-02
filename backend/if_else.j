.class public if_else
.super java/lang/Object

.method public <init>()V
   aload_0
   invokenonvirtual java/lang/Object/<init>()V
   return
.end method

.method public static main([Ljava/lang/String;)V
   .limit stack 300
   .limit locals 300
   bipush 15
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   astore 1
   aload 1
   bipush 18
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
   ifeq L0
   getstatic java/lang/System/out Ljava/io/PrintStream;
   ldc "Menor de idade"
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   goto L1
L0:
   aload 1
   bipush 18
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   astore 63
   astore 62
   aload 62
   aload 63
   invokevirtual java/lang/Object/equals(Ljava/lang/Object;)Z
   ifne L6
   iconst_0
   goto L7
L6:
   iconst_1
L7:
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   checkcast java/lang/Number
   invokevirtual java/lang/Number/intValue()I
   ifeq L4
   getstatic java/lang/System/out Ljava/io/PrintStream;
   ldc "Tem 18 anos"
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   goto L5
L4:
   getstatic java/lang/System/out Ljava/io/PrintStream;
   ldc "Maior de idade"
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
L5:
L1:
   return
.end method

.class public operadores_comparacao
.super java/lang/Object

.method public <init>()V
   aload_0
   invokenonvirtual java/lang/Object/<init>()V
   return
.end method

.method public static main([Ljava/lang/String;)V
   .limit stack 300
   .limit locals 300
   getstatic java/lang/System/out Ljava/io/PrintStream;
   bipush 10
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   iconst_5
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   dstore 21
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   dload 21
   dcmpg
   ifgt L0
   iconst_0
   goto L1
L0:
   iconst_1
L1:
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   getstatic java/lang/System/out Ljava/io/PrintStream;
   bipush 10
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   iconst_5
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   dstore 21
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   dload 21
   dcmpg
   iflt L2
   iconst_0
   goto L3
L2:
   iconst_1
L3:
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   getstatic java/lang/System/out Ljava/io/PrintStream;
   bipush 10
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   ldc "10"
   astore 62
   astore 61
   aload 61
   instanceof java/lang/Number
   ifeq L5
   aload 62
   instanceof java/lang/String
   ifeq L5
   goto L4
L5:
   aload 61
   instanceof java/lang/String
   ifeq L6
   aload 62
   instanceof java/lang/Number
   ifeq L6
   aload 61
   checkcast java/lang/String
   invokestatic java/lang/Double/parseDouble(Ljava/lang/String;)D
   aload 62
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   dcmpl
   ifeq L7
   goto L8
L4:
   aload 61
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   aload 62
   checkcast java/lang/String
   invokestatic java/lang/Double/parseDouble(Ljava/lang/String;)D
   dcmpl
   ifeq L7
   goto L8
L6:
   aload 61
   aload 62
   invokevirtual java/lang/Object/equals(Ljava/lang/Object;)Z
   ifne L7
L8:
   iconst_0
   goto L9
L7:
   iconst_1
L9:
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   getstatic java/lang/System/out Ljava/io/PrintStream;
   bipush 10
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   bipush 10
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   astore 62
   astore 61
   aload 61
   aload 62
   invokevirtual java/lang/Object/equals(Ljava/lang/Object;)Z
   ifne L10
   iconst_0
   goto L11
L10:
   iconst_1
L11:
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   getstatic java/lang/System/out Ljava/io/PrintStream;
   bipush 10
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   iconst_5
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   astore 62
   astore 61
   aload 61
   aload 62
   invokevirtual java/lang/Object/equals(Ljava/lang/Object;)Z
   ifeq L12
   iconst_0
   goto L13
L12:
   iconst_1
L13:
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   return
.end method

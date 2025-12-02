.class public operadores_logicos
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
   iconst_0
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   astore 2
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 1
   aload 2
   astore 80
   astore 79
   aload 79
   ifnull L1
   aload 79
   instanceof java/lang/Number
   ifeq L0
   aload 79
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   dconst_0
   dcmpl
   ifeq L1
L0:
   aload 80
   goto L2
L1:
   aload 79
L2:
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 1
   aload 2
   astore 82
   astore 81
   aload 81
   ifnull L3
   aload 81
   instanceof java/lang/Number
   ifeq L4
   aload 81
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   dconst_0
   dcmpl
   ifne L4
L3:
   aload 82
   goto L5
L4:
   aload 81
L5:
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 1
   astore 78
   aload 78
   ifnull L6
   aload 78
   instanceof java/lang/Number
   ifeq L7
   aload 78
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   dconst_0
   dcmpl
   ifeq L6
L7:
   iconst_0
   goto L8
L6:
   iconst_1
L8:
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   return
.end method

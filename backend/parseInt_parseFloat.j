.class public parseInt_parseFloat
.super java/lang/Object

.method public <init>()V
   aload_0
   invokenonvirtual java/lang/Object/<init>()V
   return
.end method

.method public static main([Ljava/lang/String;)V
   .limit stack 300
   .limit locals 300
   ldc "10.5"
   astore 1
   aload 1
   astore 82
   aload 82
   instanceof java/lang/Number
   ifne L0
   aload 82
   checkcast java/lang/String
   invokestatic java/lang/Double/parseDouble(Ljava/lang/String;)D
   d2i
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   goto L1
L0:
   aload 82
   checkcast java/lang/Number
   invokevirtual java/lang/Number/intValue()I
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
L1:
   astore 2
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 2
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   aload 1
   checkcast java/lang/String
   invokestatic java/lang/Double/parseDouble(Ljava/lang/String;)D
   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;
   astore 3
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 3
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   return
.end method

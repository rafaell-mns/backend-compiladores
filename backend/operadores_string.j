.class public operadores_string
.super java/lang/Object

.method public <init>()V
   aload_0
   invokenonvirtual java/lang/Object/<init>()V
   return
.end method

.method public static main([Ljava/lang/String;)V
   .limit stack 300
   .limit locals 300
   ldc "João"
   astore 1
   ldc "Silva"
   astore 2
   aload 1
   ldc " "
   aload 2
   astore 24
   astore 23
   aload 23
   instanceof java/lang/String
   ifne L0
   aload 24
   instanceof java/lang/String
   ifne L0
   goto L1
L0:
   aload 23
   invokestatic java/lang/String/valueOf(Ljava/lang/Object;)Ljava/lang/String;
   aload 24
   invokestatic java/lang/String/valueOf(Ljava/lang/Object;)Ljava/lang/String;
   invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String;
   goto L2
L1:
   aload 23
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   aload 24
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   dadd
   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;
L2:
   astore 24
   astore 23
   aload 23
   instanceof java/lang/String
   ifne L3
   aload 24
   instanceof java/lang/String
   ifne L3
   goto L4
L3:
   aload 23
   invokestatic java/lang/String/valueOf(Ljava/lang/Object;)Ljava/lang/String;
   aload 24
   invokestatic java/lang/String/valueOf(Ljava/lang/Object;)Ljava/lang/String;
   invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String;
   goto L5
L4:
   aload 23
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   aload 24
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   dadd
   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;
L5:
   astore 3
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 3
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   ldc "Olá, "
   aload 1
   invokestatic java/lang/String/valueOf(Ljava/lang/Object;)Ljava/lang/String;
   invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String;
   ldc "!"
   invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String;
   astore 4
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 4
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   return
.end method

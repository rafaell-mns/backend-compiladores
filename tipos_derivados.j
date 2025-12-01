.class public tipos_derivados
.super java/lang/Object

.method public <init>()V
   aload_0
   invokenonvirtual java/lang/Object/<init>()V
   return
.end method

.method public static somar(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
   .limit stack 300
   .limit locals 300
   aload 0
   aload 1
   astore 23
   astore 22
   aload 22
   instanceof java/lang/String
   ifne L0
   aload 23
   instanceof java/lang/String
   ifne L0
   goto L1
L0:
   aload 22
   invokestatic java/lang/String/valueOf(Ljava/lang/Object;)Ljava/lang/String;
   aload 23
   invokestatic java/lang/String/valueOf(Ljava/lang/Object;)Ljava/lang/String;
   invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String;
   goto L2
L1:
   aload 22
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   aload 23
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   dadd
   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;
L2:
   areturn
   aconst_null
   areturn
.end method

.method public static multiplicar(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
   .limit stack 300
   .limit locals 300
   aload 0
   aload 1
   astore 22
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   aload 22
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   dmul
   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;
   areturn
   aconst_null
   areturn
.end method

.method public static main([Ljava/lang/String;)V
   .limit stack 300
   .limit locals 300
   ldc "Carlos"
   bipush 30
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   ldc "Teresina"
   new java/util/HashMap
   dup
   invokespecial java/util/HashMap/<init>()V
   astore 102
   aload 102
   swap
   ldc "cidade"
   swap
   invokevirtual java/util/HashMap/put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
   pop
   aload 102
   swap
   ldc "idade"
   swap
   invokevirtual java/util/HashMap/put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
   pop
   aload 102
   swap
   ldc "nome"
   swap
   invokevirtual java/util/HashMap/put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
   pop
   aload 102
   astore 1
   iconst_1
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   iconst_2
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   iconst_3
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   iconst_4
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   iconst_5
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   new java/util/ArrayList
   dup
   invokespecial java/util/ArrayList/<init>()V
   astore 102
   aload 102
   swap
   invokeinterface java/util/List/add(Ljava/lang/Object;)Z 2
   pop
   aload 102
   swap
   invokeinterface java/util/List/add(Ljava/lang/Object;)Z 2
   pop
   aload 102
   swap
   invokeinterface java/util/List/add(Ljava/lang/Object;)Z 2
   pop
   aload 102
   swap
   invokeinterface java/util/List/add(Ljava/lang/Object;)Z 2
   pop
   aload 102
   swap
   invokeinterface java/util/List/add(Ljava/lang/Object;)Z 2
   pop
   aload 102
   astore 2
   iconst_1
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   ldc "texto"
   iconst_1
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   aconst_null
   new java/util/ArrayList
   dup
   invokespecial java/util/ArrayList/<init>()V
   astore 103
   aload 103
   swap
   invokeinterface java/util/List/add(Ljava/lang/Object;)Z 2
   pop
   aload 103
   swap
   invokeinterface java/util/List/add(Ljava/lang/Object;)Z 2
   pop
   aload 103
   swap
   invokeinterface java/util/List/add(Ljava/lang/Object;)Z 2
   pop
   aload 103
   swap
   invokeinterface java/util/List/add(Ljava/lang/Object;)Z 2
   pop
   aload 103
   astore 3
   getstatic java/lang/System/out Ljava/io/PrintStream;
   ldc "Pessoa: "
   aload 1
   astore 22
   astore 21
   aload 21
   instanceof java/lang/String
   ifne L3
   aload 22
   instanceof java/lang/String
   ifne L3
   goto L4
L3:
   aload 21
   invokestatic java/lang/String/valueOf(Ljava/lang/Object;)Ljava/lang/String;
   aload 22
   invokestatic java/lang/String/valueOf(Ljava/lang/Object;)Ljava/lang/String;
   invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String;
   goto L5
L4:
   aload 21
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   aload 22
   checkcast java/lang/Number
   invokevirtual java/lang/Number/doubleValue()D
   dadd
   invokestatic java/lang/Double/valueOf(D)Ljava/lang/Double;
L5:
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   return
.end method

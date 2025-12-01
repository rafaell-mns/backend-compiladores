.class public operadores_especiais
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
   bipush 42
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   astore 151
   aload 151
   instanceof java/lang/Number
   ifne L0
   aload 151
   instanceof java/lang/String
   ifne L1
   aload 151
   instanceof java/lang/Boolean
   ifne L2
   aload 151
   instanceof java/util/List
   ifne L3
   aload 151
   instanceof java/util/Map
   ifne L4
   ldc "undefined"
   goto L5
L0:
   ldc "number"
   goto L5
L1:
   ldc "string"
   goto L5
L2:
   ldc "boolean"
   goto L5
L3:
L4:
   ldc "object"
L5:
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   new java/util/Date
   dup
   invokespecial java/util/Date/<init>()V
   astore 1
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 1
   instanceof java/util/Date
   ifne L6
L7:
   iconst_0
   goto L8
L6:
   iconst_1
L8:
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 1
   instanceof java/util/ArrayList
   ifne L9
L10:
   iconst_0
   goto L11
L9:
   iconst_1
L11:
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 1
   dup
   instanceof java/util/Map
   ifne L15
   dup
   instanceof java/util/List
   ifne L15
   instanceof java/util/Date
   goto L16
L15:
   pop
   iconst_1
L16:
   ifne L12
L13:
   iconst_0
   goto L14
L12:
   iconst_1
L14:
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   ldc "Ana"
   bipush 25
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   new java/util/HashMap
   dup
   invokespecial java/util/HashMap/<init>()V
   astore 103
   astore 113
   astore 112
   aload 103
   ldc "nome"
   aload 112
   invokevirtual java/util/HashMap/put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
   pop
   aload 103
   ldc "idade"
   aload 113
   invokevirtual java/util/HashMap/put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
   pop
   aload 103
   astore 2
   aload 2
   pop
   iconst_1
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   pop
   getstatic java/lang/System/out Ljava/io/PrintStream;
   ldc "nome"
   aload 2
   checkcast java/util/Map
   swap
   checkcast java/lang/Object
   invokeinterface java/util/Map/containsKey(Ljava/lang/Object;)Z 2
   ifne L17
   iconst_0
   goto L18
L17:
   iconst_1
L18:
   invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   ldc "Maria"
   new java/util/HashMap
   dup
   invokespecial java/util/HashMap/<init>()V
   astore 104
   astore 113
   aload 104
   ldc "nome"
   aload 113
   invokevirtual java/util/HashMap/put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
   pop
   aload 104
   new java/util/HashMap
   dup
   invokespecial java/util/HashMap/<init>()V
   astore 104
   astore 113
   aload 104
   ldc "perfil"
   aload 113
   invokevirtual java/util/HashMap/put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
   pop
   aload 104
   astore 3
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 3
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   getstatic java/lang/System/out Ljava/io/PrintStream;
   aload 3
   invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
   return
.end method

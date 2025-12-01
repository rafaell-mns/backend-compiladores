grammar Linguagem;

// Programa e statements

program: statement* EOF;

statement:
	block
	| variableDeclaration SEMI
	| returnStatement SEMI
	| functionDeclaration
	| breakStatement
	| continueStatement
	| expression SEMI
	| ifStatement
	| switchStatement
	| forStatement
	| whileStatement
	| doWhileStatement
	| SEMI;

block: LBRACE statement* RBRACE;

// Declarações

variableDeclaration:
	(LET | CONST | VAR) variableDeclarator (
		COMMA variableDeclarator
	)*;

variableDeclarator: Identifier (ASSIGN expression)?;

functionDeclaration:
	FUNCTION Identifier LPAREN paramList? RPAREN block;

paramList: Identifier (COMMA Identifier)*;

returnStatement: RETURN expression?;

// Estruturas de controle

ifStatement:
	IF LPAREN expression RPAREN statement (ELSE statement)?;

switchStatement:
	SWITCH LPAREN expression RPAREN LBRACE (
		switchCase
		| defaultCase
	)* RBRACE;

switchCase: CASE expression COLON statement*;

defaultCase: DEFAULT COLON statement*;

forStatement:
	FOR LPAREN forInit? SEMI expression? SEMI expression? RPAREN statement;

forInit: variableDeclaration | expression;

whileStatement: WHILE LPAREN expression RPAREN statement;

doWhileStatement: DO block WHILE LPAREN expression RPAREN SEMI?;

// Break / Continue
breakStatement: BREAK Identifier? SEMI;

continueStatement: CONTINUE Identifier? SEMI;

// Expressões (simplificadas mantendo hierarquia)

expression: assignmentExpression;

assignmentExpression:
	conditionalExpression (
		assignmentOperator assignmentExpression
	)?;

assignmentOperator:
	ASSIGN
	| PLUSEQ
	| MINUSEQ
	| STAREQ
	| SLASHEQ
	| PERCENTEQ
	| POWEQ;

conditionalExpression:
	logicalOrExpression (
		QUESTION expression COLON assignmentExpression
	)?;

logicalOrExpression:
	logicalAndExpression (OR logicalAndExpression)*;

logicalAndExpression:
	bitwiseOrExpression (AND bitwiseOrExpression)*;

bitwiseOrExpression:
	bitwiseXorExpression (B_OR bitwiseXorExpression)*;

bitwiseXorExpression:
	bitwiseAndExpression (CARET bitwiseAndExpression)*;

bitwiseAndExpression:
	equalityExpression (B_AND equalityExpression)*;

equalityExpression:
	relationalExpression (
		(EQ | NE | SEQ | SNE) relationalExpression
	)*;

relationalExpression:
	shiftExpression (
		(LT | GT | LE | GE | IN | INSTANCEOF) shiftExpression
	)*;

shiftExpression:
	additiveExpression ((LSHIFT | RSHIFT) additiveExpression)*;

additiveExpression:
	multiplicativeExpression (
		(PLUS | MINUS) multiplicativeExpression
	)*;

multiplicativeExpression:
	exponentExpression (
		(STAR | SLASH | PERCENT) exponentExpression
	)*;

// Exponenciação (right-associative)
exponentExpression: unaryExpression (POWER exponentExpression)?;

unaryExpression:
	(BANG | TILDE | PLUS | MINUS | INC | DEC | TYPEOF | DELETE) unaryExpression
	| postfixExpression;

postfixExpression: primaryExpression postfixOp*;

postfixOp:
	INC
	| DEC
	| DOT Identifier
	| OPTIONAL_CHAIN Identifier
	| LBRACK expression RBRACK
	| LPAREN argList? RPAREN;

primaryExpression:
	Literal
	| BigIntLiteral
	| Identifier
	| LPAREN expression RPAREN
	| objectLiteral
	| arrayLiteral
	| functionExpression
	| arrowFunction
	| NEW Identifier LPAREN argList? RPAREN;

// Funções

functionExpression:
	FUNCTION Identifier? LPAREN paramList? RPAREN block;

arrowFunction:
	Identifier ARROW (block | expression)
	| LPAREN paramList? RPAREN ARROW (block | expression);

// Objetos, arrays, call args

objectLiteral: LBRACE (property (COMMA property)*)? RBRACE;

property: Identifier COLON expression;

arrayLiteral: LBRACK (expression (COMMA expression)*)? RBRACK;

argList: expression (COMMA expression)*;

// Literais

Literal:
	StringLiteral
	| NumericLiteral
	| BooleanLiteral
	| NULL
	| UNDEFINED;

StringLiteral: String;
NumericLiteral: Number;
BooleanLiteral: TRUE | FALSE;
BigIntLiteral: BigInt;

// Tokens (mantidos iguais)

FUNCTION: 'function';
RETURN: 'return';
LET: 'let';
CONST: 'const';
VAR: 'var';
IF: 'if';
ELSE: 'else';
SWITCH: 'switch';
CASE: 'case';
DEFAULT: 'default';
FOR: 'for';
WHILE: 'while';
DO: 'do';
BREAK: 'break';
CONTINUE: 'continue';
NEW: 'new';
IN: 'in';
INSTANCEOF: 'instanceof';
TYPEOF: 'typeof';
DELETE: 'delete';
NULL: 'null';
TRUE: 'true';
FALSE: 'false';
UNDEFINED: 'undefined';

SEMI: ';';
COMMA: ',';
LPAREN: '(';
RPAREN: ')';
LBRACE: '{';
RBRACE: '}';
LBRACK: '[';
RBRACK: ']';
DOT: '.';
COLON: ':';
QUESTION: '?';
ARROW: '=>';
OPTIONAL_CHAIN: '?.';

PLUS: '+';
MINUS: '-';
STAR: '*';
SLASH: '/';
PERCENT: '%';
POWER: '**';
INC: '++';
DEC: '--';
BANG: '!';
LT: '<';
GT: '>';
LE: '<=';
GE: '>=';
EQ: '==';
NE: '!=';
SEQ: '===';
SNE: '!==';
AND: '&&';
OR: '||';
TILDE: '~';
CARET: '^';
B_OR: '|';
B_AND: '&';
LSHIFT: '<<';
RSHIFT: '>>';

ASSIGN: '=';
PLUSEQ: '+=';
MINUSEQ: '-=';
STAREQ: '*=';
SLASHEQ: '/=';
PERCENTEQ: '%=';
POWEQ: '**=';

Number: DIGITS ('.' DIGITS)? ([eE] [+-]? DIGITS)?;
BigInt: DIGITS 'n';

String:
	'"' (~["\\])* '"'
	| '\'' (~['\\])* '\''
	| '`' (~[`\\])* '`';

Identifier: IdentifierStart IdentifierPart*;
fragment IdentifierStart: [a-zA-Z_$];
fragment IdentifierPart: [a-zA-Z0-9_$];
fragment DIGITS: [0-9]+;

COMMENT: ('//' ~[\r\n]* | '/*' .*? '*/') -> skip;
WS: [ \t\r\n]+ -> skip;
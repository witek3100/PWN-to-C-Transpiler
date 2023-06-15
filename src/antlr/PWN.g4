grammar PWN;

@header {
    package antlr;
}

program 
    : functionDefinition* statement+ EOF
    ;

statement 
    : assignment
    | increment
    | declaration
    | returnStatement
    | ifStatement
    | whileStatement
    | forStatement
    ;

loopStatement
    : statement | jumpStatement
    ;

jumpStatement
    : jumpStatementType SEMICOLON
    ;

jumpStatementType
    : BREAK | CONTINUE
    ;

declaration
    : ID COLON type ASSIGN expression SEMICOLON 
    ;

assignment
    : variableValue assignmentType expression SEMICOLON
    ;

assignmentType
    : ASSIGN | ADDASSIGN | SUBASSIGN
    ;

increment
    : variableValue incrementType SEMICOLON
    ;

incrementType
    : INCREMENT | DECREMENT
    ;

index
    : LBRACKET expression RBRACKET
    ;

returnStatement
    : RETURN expression? SEMICOLON 
    ;

ifStatement
    : IF LPAR expression RPAR LBRACE statement* RBRACE (ELIF LPAR expression RPAR LBRACE statement* RBRACE)* (ELSE LBRACE statement* RBRACE)?
    ;

whileStatement
    : WHILE LPAR expression RPAR LBRACE loopStatement* RBRACE
    ;

iterable
    : RANGE | ID
    ;

forStatement 
    : FOR LPAR ID COLON type IN iterable RPAR LBRACE loopStatement* RBRACE
    ;

functionDefinition
    : FN ID LPAR argumentsDefinition RPAR (ARROW type)? LBRACE statement* RBRACE
    ;

argumentsDefinition
    : ((ID COLON type)(COMMA ID COLON type)*)?
    ;

arguments
    : (expression (COMMA expression)*)?
    ;

functionCall
    : ID LPAR arguments RPAR
    ;

type
    : normalType | arrayType
    ;

normalType
    : KW_INT | KW_FLOAT | KW_DOUBLE | KW_STRING | KW_BOOL
    ;

arrayType
    : normalType LBRACKET RBRACKET
    ;

arrayInit
    : normalType LBRACKET INT RBRACKET
    ;

expression
    : value                                      #valueExpression
    | LPAR expression RPAR                       #parenthesizedExpression
    | (NOT | SUB) expression                     #unaryExpression
    | expression (MUL | DIV | MOD) expression    #multiplicativeExpression
    | expression (ADD | SUB) expression          #additiveExpression
    | expression (LT | GT | LE | GE) expression  #comparisonExpression
    | expression (EQ | NEQ) expression           #equalityExpression
    | expression IN iterable                     #inExpression
    | expression AND expression                  #andExpression
    | expression OR expression                   #orExpression
    ;

variableValue
    : ID index?
    ;

value
    : variableValue | arrayInit | literalValue | functionCall | ( LPAR value RPAR )
    ;

literalValue
    : INT | FLOAT | STRING | NULL | TRUE | FALSE
    ;


ADD : '+' ;

DIV : '/' ;

MUL : '*' ;

MOD : '%' ;

SUB : '-' ;

SEMICOLON : ';' ;

COLON : ':' ;

LPAR : '(' ;

RPAR : ')' ;

LBRACE : '{' ;

RBRACE : '}' ;

LBRACKET : '[' ;

RBRACKET : ']' ;

EQ : '==' ;

NEQ : '=/=' ;

ASSIGN : '=' ;

BREAK : 'break' ;

CONTINUE : 'continue' ;

ARROW : '->' ;

COMMA : ',' ;

INCREMENT : '++' ;

DECREMENT : '--';

ADDASSIGN : '+=' ;

SUBASSIGN : '-=' ;

KW_INT : 'int' ;

KW_STRING : 'string' ;

KW_FLOAT : 'float' ;

KW_DOUBLE : 'double' ;

KW_BOOL : 'bool' ;

GT : '>' ;

LT : '<' ;

GE : '>=' ;

LE : '<=' ;

ASSEMBLY : 'asm' ;

NOT : '!' ;

OR : 'or' ;

AND : 'and' ;

NULL : 'null' ;

FALSE : 'false' ;

TRUE : 'true' ;

IN : 'in' ;

IF : 'if' ;

ELIF : 'elif' ;

ELSE : 'else' ;

WHILE : 'while' ;

FOR : 'for' ;

FN : 'func' ;

RETURN : 'return' ;

ID
    : [a-zA-Z_][a-zA-Z0-9_]*
    ;

INT
    : ('0x'|'0b')?[0-9]+
    ;

FLOAT
    : [0-9]+'.'[0-9]*
    ;

RANGE
    : [0-9]+'..'[0-9]+
    ;

STRING
    : UNTERMINATED_STRING '"'
    ;

UNTERMINATED_STRING
    : '"' (~["\\\r\n] | '\\' (. | EOF))*
    ;

WS : [ \t\n\r]+ -> skip ;
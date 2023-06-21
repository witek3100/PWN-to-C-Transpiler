# Grammar
List of tokens in Tokens.md file

### Non-terminal symbols

```antlrv4
START SYMBOL: program

program
statement
expression
assignment
assignmentType
declaration
arrayDeclaration
functionDefinition
argumentsDefinition
arguments
returnStatement
loopStatement
jumpStatement
jumpStatementType
ifStatement
elifStatement
elseStatement
whileStatement
iterable
increment
incrementType
index
forStatement
type
normalType
arrayType
functionCall
value
variableValue
literalValue
arrayLiteral
```


### Terminal symbols
```antlrv4
FN
FOR 
WHILE
ELSE
IF
IN
TRUE
FALSE
AND
OR
NOT
GT
LT
GE
LE
KW_INT
KW_STRING
KW_FLOAT
KW_DOUBLE
KW_BOOL
INT
FLOAT
STRING
UNTERMINATED_STRING
ADD
DIV
MUL
SUB
ID
RANGE
SEMICOLON
LPAR
RPAR
LBRACE
RBRACE
LBRACKET
RBRACKET
EQ
NEQ
ASSIGN
BREAK
CONTINUE
ARROW
COMMA
INCREMENT
DECREMENT
ADDASSIGN
SUBASSIGN
```




### Production rules

```antlrv4
program 
    : functionDefinition* statement+ EOF
    ;
```  
```antlrv4
statement 
    : assignment
    | increment
    | declaration
    | arrayDeclaration
    | returnStatement
    | ifStatement
    | whileStatement
    | forStatement
    ;
```
```antlrv4
loopStatement
    : statement | jumpStatement
    ;
```
```antlrv4
jumpStatement
    : jumpStatementType SEMICOLON
    ;
```
```antlrv4
jumpStatementType
    : BREAK | CONTINUE
    ;
```
```antlrv4
declaration
    : ID COLON type ASSIGN (expression | arrayLiteral) SEMICOLON 
    ;
```
```antlrv4
arrayDeclaration
    : ID COLON normalType LBRACKET INT RBRACKET SEMICOLON
    ;
```
```antlrv4
assignment
    : variableValue assignmentType expression SEMICOLON
    ;
```
```antlrv4
assignmentType
    : ASSIGN | ADDASSIGN | SUBASSIGN
    ;
```
```antlrv4
increment
    : variableValue incrementType SEMICOLON
    ;
```
```antlrv4
incrementType
    : INCREMENT | DECREMENT
    ;
```
```antlrv4
index
    : LBRACKET expression RBRACKET
    ;
```
```antlrv4
returnStatement
    : RETURN expression? SEMICOLON 
    ;
```
```antlrv4
ifStatement
    : IF LPAR expression RPAR LBRACE statement* RBRACE elifStatement* elseStatement?
    ;
```
```antlrv4
elifStatement
    : ELIF LPAR expression RPAR LBRACE statement* RBRACE
    ;
```
```antlrv4
elseStatement
    : ELSE LBRACE statement* RBRACE
    ;
```
```antlrv4
whileStatement
    : WHILE LPAR expression RPAR LBRACE loopStatement* RBRACE
    ;
```
```antlrv4
iterable
    : RANGE | ID
    ;
```
```antlrv4
forStatement 
    : FOR LPAR ID COLON type IN iterable RPAR LBRACE loopStatement* RBRACE
    ;
```
```antlrv4
functionDefinition
    : FN ID LPAR argumentsDefinition RPAR (ARROW normalType)? LBRACE statement* RBRACE
    ;
```
```antlrv4
argumentsDefinition
    : ((ID COLON type)(COMMA ID COLON type)*)?
    ;
```
```antlrv4
arguments
    : (expression (COMMA expression)*)?
    ;
```
```antlrv4
functionCall
    : ID LPAR arguments RPAR
    ;
```
```antlrv4
type
    : normalType | arrayType
    ;
```
```antlrv4
normalType
    : KW_INT | KW_FLOAT | KW_DOUBLE | KW_STRING | KW_BOOL
    ;
```
```antlrv4
arrayType
    : normalType LBRACKET RBRACKET
    ;
```
```antlrv4
expression
    : value                                      #valueExpression
    | LPAR expression RPAR                       #parenthesizedExpression
    | (NOT | SUB) expression                     #unaryExpression
    | expression (MUL | DIV | MOD) expression    #multiplicativeExpression
    | expression (ADD | SUB) expression          #additiveExpression
    | expression (LT | GT | LE | GE) expression  #comparisonExpression
    | expression (EQ | NEQ) expression           #equalityExpression
    | expression AND expression                  #andExpression
    | expression OR expression                   #orExpression
    ;
```
```antlrv4
variableValue
    : ID index?
    ;
```
```antlrv4
value
    : variableValue | literalValue | arrayLiteral | functionCall | ( LPAR value RPAR )
    ;
```
```antlrv4
arrayLiteral
    : LBRACKET (expression (COMMA expression)*)? RBRACKET
    ;
```
```antlrv4
literalValue
    : INT | FLOAT | STRING | TRUE | FALSE
    ;
```




# Grammar
list of tokens in TOKENS.md file

### Non-terminal symbols

```
    START SYMBOL: program

    program
    statement
    expression
    assignment
    declaration
    functionDefinition
    argumentsDefinition
    arguments
    returnStatement
    loopStatement
    ifStatement
    whileStatement
    iterable
    forStatement
    type
    functionCall
    value
    logicalValue
    logicalExpression
    operationExpression

```


### Terminal symbols
```
    FN
    FOR 
    WHILE
    ELSE
    IF
    IN
    TRUE
    FALSE
    NULL
    AND
    OR
    NO
    ASSEMBLY
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
    ADD
    DIV
    MUL
    SUB
    ID
    RANGE
    QUOTE
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

```
program 
    : functionDefinition* statement+ EOF
    ;
```  
```
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
```
loopStatement
    : statement | jumpStatement
    ;
```
```
jumpStatement
    : jumpStatementType SEMICOLON
    ;
```
```
jumpStatementType
    : BREAK | CONTINUE
    ;
```
```
declaration
    : ID COLON type ASSIGN expression SEMICOLON 
    ;
```
```
arrayDeclaration
    : ID COLON normalType LBRACKET INT RBRACKET SEMICOLON
    ;
```
```
assignment
    : variableValue assignmentType expression SEMICOLON
    ;
```
```
assignmentType
    : ASSIGN | ADDASSIGN | SUBASSIGN
    ;
```
```
increment
    : variableValue incrementType SEMICOLON
    ;
```
```
incrementType
    : INCREMENT | DECREMENT
    ;
```
```
index
    : LBRACKET expression RBRACKET
    ;
```
```
returnStatement
    : RETURN expression? SEMICOLON 
    ;
```
```
ifStatement
    : IF LPAR expression RPAR LBRACE statement* RBRACE elifStatement* elseStatement?
    ;
```
```
elifStatement
    : ELIF LPAR expression RPAR LBRACE statement* RBRACE
    ;
```
```
elseStatement
    : ELSE LBRACE statement* RBRACE
    ;
```
```
whileStatement
    : WHILE LPAR expression RPAR LBRACE loopStatement* RBRACE
    ;
```
```
iterable
    : RANGE | ID
    ;
```
```
forStatement 
    : FOR LPAR ID COLON type IN iterable RPAR LBRACE loopStatement* RBRACE
    ;
```
```
functionDefinition
    : FN ID LPAR argumentsDefinition RPAR (ARROW normalType)? LBRACE statement* RBRACE
    ;
```
```
argumentsDefinition
    : ((ID COLON type)(COMMA ID COLON type)*)?
    ;
```
```
arguments
    : (expression (COMMA expression)*)?
    ;
```
```
functionCall
    : ID LPAR arguments RPAR
    ;
```
```
type
    : normalType | arrayType
    ;
```
```
normalType
    : KW_INT | KW_FLOAT | KW_DOUBLE | KW_STRING | KW_BOOL
    ;
```
```
arrayType
    : normalType LBRACKET RBRACKET
    ;
```
```
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
```
```
variableValue
    : ID index?
    ;
```
```
value
    : variableValue | literalValue | arrayLiteral | functionCall | ( LPAR value RPAR )
    ;
```
```
arrayLiteral
    : LBRACKET (expression (COMMA expression)*)? RBRACKET
    ;
```
```
literalValue
    : INT | FLOAT | STRING | NULL | TRUE | FALSE
    ;
```




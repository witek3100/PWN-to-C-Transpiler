## List of tokens

|       Leksem        |                            Token                             |
|:-------------------:|:------------------------------------------------------------:|
|         ADD         |                             '+'                              |
|         DIV         |                             '/'                              |
|         MUL         |                             '*'                              |
|         MOD         |                             '%'                              |
|         SUB         |                             '-'                              |
|      SEMICOLON      |                             ';'                              |
|        COLON        |                             ':'                              |
|        LPAR         |                             '('                              |
|        RPAR         |                             ')'                              |
|       LBRACE        |                             '{'                              |
|       RBRACE        |                             '}'                              |
|      LBRACKET       |                             '['                              |
|      RBRACKET       |                             ']'                              |
|         EQ          |                             '=='                             |
|         NEQ         |                            '=/='                             |
|       ASSIGN        |                             '='                              |
|        BREAK        |                           'break'                            |
|      CONTINUE       |                          'continue'                          |
|        ARROW        |                             '->'                             |
|        COMMA        |                             ','                              |
|      INCREMENT      |                             '++'                             |
|      DECREMENT      |                             '--'                             |
|      ADDASSIGN      |                             '+='                             |
|      SUBASSIGN      |                             '-='                             |
|       KW_INT        |                            'int'                             |
|      KW_STRING      |                           'string'                           |
|      KW_FLOAT       |                           'float'                            |
|      KW_DOUBLE      |                           'double'                           |
|       KW_BOOL       |                            'bool'                            |
|         GT          |                             '>'                              |
|         LT          |                             '<'                              |
|         GE          |                             '>='                             |
|         LE          |                             '<='                             |
|         NOT         |                             '!'                              |
|         OR          |                             'or'                             |
|         AND         |                            'and'                             |
|        FALSE        |                           'false'                            |
|        TRUE         |                            'true'                            |
|         IN          |                             'in'                             |
|         IF          |                             'if'                             |
|        ELIF         |                            'elif'                            |
|        ELSE         |                            'else'                            |
|        WHILE        |                           'while'                            |
|         FOR         |                            'for'                             |
|         FN          |                            'func'                            |
|       RETURN        |                           'return'                           |
|         ID          |                    [a-zA-Z_][a-zA-Z0-9_]*                    |
|         INT         |       [0-9]+          \| '0x'[0-9a-fA-F]+ \| '0b'[01]+       |
|        FLOAT        |                       [0-9]+'.'[0-9]'                        |
|        RANGE        |                       [0-9]+'..'[0-9]+                       |
|       STRING        |                   UNTERMINATED_STRING '"'                    |
| UNTERMINATED_STRING | '"' (~["\\\\\r\n]                  \| '\\\\' (.    \| EOF))* |

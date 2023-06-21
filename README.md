# PWN to C Transpiler
### About project
The objective of this project was to develop a transpiler which translates code written in our own programming language called PWN into equivalent code in the widely recognized C. Whole thing is wrapped in user friendly interface allowing to load .pwn files and translate them into C.  
### Run
Clone the project into desired directory, if you have java installed on your machine just run:  
```
javac Main.java
```
### Technologies used
The whole project is written in Java and based on the ANTLR4 parser generator, the GUI was created in Swing.
### PWN programming language
PWN language draws from Python and C, it has readability of the first one but takes some ideas straight from the second one.
Example of code written in pwn:  
```
func add(a: int, b: int) -> int {
    c: int = a + b;
    return c;
}

a: string = "test";
b: float = 777.123;

arr: int[10];

for(i: int in 0..10) {
    arr[i] = add(i, 5);
}

j: int = 5;

while(j >= 0) {
    j--;
}
```
More examples as well as examples with errors to showcase the error handler are available in the `examples` directory
### Project structure
<pre>
    src
     ├── antlr
     |     ├── PWN.g4                        # PWN language grammar
     |     ├── PNW.interp
     |     ├── PWN.tokens                    
     |     ├── PWNBaseListener.java
     |     ├── PWNBaseVisitor.java
     |     ├── PWNLexer.interp
     |     ├── PWNLexer.java
     |     ├── PWNLexer.tokens
     |     ├── PWNListener.java
     |     ├── PWNParser.java
     |     ├── PWNVisitor.java
     |     └── antlr-4.12.0-complete.jar    # antlr java archive
     ├── Main.java                          # gui
     ├── PWNConverter.java                  # the actual converter logic class
     ├── PWNErrorListener.java              # custom syntax error handler
     ├── Value.java                         # helper class used to evaluate expressions
</pre>

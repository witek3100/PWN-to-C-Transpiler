# PWN to C Transpiler
### About project
The objective of this project was to develop a transpiler that translates code written in own projected PWN programming language into equivalent code in the widely recognized C. Whole thing wrapped in user friendly interface allowing to loading pwn and exporting c files quickly.  
### Run
Clone project into desiered directory, if you have java installed on your machine just run:  
```
javac Main.java
```
### Technologies used
Whole project is written in Java and based on antlr parser generator, gui was created in swing.  
### PWN programming language
PWN language draw from Python and C, it has readability of the first one but takes some ideas straight from the second one.
Example of code written in pwn:  
```
j: int = 5;
i: float = 6.0;

while ((i and j) or (j and i)) {
    c: int = i + j * 2;
}
```
### Project structure

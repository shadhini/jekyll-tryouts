# Writing first program


* **Identifier or name** – a word that refers to something in a program (such as a variable or a function name)
* each statement has to end with `;`

## The public class
* Every Java program must have at least one class. 

```
public class <Class_Name> {
    // ...
}
```
* A class can have any name, but it must not start with a digit.

```java
public class Main {
    // ...
}
```


## The main method
* To make the program runnable, we put a method named main inside a class. 
* It is the entry point for a Java program;  first to be executed when the program runs

```java
public static void main(String[] args) {
    // statements go here
}
```

* The name of this method (main) is predefined and should always be the same. 
* **Capitalization matters:** if you name your first method Main, MAIN or something else, the program cannot start.

* `String[] args` represents a sequence of arguments passed to the program from the outside world. 

 
---

[Related]
* src/main/java/HelloWorld.java

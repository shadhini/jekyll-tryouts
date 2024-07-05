# Method `"main"`

## The declaration of the main method
* Java is an `object-oriented` language
* Even the simplest `"procedural-style"` program should have at least one class and the main method inside to start the program.
  * Ever since Java 7, there has been no other way to start an application than with this method 
  (excluding the case in which you start your application inside a special container).

```java
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, Java");
    }
}
```
* `public` --> indicates that the method can be invoked from everywhere
* `static` --> indicates the method can be invoked without creating an instance of the class
* `void` --> indicates the method doesn't return any value
* the array variable `args` --> contains arguments entered at the command line, the array is empty if there are no arguments


## Invalid declarations of the main method

* Your program cannot be compiled. 
  * This is the case when the main method declaration breaks the syntax of Java.
* A program can be compiled but cannot be run. 
  * This is the case when the main method has a correct declaration as a regular method 
  but doesn't satisfy the specific requirement of the main method.

# Comments
text that will be ignored by the Java compiler 
* allow you to exclude code from the compilation process (disable it) or clarify a piece of code 

## 1. End-of-line comments
Java compiler ignores any text from `//` to the end of the line.
- For short explanations or to deactivate a single code line.

```java
class Program {
    public static void main(String[] args) {
        // The line below will be ignored
        // System.out.println("Hello, World");
        // It prints the string "Hello, Java"
        System.out.println("Hello, Java"); // Here can be any comment
    }
}
```

## 2. Multi-line comments
The compiler ignores any text from `/*` to the nearest `*/`. 
* It can be used for multiple and single-line comments.
* For detailed notes or disabling code sections

```java
class Program {
    public static void main(String[] args) {
        /* This is a single-line comment */
        /*  This is an example of
        a multi-line comment */
    }
}
```

You can nest end-of-line comments inside multi-line comments:
```java
class Program {
    public static void main(String[] args) {
        /*
        System.out.println("Hello"); // print "Hello"
        System.out.println("Java");  // print "Java"
        */
    }
}
```


## 3. Java documentation comments
The compiler ignores any text from `/**` to `*/` just like it ignores multi-line comments.
* These kinds of comments can be used to automatically generate documentation about your source code by using the javadoc tool.
* Usually, these comments are placed above declarations of classes, interfaces, methods and so on. 
* Some special labels such as `@param` or `@return` are often used for controlling the tool. 

* For official code documentation using javadoc

```java
class Program {
    /**
    * The main method accepts an array of string arguments
    *
    * @param args from the command line
    */
    public static void main(String[] args) {
        // do nothing
    }
}
```
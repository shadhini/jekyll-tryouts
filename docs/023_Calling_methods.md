# Calling methods
```java
public class Main {
    public static void main(String[] args) {
        calculateVolume(3, 7, 2); // The volume of a box is equal to 42
        calculateVolume(14, 6, 8); // The volume of a box is equal to 672
        calculateVolume(2, 2, 2); // The volume of a box is equal to 8
    }

    static void calculateVolume(int length, int width, int height) {
        int volume = length * width * height;
        System.out.println("The volume of a box is equal to " + volume);
    }
}
```
## Instance Methods
Methods that operate on specific instances are called instance methods. 
* These method require an instance(an instance object to be invoked) to be created before it can be called.


```java
String s = "HellO, WoRlD!";
s = s.toLowerCase(); // hello, world!
```


## Built-in methods 
It is more efficient to use `pre-defined` methods that are always available to the user. 

2 types of methods in Java: 
1. `built-in` methods : belong to the Standard Java library
2. `user-defined` methods : created by the programmer

```java
Math.round(79.378); // method with Math class name
Character.isLetter('a'); // method with Character class name
```


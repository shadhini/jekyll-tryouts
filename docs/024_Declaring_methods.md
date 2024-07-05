# Declaring methods

![syntax_of_method.png](pics%2Fsyntax_of_method.png)
```
<Modifiers> <Return Type> <Method Name>(<Parameter List>) {
    // Method body
}
```

* The combination of the `name` of the method and the `list of its parameters` is known as a `method signature`

## Name of the method

### Rules for legal identifiers

* identifiers are case-sensitive
* an identifier can include Unicode letters, digits, underscore `_` or currency characters, such as `$`
* an identifier can't start with a digit 
* identifiers must not be a keyword

### Naming Convention [Optional]

* a one-word name should be a verb in lowercase: 
    ```
    e.g.: sum, multiply, or round
    ```
* If a method has a multi-word name, the first letter of the second and the following words should be capitalized:
    ```
    e.g.: getValue, calculateNumberOfOranges, or findLetter
    ```
## Modifiers

### 1. Access Modifiers
* define the visibility of the method.

1.1. `public` --> means there are no restrictions for invoking the method from anywhere

### 2. Non-access Modifiers
* provide information about the behavior of methods to JVM

2.1. `static` --> means that the method belongs to the class itself, not to any specific instance of the class
* and it can be accessed without creating any object 
* `static methods`

2.2. without the `static` modifier --> means that the method can be invoked only through or with an object 
or instance of this class. 
* `instance methods`

## Body and return statement

```java
public static int countSeeds(int parrotWeight, int parrotAge) {
    return parrotWeight / 5 + parrotAge; // it returns an int
}
```

## What happens when we invoke a method
When invoking a method, we can write the returned value to some variable, print it out, or pass it on to another method.
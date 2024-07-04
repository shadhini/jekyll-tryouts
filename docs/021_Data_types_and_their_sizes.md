# Data types and their sizes

## Numbers
several types for `integers` and `fractional` numbers

### Integer numbers (0, 1, 2, ...)
* `byte`: size 8 bits (1 byte), ranging from `-128` to `127`
* `short`: size 16 bits (2 bytes), ranging from `-32,768` to `32,767`
* `int`: size 32 bits (4 bytes), ranging from `-2,147,483,648` to `2,147,483,647`
* `long`: size 64 bits (8 bytes), ranging from `-9,223,372,036,854,775,808` to `9,223,372,036,854,775,807`
    ```java
     long million = 1_000_000L;
    ```

** The sizes of types are always the same. 
They do not depend on the operating system or hardware and cannot be changed.

### Floating-point types represent numbers with fractional parts. 
* `double`: (64 bits)
* `float`: (32 bits)
  * `float` value is marked with `f`
    ```java
    float f = 2.71828f;
    ```

** These types can store only a limited number of significant decimal digits (~6-7 for `float` and ~14-16 for `double`).

## Characters

`char` type represents letters (uppercase and lowercase), digits, and other symbols. 
* Each character is just a single letter enclosed in single quotes. 
* This type has the same size as the `short` type (`2 bytes` = 16 bits).

## Booleans

`boolean` type can store only two values: `true` and `false`
* It represents only `one bit` of information, but its size is not precisely defined
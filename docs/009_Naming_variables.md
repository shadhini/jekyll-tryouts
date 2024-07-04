# Naming variables

## Rules for naming variables

* names are case-sensitive
* a name can include Unicode letters, digits, and two special characters (`$`, `_`)
* a name cannot start with a digit 
* a name must not be a keyword (`class`, `static`, `int`, etc. are illegal names)
* whitespaces are not allowed in the name of a variable

Some valid variable names
```
number, $ident, bigValue, _val, abc, k, var
```
[**Note**] To keep backward compatibility the word var can be used as a variable name even after **Java 10** was released.

Since **Java 9** the single character `_` is an invalid name for a variable, but `_a` and `__` (a double `_` ) are legal names.

## Naming conventions for variables

* if a variable name is a single word it should be in **lowercase**
    ```
    number, price
    ```
* if a variable name includes multiple words it should be in **lowerCamelCase**, 
i.e. the first word should be in lowercase and each word after the first should have its first letter written in uppercase 
    ```
    numberOfCoins, totalPrice
    ```
* variable names should not start with `_` and `$` characters, although they are allowed
* choose a name that makes sense
  * e.g. score makes more sense than s, although they are both valid
* Only the names of constant variables and of ANSI constants should be all uppercase with words separated by underscores ("_").
    ```
    MAX_WIDTH, MIN_WIDTH, GET_THE_CPU.
    ```
  * That said, `which_case` case is not used in Java
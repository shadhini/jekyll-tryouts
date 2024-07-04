# Arithmetic Operations

## Binary arithmetic operators
called `binary` --> because they take two values as operands

* addition `+`
* subtraction `-`
* multiplication `*`
* division `/`
  * returns the integer part of the division of two integer numbers, and any fractional part is discarded
      ```java
        System.out.println(8 / 3); // prints 2
        System.out.println(41 / 5); // prints 8
      ```
* remainder `%` - modulo operator
  * returns the remainder of the division of two numbers
  * when the dividend is less than the divisor, the quotient is zero and the remainder equals the dividend
    ```java
        System.out.println(10 % 3); // prints 1, because 10 divided by 3 leaves a remainder of 1
        System.out.println(12 % 4); // prints 0, because 12 divided by 4 leaves no remainder
        System.out.println(5 % 9); // prints 5, because 5 divided by 9 leaves a remainder of 5
    ```


## Writing complex expressions

* The order of operations follows the standard arithmetic rules.
* To specify the order of execution we can use `parentheses`.

```java
System.out.println(1 + 3 * 4 - 2); // prints 11
System.out.println((1 + 3) * (4 - 2)); // prints 8
```

## Unary operators
A unary operator takes a single value as the operand.

* `unary plus` operator indicates a positive value. 
  * optional operator
* `unary minus` operator negates a value or an expression.
* both have a `higher level of precedence` than the **multiplication** and **division** operators.

```java
System.out.println(+5); // prints 5
System.out.println(-8);  // prints -8
System.out.println(-(100 + 4)); // prints -104
```

## The precedence order
The list below is sorted from the highest to the lowest precedence level.

1. parentheses
2. unary plus/minus
3. multiplication, division, the remainder
4. addition, subtraction

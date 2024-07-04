# Comparing values | Relational operators
* used for comparing values. 

## List of relational operators

* `==` (equal to)
* `!=` (not equal to)
* `>` (greater than)
* `>=` (greater than or equal to)
* `<` (less than)
* `<=` (less than or equal to)

The `result` of applying a relational operator to its operands will be `boolean (true or false)` 
regardless of the types of operands.

## Comparing integer numbers
```java
int one = 1;
int two = 2;
int three = 3;
int four = 4;

boolean oneIsOne = one == one; // true

boolean res1 = two <= three; // true
boolean res2 = two != four;  // true
boolean res3 = two > four;   // false
boolean res4 = one == three; // false
```

Relational operators can be used in `mixed expressions` together with `arithmetic operators`. 
* In such expressions, `relational operators have lower priorities` than arithmetic operators.

    ```java
    int number = 1000;
    boolean result = number + 10 > number + 9; // 1010 > 1009 is true
    ```

## Joining relational operations using logical operators
In Java, you cannot write an expression like `a <= b <= c`. 
Instead, you should join two boolean expressions using logical operators like `||` and `&&`.

```java
number > 100 && number < 200; // it means 100 < number < 200
```

parentheses can be used to improve readability
* But parentheses are not necessary here because relational operators have a higher priority than logical operators.
```java
(number > 100) && (number < 200);
```

```java
int number = ...             // it has a value
int low = 100, high = 200;   // borders

boolean inRange = number > low && number < high;  // joining two expressions using AND.
```
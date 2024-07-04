# Boolean type and operations | True and False

## Boolean type | Logical type
`boolean` has only 2 possible values: `false` and `true`

```java
boolean open = true;
boolean closed = false;

System.out.println(open);   // true
System.out.println(closed); // false
```

[**Important**]

You cannot assign an integer value to a boolean variable. 
In Java, `0` is not the same as `false`.

## Logical operators 

### NOT `!`
a unary operator that reverses the boolean value.

```java
boolean f = false; // f is false
boolean t = !f;    // t is true
```

### AND ` &&`
a binary operator that 
* returns true if both operands are true, 
* otherwise, it returns false.

```java
boolean b1 = false && false; // false
boolean b2 = false && true;  // false
boolean b3 = true && false;  // false
boolean b4 = true && true;   // true
```


### OR `||`
a binary operator that 
* returns true if at least one operand is true, 
* otherwise, it returns false

```java
boolean b1 = false || false; // false
boolean b2 = false || true;  // true
boolean b3 = true || false;  // true
boolean b4 = true || true;   // true
```

### XOR (exclusive OR) `^`
a binary operator that 
* returns true if boolean operands have different values, 
* otherwise, it returns false

```java
boolean b1 = false ^ false; // false
boolean b2 = false ^ true;  // true
boolean b3 = true ^ false;  // true
boolean b4 = true ^ true;   // false
```

* The XOR operator is used less often than the others. 

## The precedence of logical operators
Here are the logical operations sorted in order of decreasing priorities in expressions: 
1. ! (NOT)
2. ^ (XOR)
3. && (AND)
4. || (OR).

```java
boolean b = true && !false;// true, because !false is evaluated before &&
```

* To change the order of execution you can use `parentheses (...)`

## An example; trekking
a  boolean expression that determines the possibility of trekking in summer and in other seasons.
* suppose that the right conditions for trekking are 
  * dry warm weather in any season or 
  * dry weather in summer

```java
boolean cold = false;
boolean dry = true;
boolean summer = false; // suppose now is autumn

boolean trekking = dry && (!cold || summer); // true, let's go trekking!
```

## Short-circuiting evaluation
The `&&` and `||` operators don't evaluate the second argument if it isn't necessary. 
* When the first argument of the `&&` operator evaluates to false, the overall value must be false; and 
* when the first argument of the `||` operator evaluates to true, the overall value must be true. 

```
false && ... -> false
true || ... -> true
```

This behavior is known as `short-circuit evaluation`. 
* It reduces the computation time, 
* but can also be used to avoid some errors in programs. 



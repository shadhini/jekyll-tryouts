# One-line condition with Ternary operator
evaluates a condition and chooses one of two cases to execute
```
result = condition ? trueCase : elseCase;
```
* also called the conditional operator
* a form of the `if-then-else` statement
* can be used in places where an expression is expected
* Java allows us to nest one ternary operator into another one, 
  * but it can be less readable than the corresponding conditional statement


Conditional Statement
```java
int a = ...;
int b = ...;
int max = ...;

if (a > b) {
    max = a;
} else {
    max = b;
}
```
Equivalent Ternary Operator
```java
int max = a > b ? a : b;
```
* This type determines the type of the result

## Examples

```java
int num = ...;  // it's initialized by a value
System.out.println(num % 2 == 0 ? "even" : "odd");
```

compare two integer numbers and print 
* `equal` in case they are equal, 
* `more` if the first one has a bigger value than the second and 
* `less` otherwise

```java
int a = ...; // it's initialized by a value
int b = ...; // it's initialized by a value
String result = a == b ? "equal" :
a > b ? "more" : "less";
```
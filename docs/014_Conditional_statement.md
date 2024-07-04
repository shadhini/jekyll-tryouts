# Conditional Statement
* often use the term `"control flow statements"`
  * `Control flow` is the order in which various parts of a program are executed.
* conditional statements can be nexted

## The single if-case

---
```java
if (expression) {
    // body: do something
}
```
---

```java
int age = ...; // it has a value
if (age > 100) {
    System.out.println("Very experienced person");
}
```
```java
boolean b = ...; // it is true or false
if (b) { // or !b
    // do something
}
```
## The if-else-cases

---
```java
if (expression) {    
    // do something
} else {
    // do something else
}
```

---
```java
int num = ...; // the num is initialized by some value

if (num % 2 == 0) {
    System.out.println("It's an even number");
} else {    
    System.out.println("It's an odd number");
}
```

## The if-else-if-cases

---
```java
if (expression0) {
    // do something
} else if (expression1) {
    // do something else 1
// ...
} else if (expressionN) {
    // do something else N
}
```
---
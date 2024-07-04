# `for` loop

## The basic for-loop syntax

```
for (initialization; condition; modification) {
    // do something
} 
```

## Examples

```java
int n = 9;
for (int i = 0; i <= n; i++) {
    System.out.print(i + " "); // here, a space is used to separate numbers
}
```

## Skipping parts
The initialization statement, the condition, and the modification parts are optional, 
the for loop might not have all of them.

```java
int i = 10;
for (; i > 0; i--) {
    System.out.print(i + " ");
}
```

It is also possible to write an `infinite loop` without these parts at all.
```java
for (;;) {
    // do something
}
```

## Nested loops

```java
for (int i = 1; i < 10; i++) {
    for (int j = 1; j < 10; j++) {
        System.out.print(i * j + "\t");
    }
    System.out.println();
}
```
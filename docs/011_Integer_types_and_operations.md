# Integer Types and Operations

## int

## long
If a number ends with the letter `L` or `l`, it is considered as `long`, otherwise, it is `int`.

```java
int bigNumber = 5_000_000_000; //won't compile due to the value exceeding the maximum capacity of an int
long bigNumber = 5_000_000_000L; //compiles successfully
```

[**Recommendations**]
* recommend using the uppercase letter `L` for long
* Use long numbers only if it is really necessary (when you deal with `numbers larger than two billion`)

## The forms of the assignment operator

`*=, /=, %=, +=, -=, <<=, >>=, >>>=, &=, ^=, |=*`

```java
int n = 10;
n += 4; // 14
```

---
[Related]
src/main/java/IntegerTypesAndOperations.java


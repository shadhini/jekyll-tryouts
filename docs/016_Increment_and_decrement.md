# Increment and Decrement

## Using `++` and `--` in Java

```java
int n = 10;
n++; // 11
n--; // 10
```

```java
int n = 10;
n += 1; // 11
n -= 1; // 10
```

## Prefix and postfix forms

* the `prefix form` (`++n` or `--n`) increases or decreases the value of a variable `before it is used`
* the `postfix form` (`n++` or `n--`) increases or decreases the value of a variable `after it is used`

```java
int a = 4;
int b = ++a;

System.out.println(a); // 5
System.out.println(b); // 5
```
```java
int a = 4;
int b = a++;

System.out.println(a); // 5
System.out.println(b); // 4
```
```java
int a = 4;
System.out.println(a++ + a); // this is 9
```
```java
int a = 16;
int b = 4;
int remainder = --a % b++; // 15 % 4
System.out.println(remainder); // 3
```
```java
int a = 4;
// System.out.println(a++);
int b = a++; // b=4, a=5
System.out.println(a + " " + b);
int c = --a + b++; // 4 + 4 = 8
System.out.println(a + " " + b + " " + c); // a=4, b=5, c=8
// System.out.println(++a + " " + c++ + " " + b + " " + c);
int result = ++a - (c++ - b) + c; // 5 - (8 - 5) + 9
```

```java
int result = 5;
int a = 1;
int b = --a;// b=0, a=0
System.out.println(a + " " + b); // 0 0
a++;// a=1
System.out.println(a + " " + b); // 1 0
result += a + (--a / ++b); // 5 += 1 + (0 / 1) = 6
System.out.println(a + " " + b); // 0 1
```
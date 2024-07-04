# Type Casting

to assign a value of one type to a variable of another type

Java provides two kinds of casting for primitive types: `implicit` and `explicit`. 
* `Implicit casting` is performed automatically by the Java compiler when it is possible
* `Explicit casting` is done by the programmer


* it is impossible to cast `boolean` type to any other and vice versa


## Implicit casting
The compiler automatically performs implicit casting when the target type is wider than the source type. 

### The direction of implicit primitive type castings
![implicit_primitive_type_castings.png](pics%2Fimplicit_primitive_type_castings.png)

Any value of a given type can be assigned to the one on the right implicitly or below in the case of `char`.

* Normally, there is no loss of information when the target type is wider than the source typ
* But it is not possible to automatically cast in the backward order

In some cases, implicit type casting may result in some `information loss`. 
* When we convert an `int` to `float`, or a `long` to `float` or to `double`, 
we may lose some less significant bits of the value, which will result in a `loss of `precision`. 
* However, the result of this conversion will be a correctly rounded version of the integer value, 
which will be in the overall range of the target type.

```java
long bigLong =  1_200_000_002L;
float bigFloat = bigLong; // 1.2E9 (= 1_200_000_000)
```

When we convert a `char` to an `int` in Java, we actually get the `ASCII` value for a given character.

```java
char character = 'a';
char upperCase = 'A';

int ascii1 = character; // this is 97
int ascii2 = upperCase; // this is 65
```

[**Note**]
Java uses `Unicode Character Representations (UTF-16)`, 
which is a superset of `ASCII` and includes a by far larger set of symbols. 
However, the numbers `0–127` have the same values in ASCII and Unicode.

## Explicit casting

implicit casting does not work when the target type is narrower than the source type.

But programmers can apply `explicit casting` to a source type to get another type they want. 
* It may lose information about the overall magnitude of a numeric value and may also lose precision.

```
(targetType) source
```

```java
double d = 2.00003;

// it loses the fractional part
long l =  (long) d; // 2

// requires explicit casting because long is wider than int
int i = (int) l; // 2 

// requires explicit casting because the result is long (indicated by L)
int val = (int) (3 + 2L); // 5

// casting from a long literal to char
char ch = (char) 55L; // '7'
```

Explicit casting may `truncate the value` because `long` and `doubl`e can store a much larger number than `int`.

==> `Type Overflow`

* The same problem may occur when casting `int` to `short` or `byte`
```java
long bigNum = 100_000_000_000_000L;
int n = (int) bigNum; // 276447232
```

Explicit casting also works when implicit casting is enough.
* redundant casting should not be used to avoid unnecessary constructs in your code

```java
int num = 10;
long bigNum = (long) num; // redundant casting
```

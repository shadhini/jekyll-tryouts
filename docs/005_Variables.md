# Variables
a `variable` is a placeholder for storing a value of a particular type: a string, a number, or something else

## Declaring and initializing
Every variable has a `name` (also known as an `identifier`) to distinguish it from others. 
* name of a variable cannot start with a digit; it usually starts with a letter
* variable names are `case-sensitive`; case makes a difference

General form of variable declaration:
```
DataType variableName = initialization;
```

* left part --> describes the variable
* right part --> describes something that is assigned to it
* `=`(assignment operator) is used to assign a single value or a result of an expression to a variable.

E.g:
```java
String language = "java";
int numberOfApples = 5;
```

## Accessing the value of a variable

```java
String dayOfWeek = "Monday";
System.out.println(dayOfWeek); // Monday

int one = 1;
int num = one;
System.out.println(num); // 1
```


**variables can be changed**
* You don't need to declare a variable again to change its value; just assign a new value to it using the = operator.
* you can only assign a value of the same type as the type of the initial variable.

```java
String dayOfWeek = "Monday";
System.out.println(dayOfWeek); // Monday

dayOfWeek = "Tuesday";
System.out.println(dayOfWeek); // Tuesday


int number = 10;
number = 11; // ok
number = "twelve"; // it does not work!
```

## Alternative forms of declaration

Declaring several variables of the same type as a single statement:
```java
String language = "java", version = "8 or newer";
```

Separating declaration and initialization into statements:
```java
int age; // declaration
age = 35; // initialization 
```

## Type inference [Since Java 10]
Since Java 10, you can write `var` instead of a specific type to force automatic type inference based on the type of assigned value.

controversial feature:
* it allows your code to be more concise.
* since it doesn't indicate the type explicitly, it may affect the code readability in a bad way.
```
var variableName = initialization;
```

```java
var language = "Java"; // String
var version = 10; // int
```



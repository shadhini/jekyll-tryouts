# Break and continue | Branching

## The `break` statement

1. it `terminates the current loop` of any type (for, while, do-while)
    * The break statement terminates only the loop in which it is currently located. 
    * If this loop is performed inside another loop, the `outer loop won't be stopped`.
2. it `terminates a case` in the switch statement

```java
int i = 10;
while (true) { // the condition to continue the loop
    if (i == 0) { // the condition to perform the break that stops this loop 
        break;
    }
    i--;
}
```

```java
for (int i = 0; i < 10; i++) {
    for (int j = 0; j < 10; j++) {
        System.out.print(j + " ");
        if (i == j) {
            break;
        }
    }
    System.out.println();
}
```

The break statement can't stop the outer loop (with variable i) and the code prints:
```
0 
0 1 
0 1 2 
0 1 2 3 
0 1 2 3 4 
0 1 2 3 4 5 
0 1 2 3 4 5 6 
0 1 2 3 4 5 6 7 
0 1 2 3 4 5 6 7 8 
0 1 2 3 4 5 6 7 8 9 
```
To stop the outer loop we could declare a Boolean variable `stopped` and use it as a `special Boolean flag`.

```java
boolean stopped = false;
for (int i = 0; i < 10 && !stopped; i++) {
    for (int j = 0; j < 10; j++) {
        System.out.print(j + " ");
        if (i == j) {
            stopped = true;
            break;
        }
     }
    System.out.println();
}
```
Now, output
```
0
```

### The labeled `break `operator [not a good practice]
- stop the outer loop

```java
outerLoop:
for (int i = 0; i < 10; i++) {
    for (int j = 0; j < 10; j++) {
        System.out.print(j + " ");
        if (i == j) {
            break outerLoop; // Break out of both loops.
        }
    }
    System.out.println();
}
```

## The `continue` statement
It causes a loop to skip the current iteration and go to the next one.

* inside the `for-loop`, the continue statement causes control to 
`immediately move to the increment/decrement` statement
* inside the `while or do-while loop`, control `immediately moves to the condition`


* The `continue` statement and the `break` statement `only affect the loop in which they are located`. 
* The `continue` statement `cannot skip` the current iteration of the `outer loop`.


```java
int n = 10;
for (int i = 0; i < n; i++) {
    if (i % 2 != 0) {
        continue;
    }
    System.out.print(i + " ");
}
```
Output:
```
0 2 4 6 8
```
Often, we can rewrite our loop without using the continue statement.
```java
int n = 10;
for (int i = 0; i < n; i++) { 
    if (i % 2 == 0) {
        System.out.print(i + " ");
    } 
}
```

[**Important**]
**Use branching wisely** — only when it helps to make code shorter and easier to understand for humans.

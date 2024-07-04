# Reading user's input with Scanner
The `standard input` is a data stream going into a program and supported by the operating system. 
* By default, the standard input acquires data from keyboard input, but it can be redirected from a file.

Typical programming problem solving
1. Read data from the standard input (System.in);
2. Process data to obtain a result;
3. Output the result to the standard output (System.out).

## Reading data with a scanner
Obtain data from standard input using the standard class `Scanner`.


In Java, `whitespace` includes everything that appears empty when printed: 
a whitespace, a tab, the newline character, and other non-printing characters.


`"word"` is a `token`, which can be described as a piece of text surrounded by whitespace. 

```
scanner.next()     --> locates and returns the next token as a string
                       skip the whitespace until it finds the next token
scanner.nextLine() --> reads all data till the end of the current line
                       and includes all space characters it encounters
scanner.nextInt()  --> reads the next token as an integer
```

## Reading a multiline input
* nextLine() reads input from the cursor's position to the new line (again, if such a line exists in your input).
* when next() method is called repeated to read tokens of a line of input, in the end, the cursor is placed before the new line. 
* If nextLine() method is called afterward, it will return an empty line ("") and place the cursor at the start of a new line


## Reading numbers from the standard input
```java
    Scanner scanner = new Scanner(System.in);
        
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    int sum = a + b;
```

If we know that the input numbers can be quite large, we can read `long`s instead of `int`s
```java
long a = scanner.nextLong();
long b = scanner.nextLong();

long sum = a + b;
```

---

[Related]
* src/main/java/ReadUserInputWithScanner.java
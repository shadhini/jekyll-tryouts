# While and do-while loops

# The `while` loop

* If the condition is `true`, the code within the block is executed. 
* This code repeats until the condition becomes `false`. 
* Since this loop checks the condition before the block is executed, 
the control structure is also known as a `pre-test loop`.

```
while (condition) {
    // body: do something repetitive
}
```

* It is also possible to write an `infinite loop` if the condition is invariably `true`.

```
while (true) {
    // body: do something indefinitely
}
```

```java
public class WhileDemo {
    // displays English letters in a single line
    public static void main(String[] args) {
        char letter = 'A';
        while (letter <= 'Z') {
            System.out.print(letter);
            letter++;
        }
    }
}
```

## The `do-while` loop

* The body is executed first, while the condition is tested afterwards.
* If the condition is `true`, statements within the block are executed again. 
* This repeats until the condition becomes `false`. 
* Because `do-while` loops check the condition after the block is executed, 
the control structure is often also known as a `post-test loop`.
* `do-while` loop is an `exit-condition loop`. 
  * So, the code within the block is always executed **at least once**.
* The do-while loop can be `infinite`.

```
do {
    // body: do something
} while (condition);
```

```java
public class DoWhileDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int value;
        do {
            value = scanner.nextInt();
            System.out.println(value);
        } while (value != 0);
    }
}
```


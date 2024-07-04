# Coding style conventions | Coding style guide 

---
[Oracle Code Conventions](https://www.oracle.com/technetwork/java/codeconventions-150003.pdf)

[Google Style Guide](https://google.github.io/styleguide/javaguide.html)

---
1. 4 spaces as the unit of **indentation**
   * Sometimes `tabulation` is used to create an indentation. However, tab may correspond to 8 spaces instead of 4 in some IDEs
2. Location of curly braces
   * Put the `opening curly brace` at the `end of the line` where the block begins. 
   * Put the `closing curly brace` at the `beginning of the next line`.
3. Avoid extra spaces
   * Avoid extra spaces within parentheses
   * Avoid an extra space before an open parenthesis
   * Avoid extra spaces before a semicolon
   ```java
   // Good
    System.out.println("No extra spaces");
    ```
4. The length of a line
   * Oracle Code Conventions propose avoiding lines longer than `80 characters`
   * Other popular limit values are 100, 120, and sometimes even 140 characters
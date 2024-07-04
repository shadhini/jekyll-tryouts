# Multiple conditions: switch
enhances code readability, efficiency, and organization compared to lengthy if-else chains, 
making it valuable for handling multiple conditions.

## When a conditional statement is not so good
When a program  performs different actions depending on the value of a variable. 

For example, choosing an action from the menu of a game. 

## Three keywords: switch, case, and default
provides a way to choose between multiple cases based on the value of a single variable (not an expression!)

* The variable can be an integer number, character, string, or enumeration.
* `break` stops the execution of the whole switch statement, not just one case. 
* If a case does **not have** the `break` keyword, the following case will be executed as well, 
including the `default` case. 
* The `default` case is also executed if there's no other case that matches the variable value. 
* The `break` keyword in the default branch is optional and can be omitted.


* A `case` section may contain any block of code, even a nested switch statement, 
  * however, it is recommended to avoid deeply nested code structures whenever possible.

```
switch (variable) {
    case value1:
        // do something here
        break;
    case value2:
        // do something here
        break;
    
    //... other cases
    
    case valueN:
        // do something here
        break;
    default:
        // do something by default
        break; // it can be omitted
}
```

```java
switch (action) {
    case 1:
        System.out.println("Starting a new game...");
        break;
    case 2:
        System.out.println("Loading a saved game");
        break;
    case 3:
        System.out.println("Displaying help...");
        break;
    case 4:
        System.out.println("Exiting...");
        break;
    default:
        System.out.println("Unsuitable action, please, try again");
}
```

```java
int val = ...;
switch (val) {
     case 0:
         System.out.println("zero");
         break;
     case 1:
         System.out.println("one");
         break;
     case 2:
         System.out.println("two");
         break;
     default:
         System.out.println("The value is less than zero or greater than two");
} 
```

[**Note**]

`Java 12` introduced some new features allowing to use switch as an `expression`.



import java.util.Scanner;

/**
 * Reading user's input with Scanner
 */
public class ReadUserInputWithScanner {
    public static void main(String[] args) {

        // System.in signals that the program will read the text that you entered in the standard input.
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name: "); // prompt message
        // If your input is an integer number or a single word, you can use the next() method.
        // next() method only reads a single word and excludes any whitespace.
        String name = scanner.next();
        System.out.println("Hello, " + name + "!");
        // if a user inputs a compound name like 'Erich Maria' The program will only output the first word
        // In this case, you'll need to invoke the next() method again:
        String firstName = name; // "Erich"
        String lastName = scanner.next(); // "Maria"
        System.out.println("Hello, " + firstName + " " + lastName  + "!");

        scanner.nextLine(); // to consume the newline character
        //  If the nextLine() method is called after next(),
        //  The next() method doesn't consume the newline character,
        //  which causes the subsequent nextLine() to read the remaining newline character
        //  instead of waiting for user input.
        System.out.println("Enter your school name: "); // prompt message
        // the nextLine() method reads and outputs the entire line
        // and includes all space characters it encounters
        String school = scanner.nextLine();
        System.out.println("I'm from " + school);

        scanner.close();

        // ------------------------------------------------
        sum();
    }

    /**
     * Reading numbers from the standard input and summing them
     * Sample input:
     * 10
     * 7
     */
    public static void sum() {
        Scanner scanner = new Scanner(System.in);
        int firstNumber = scanner.nextInt();
        int secondNumber = scanner.nextInt();
        int sum = firstNumber + secondNumber;
        System.out.println("The sum is: " + sum);
        scanner.close();
    }



}

import java.util.Scanner;

/**
 * Determining Fizz, Buzz, or FizzBuzz for a number
 * Given a number as input, if the number is divisible by 5 print 'Fizz',
 * if it is divisible by 3 print 'Buzz', and
 * if it is divisible by both 3 and 5 print 'FizzBuzz'.
 * In case none of these conditions are met print the input number.
 */
public class FizzBuzz {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        String result = input % 5 == 0 ? (input % 3 == 0 ? "FizzBuzz" : "Fizz") : (input % 3 == 0 ? "Buzz" : String.valueOf(input));
        /*
        String result = (input % 5 == 0 && input % 3 == 0) ? "FizzBuzz"
                : (input % 5 == 0) ? "Fizz"
                : (input % 3 == 0) ? "Buzz"
                : String.valueOf(input);

         */


        System.out.println(result);
    }
}

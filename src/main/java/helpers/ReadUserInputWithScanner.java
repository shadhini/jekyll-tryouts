package helpers;

import java.util.Scanner;

public class ReadUserInputWithScanner {
    public static void main(String[] args) {
        readIntegerSetWithUnknownLength();
    }

    /**
     * Read Integer Set with Unknown Length
     */
    public static void readIntegerSetWithUnknownLength() {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        while (scanner.hasNextInt()) {
            int elem = scanner.nextInt();
            sum += elem;
        }

        System.out.println(sum);
    }

}



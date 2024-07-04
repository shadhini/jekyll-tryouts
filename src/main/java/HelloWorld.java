// Every Java application has to have at least one class

public class HelloWorld { // like the birth certificate of the program; a kind of blueprint

    /**
     * Output: Hello, World!
     */
    public static void main(String[] args) { // where the execution begins
        System.out.println("Hello, World!");
        // The function prints output to the console because 'System.out' refers to the standard output stream.

        System.out.println("========================================");
        printlnTest();
        System.out.println("========================================");
        printTest();
        System.out.println("\n========================================");
        printNumbersNCharactersTest();

        System.out.println("========================================");
        System.out.println(5 + 7 + " is a number.");

    }

    /**
     * println() method
     * =================
     * Output:
     * I
     * know
     * Java
     * well.
     * Java is a popular programming language.
     *
     * It is used all over the world!
     */
    public static void printlnTest() {
        System.out.println("I ");
        System.out.println("know ");
        System.out.println("Java ");
        System.out.println("well.");

        System.out.println("Java is a popular programming language.");
        System.out.println(); // prints empty line
        System.out.println("It is used all over the world!");
    }

    /**
     * print() method
     * ===============
     * Output: I know Java well.
     */
    public static void printTest() {
        System.out.print("I ");
        System.out.print("know ");
        System.out.print("Java ");
        System.out.print("well.");
    }

    /**
     * print() & println() with numbers and characters
     * ===============
     * Output: 108cQ3
     *         22E81
     */
    public static void printNumbersNCharactersTest() {
        System.out.print(108);   // printing a number
        System.out.print('c');   // printing a character that represents a letter
        System.out.print("Q");   // printing a string
        System.out.println('3'); // printing a character that represents a digit

        System.out.print(22);
        System.out.print('E');
        System.out.print(8);
        System.out.println('1');
    }

}

/**
 * Integer types and operations
 */
public class IntegerTypesAndOperations {
    public static void main(String[] args) {
        // int
        int two = 2;

        int minusTwo = -two; // -2
        int million = 1_000_000; // 1000,000

        System.out.println(million);

        // long
        long one = 1L;
        long twentyTwo = 22L; // L or l is a literal for longs
        long bigNumber = 100_000_000_000L;

        long result = bigNumber + twentyTwo - one;
        System.out.println(result); // 100000000021

    }
}

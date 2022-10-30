//TODO: Add comments and JavaDocs


/**
 * Static method for generating twin prime numbers within 95500 through 96000
 */
public class TwinPrimeGenerator
{
    /**
     * Method for generating twin prime numbers
     * @return - Returns the smallest of the twin primes
     */
    public static int generate()
    {
        int min = 95500, max = 96000;
        boolean foundTwinPrime = false;
        int n1 = 0, n2 = 0;

        while (!foundTwinPrime)
        {
            n1 = (int) ((Math.random() * (max - min)) + min);
            n2 = n1 - 2;

            if (isPrime(n1) && isPrime(n2))
                foundTwinPrime = true;
        }
        //System.out.printf("Twin Prime Numbers Generated: %d and %d\n", n1, n2);

        return Math.min(n1, n2);
    }

    /**
     * Helper method for checking if number is prime
     * @param num - Number for comparison
     * @return - Returns T/F result if number is prime or not
     */
    private static boolean isPrime(int num)
    {
        for (int i = 2; i < num; i++)
        {
            if (num % i == 0)
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Driver method for testing purposes and sanity check
     * @param args - no arguments needed to be passed
     */
    public static void main(String[] args)
    {
        System.out.println("Random numbers in range");
        int tableNum = generate();

        System.out.println("\nMinumum of twin primes");
        System.out.println(tableNum);
    }
}

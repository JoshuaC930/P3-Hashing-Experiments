public class HashTable<T>
{
    HashObject<?> hashTable[];
    private int tableSize, elementCount, frequencyTotal, probeCount;

    /**
     * Default constructor for initializing a blank HashTable
     */
    public HashTable()
    {
        this.tableSize = 95791;
        hashTable = new HashObject<?>[tableSize];
    }

    /**
     * Overloaded constructor for initializing a new HashTable with a
     * given table size
     * @param tableSize - Size of table
     * @param loadFactor - Load factor used for hashing
     */
    public HashTable(int tableSize, double loadFactor)
    {
        this.tableSize = tableSize;
        hashTable = new HashObject<?>[tableSize];
    }

    public void put(HashObject<T> object, int hashType)
    {
        int i = 0, value = -1;

        while (i < tableSize)
        {
            if (hashType == 1)
            {
                //TODO: Case for linear probing
            }
            else if (hashType == 2)
            {
                //TODO: Case for double probing
            }
        }
    }

    protected static int positiveMod(int dividend, int divisor)
    {
        int quotient = dividend % divisor;
        if (quotient < 0)
            quotient += divisor;
        return quotient;
    }
}

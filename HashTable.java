public class HashTable<T>
{
    HashObject<?>[] hashTable;
    private final int tableSize;
    private int numOfElements;
    private int frequencyCount;
    private int totalProbeCount;

    /**
     * Default constructor for initializing a blank HashTable
     */
    public HashTable()
    {
        this.tableSize = TwinPrimeGenerator.generate();
        hashTable = new HashObject<?>[tableSize];
    }

    /**
     * Overloaded constructor for initializing a new HashTable with a
     * given table size
     * @param tableSize - Size of table
     */
    public HashTable(int tableSize)
    {
        this.tableSize = tableSize;
        hashTable = new HashObject<?>[tableSize];
    }

    /**
     * put method for placing HashObjects into HashTable
     * @param object - Object to put into table
     * @param type - Hash type of Object
     */
    public void put(HashObject<T> object, int type)
    {
        int i = 0, value = -1;

        while (i < tableSize)
        {
            if (type == 1)
                value = LinearProbing.linearProbe(object, i, tableSize);
            else if (type == 2)
                value = DoubleHashing.doubleHash(object, i, tableSize);

            object.incrementProbeCount();

            if (hashTable[value] == null)
            {
                hashTable[value] = object;
                numOfElements++;
                totalProbeCount += i + 1;
                break;
            }

            else if (hashTable[value].equals(object))
            {
                frequencyCount++;
                hashTable[value].incrementFrequencyCount();
                break;
            }

            i++;
        }
    }

    /**
     * Method for getting frequency of hits (duplicates)
     * @return - returns frequencyCount
     */
    public int getFrequencyCount() { return frequencyCount; }

    /**
     * Method for getting total number of probes
     * @return - returns probe count
     */
    public int getTotalProbes() { return totalProbeCount; }

    /**
     * Method for getting average of probes for Hash Table
     * @return - Returns average of probes
     */
    public double getAverageProbes() { return  ((double) totalProbeCount / (double) numOfElements); }

    /**
     * Method for returning size of Hash Table
     * @return - Returns size for Hash table
     */
    public int getSize() { return tableSize; }

    /**
     * Method for returning number of elements in Hash table
     * @return - Returns number of elements in Hash Table
     */
    public int getNumOfElements() { return numOfElements; }

    /**
     * Method for getting load factor
     * @return - Returns load factor
     */
    public double getLoadFactor() { return  ((double) numOfElements / (double) tableSize); }

    /**
     * Helper method for ensuring calculations always return positive integers
     * @param dividend - dividend
     * @param divisor - divisor
     * @return - returns quotient, value will always be positive
     */
    protected static int positiveMod(int dividend, int divisor)
    {
        int quotient = dividend % divisor;
        if (quotient < 0)
            quotient += divisor;
        return quotient;
    }
}

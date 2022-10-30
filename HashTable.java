//TODO: Add comments and JavaDocs

public class HashTable<T>
{
    HashObject<?> hashTable[];
    private int tableSize, elementCount, frequencyCount, probeCount;

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
     * @param loadFactor - Load factor used for hashing
     */
    public HashTable(int tableSize, double loadFactor)
    {
        this.tableSize = tableSize;
        hashTable = new HashObject<?>[tableSize];
    }

    /**
     * put method for plaing HashObjects into HashTable
     * @param object - Object to put into table
     * @param hashType - Hashtype of Object
     */
    public void put(HashObject<T> object, int hashType)
    {
        int i = 0, value = -1;

        while (i < tableSize)
        {
            if (hashType == 1)
            {
                value = LinearProbing.linearProbe(object, i, tableSize);
            }
            else if (hashType == 2)
            {
                value = DoubleHashing.doubleHash(object, i, tableSize);
            }

            object.incrementProbeCount();

            if (hashTable[value] == null)
            {
                hashTable[value] = object;
                elementCount++;
                probeCount += i + 1;
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
    public int getTotalProbes() { return probeCount; }

    /**
     * Method for getting average of probes for Hash Table
     * @return - Returns average of probes
     */
    public double getAverageProbes() { return  ((double) probeCount / (double) elementCount); }

    /**
     * Method for returning size of Hash Table
     * @return - Returns size for Hash table
     */
    public int getSize() { return tableSize; }

    /**
     * Method for returning number of elements in Hash table
     * @return - Returns number of elements in Hash Table
     */
    public int getNumOfElements() { return elementCount; }

    /**
     * Method for getting load factor
     * @return - Returns load factor
     */
    public double getLoadFactor() { return  ((double) elementCount / (double) tableSize); }

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

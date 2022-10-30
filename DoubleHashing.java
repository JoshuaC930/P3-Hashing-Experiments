//TODO: Add comments and JavaDocs
public class DoubleHashing extends HashTable
{
    /**
     * Subclass for HashTable, made for DoubleHashing
     * @param object - Object in HashTable
     * @param value - Value of object
     * @param tableSize - Size of Table
     * @return - Returns HashTable
     */
    public static int doubleHash(HashObject<?> object, int value, int tableSize)
    {
        int firstHashValue = HashTable.positiveMod(object.getKey().hashCode(), tableSize);
        int secondHashValue = HashTable.positiveMod(1 + (object.getKey().hashCode()), tableSize - 2);

        return HashTable.positiveMod(firstHashValue + (value * secondHashValue), tableSize);
    }

}

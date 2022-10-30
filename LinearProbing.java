//TODO: Add comments and JavaDocs
public class LinearProbing extends HashTable
{
    /**
     * Subclass for HashTable, made for Linear Probing
     * @param object - Object
     * @param value - Value of Object
     * @param tableSize - size of Table
     * @return - returns Hashtable
     */
    public static int linearProbe(HashObject<?> object, int value, int tableSize)
    {
        int hashValue = HashTable.positiveMod(object.getKey().hashCode(), tableSize);

        return HashTable.positiveMod((hashValue + value), tableSize);
    }

}

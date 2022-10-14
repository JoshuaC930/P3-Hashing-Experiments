public class LinearProbing
{
    public static int linearProbe(HashObject<?> object, int value, int tableSize)
    {
        int hashValue = HashTable.positiveMod(object.getKey().hashCode(), tableSize);

        return HashTable.positiveMod((hashValue + value), tableSize);
    }

}

public class DoubleHashing
{
    public static int doubleHash(HashObject<?> object, int value, int tableSize)
    {
        int firstHashValue = HashTable.positiveMod(object.getKey().hashCode(), tableSize);
        int secondHashValue = HashTable.positiveMod(1 + (object.getKey().hashCode()), tableSize -2);

        int doubleIndex = HashTable.positiveMod(firstHashValue + (value * secondHashValue), tableSize);

        return doubleIndex;
    }

}

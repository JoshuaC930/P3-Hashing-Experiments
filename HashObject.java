public class HashObject<T>
{
    private int frequencyCount, probeCount;
    private T key;
    public HashObject(T object)
    {
        this.key = object;
        frequencyCount = 0;
        probeCount = 0;
    }

    public void incrementDuplicateCount() { frequencyCount++; }
    public void incrementProbeCount() { probeCount++; }
    public int getFrequencyCount() { return frequencyCount; }
    public int getProbeCount() { return probeCount; }
    public T getKey() { return key; }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object object)
    {
        if (this.getClass().equals(object.getClass()))
        {
            return this.getKey().equals(((HashObject<T>) object).getKey());
        }

        return false;
    }

    @Override
    public String toString()
    {
        return key.toString() +  " " + getFrequencyCount() + " " + getProbeCount();
    }
}

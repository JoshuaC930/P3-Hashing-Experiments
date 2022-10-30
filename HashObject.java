//TODO: Add comments and JavaDocs
public class HashObject<T>
{
    private int frequencyCount, probeCount;
    private final T key;

    /**
     * Default constroctor for HashObject
     * @param object - generic object to pass in
     */
    public HashObject(T object)
    {
        this.key = object;
        frequencyCount = 0;
        probeCount = 0;
    }

    /**
     * Method for incrementing FrequencyCount for HashObject
     */
    public void incrementFrequencyCount() { frequencyCount++; }

    /**
     * Method for incrementing ProbeCount for HashObject
     */
    public void incrementProbeCount() { probeCount++; }

    /**
     * Getter method for getting frequencyCount
     * @return - Returns frequencyCount
     */
    public int getFrequencyCount() { return frequencyCount; }

    /**
     * Getter method for getting probeCount
     * @return - Returns probCount
     */
    public int getProbeCount() { return probeCount; }

    /**
     * Getter method for key
     * @return - Returns key object
     */
    public T getKey() { return key; }

    /**
     * Method for checking of key is equal to object
     * @param object - Object for comparison
     * @return - returns true if equal, false if otherwise
     */
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

    /**
     * ToString method for printing information
     * @return - prints key information
     */
    @Override
    public String toString()
    {
        return key.toString() +  " " + getFrequencyCount() + " " + getProbeCount();
    }
}

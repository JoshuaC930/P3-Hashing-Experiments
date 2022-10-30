//TODO: Add comments and JavaDocs

import java.io.*;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

@SuppressWarnings({"rawtypes", "unchecked"})
public class HashtableTest
{
    //private variables for table and HashTable
    private static int size;
    private static HashTable<?> linearHashTable;
    private static HashTable<?> doubleHashTable;

    //toggle for debug
    private static boolean debug = false;

    /**
     * Driver class for runs the simulation for all 3 data sources
     * @param args - <datatype> - type od data source to use, <load factor> - load factor,  [<debug level>] - debug level for testing
     */
    public static void main(String[] args)
    {
        String dataType;
        //Usage check, stops execution if correct arguments are not used
        if (args.length < 2)
            System.out.println("Incorrect usage of class arguments. Usage: <datatype> <load factor> [<debug level>]");

        else
        {
            int inputType = Integer.parseInt(args[0]);
            double loadFactor = Double.parseDouble(args[1]);
            size = 95791;
            int maxElements = (int) (size * loadFactor);

            if (args.length == 3)
            {
                if (Integer.parseInt(args[2]) == 0)
                    debug = false;
                else if (Integer.parseInt(args[2]) == 1)
                    debug = true;
                else
                {
                    System.out.println("Not a valid debug parameter. Debug Parameters: 0 -> 2");
                }
            }

            //Data Source 1: Integer object
            if (inputType == 1)
            {
                dataType = "Integer";
                System.out.println("Data Source 1: Integer");
                linearHashTable = new HashTable<>(size);
                doubleHashTable = new HashTable<>(size);

                while (linearHashTable.getNumOfElements() <= maxElements && doubleHashTable.getNumOfElements() <= maxElements)
                {
                    Random rand = new Random();
                    int randomVal = rand.nextInt();

                    HashObject linearObject = new HashObject<>(randomVal);
                    HashObject doubleObject = new HashObject<>(randomVal);

                    linearHashTable.put(linearObject, 1);
                    doubleHashTable.put(doubleObject, 2);
                }

                printOut(dataType, loadFactor);
            }

            //Data Source 2: Date object
            else if (inputType == 2)
            {
                dataType = "Date";
                System.out.println("Data Source 2: Date Object");
                linearHashTable = new HashTable<>(size);
                doubleHashTable = new HashTable<>(size);
                long current = new Date().getTime();

                while (linearHashTable.getNumOfElements() <= maxElements && doubleHashTable.getNumOfElements() <= maxElements)
                {
                    current += 1000;
                    Date date = new Date(current);

                    HashObject linearObject = new HashObject<>(date);
                    HashObject doubleObject = new HashObject<>(date);

                    linearHashTable.put(linearObject, 1);
                    doubleHashTable.put(doubleObject, 2);
                }

                printOut(dataType, loadFactor);
            }

            //Data Source 3: Word List
            else if (inputType == 3)
            {
                dataType = "Word-List";
                System.out.println("Data Source 3: Word-List");

                File wordList = new File("word-list");
                Scanner fileScanner;

                try
                {
                    fileScanner = new Scanner(wordList);

                    linearHashTable = new HashTable<>(size);
                    doubleHashTable = new HashTable<>(size);

                    int i = 0;
                    while (fileScanner.hasNext() && linearHashTable.getLoadFactor() < loadFactor)
                    {
                        String line = fileScanner.nextLine();

                        HashObject linearObject = new HashObject<>(line);
                        HashObject doubleObject = new HashObject<>(line);

                        linearHashTable.put(linearObject, 1);
                        doubleHashTable.put(doubleObject, 2);

                        i++;
                    }

                    System.out.println("Found a twin Prime Table Capacity: " + size);
                    System.out.printf("Input: %s       Load Factor: %s\n", dataType, loadFactor);

                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~Using Linear Probing~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.printf("HashtableTest: size of hash table is %d", linearHashTable.getNumOfElements());
                    System.out.printf("\n      Inserted %d elements, of which %d, were duplicates", i, linearHashTable.getFrequencyCount());
                    System.out.println("\nAvg. no. of probes = " + linearHashTable.getAverageProbes());

                    System.out.println();

                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~Using Double Hashing~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.printf("HashtableTest: size of hash table is %d", doubleHashTable.getNumOfElements());
                    System.out.printf("\n      Inserted %d elements, of which %d, were duplicates", i, doubleHashTable.getFrequencyCount());
                    System.out.println("\nAvg. no. of probes = " + doubleHashTable.getAverageProbes());

                    if (debug) debug();
                }
                catch (FileNotFoundException e)
                {
                    System.out.println("Cannot find word list. Exception: " + e);
                }
            }

            else
            {
                System.out.println("Not a valid input type");
            }
        }
    }

    /**
     * Helper method for printing output
     * @param dataType - Datatype being used for hashing
     * @param loadFactor - Load factor used
     */
    private static void printOut(String dataType, double loadFactor)
    {
        System.out.println("Found a twin Prime Table Capacity: " + size);
        System.out.printf("Input: %s | Load Factor: %s\n", dataType, loadFactor);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~Using Linear Probing~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.printf("HashtableTest: size of hash table is %d", linearHashTable.getSize());
        System.out.printf("\n      Inserted %d elements, of which %d, were duplicates", linearHashTable.getNumOfElements(), linearHashTable.getFrequencyCount());
        System.out.println("\nAvg. no. of probes = " + linearHashTable.getAverageProbes());

        System.out.println();

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~Using Double Hashing~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.printf("HashtableTest: size of hash table is %d", doubleHashTable.getSize());
        System.out.printf("\n      Inserted %d elements, of which %d, were duplicates", doubleHashTable.getNumOfElements(), doubleHashTable.getFrequencyCount());
        System.out.println("\nAvg. no. of probes = " + doubleHashTable.getAverageProbes());

        if (debug) debug();
    }

    /**
     * Method for saving debug results to an output file
     */
    private static void debug()
    {
        try
        {
            FileWriter linearFileDump = new FileWriter("linear-dump.txt");
            FileWriter doubleFileDump = new FileWriter("double-dump.txt");

            PrintWriter linearPrintWriter = new PrintWriter(linearFileDump);
            PrintWriter doublePrintWriter = new PrintWriter(doubleFileDump);

            for (int i = 0; i < size; i++)
            {
                if (linearHashTable.hashTable[i] != null)
                    linearPrintWriter.print("table[" + i + "]: " + linearHashTable.hashTable[i].toString() + "\n");
                if (doubleHashTable.hashTable[i] != null)
                    doublePrintWriter.print("table[" + i + "]: " + doubleHashTable.hashTable[i].toString() + "\n");
            }

            linearPrintWriter.close();
            doublePrintWriter.close();
            System.out.println("Saved dump of hash table");
        }
        catch (IOException e)
        {
            System.out.println("An IOException Occurred");
        }
    }
}

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
        //Usage check, stops execution if correct arguments are not used
        if (args.length < 2)
            System.out.println("Incorrect usage of class arguments. Usage: <datatype> <load factor> [<debug level>]");

        else
        {
            int inputType = Integer.parseInt(args[0]);
            double loadFactor = Double.parseDouble(args[1]);
            size = TwinPrimeGenerator.generate();
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
                System.out.println("Data Source 1: Integer");
                linearHashTable = new HashTable<>(size, loadFactor);
                doubleHashTable = new HashTable<>(size, loadFactor);

                while (linearHashTable.getNumOfElements() <= maxElements && doubleHashTable.getNumOfElements() <= maxElements)
                {
                    Random rand = new Random();
                    int randomVal = rand.nextInt();

                    HashObject linearObject = new HashObject<Integer>(randomVal);
                    HashObject doubleObject = new HashObject<Integer>(randomVal);

                    linearHashTable.put(linearObject, 1);
                    doubleHashTable.put(doubleObject, 2);
                }

                System.out.println("LINEAR HASHING");
                System.out.printf("Input %d elements, of which %d duplicates", linearHashTable.getNumOfElements(), linearHashTable.getNumOfElements());
                System.out.printf("Load Factor = %f, Average Number of Probes %f", loadFactor, linearHashTable.getAverageProbes());

                System.out.println("DOUBLE HASHING");
                System.out.printf("Input %d elements, of which %d duplicates", doubleHashTable.getNumOfElements(), doubleHashTable.getNumOfElements());
                System.out.printf("Load Factor = %f, Average Number of Probes %f", loadFactor, doubleHashTable.getAverageProbes());

                if (debug) debug();
            }

            //Data Source 2: Date object
            if (inputType == 2)
            {
                System.out.println("Data Source 2: Date Object");
                linearHashTable = new HashTable<>(size, loadFactor);
                doubleHashTable = new HashTable<>(size, loadFactor);

                while (linearHashTable.getNumOfElements() <= maxElements && doubleHashTable.getNumOfElements() <= maxElements)
                {
                    long current = new Date().getTime();
                    current += 1000;
                    Date date = new Date(current);

                    HashObject linearObject = new HashObject<>(date);
                    HashObject doubleObject = new HashObject<>(date);

                    linearHashTable.put(linearObject, 1);
                    doubleHashTable.put(doubleObject, 2);
                }

                System.out.println("LINEAR HASHING");
                System.out.printf("Input %d elements, of which %d duplicates%n", linearHashTable.getNumOfElements(), linearHashTable.getFrequencyCount());
                System.out.printf("load factor = %f, Avg. no. of probes %f%n", loadFactor, linearHashTable.getAverageProbes());

                System.out.println("DOUBLE HASHING");
                System.out.printf("Input %d elements, of which %d duplicates%n", doubleHashTable.getNumOfElements(), doubleHashTable.getFrequencyCount());
                System.out.printf("load factor = %f, Avg. no. of probes %f%n", loadFactor, doubleHashTable.getAverageProbes());

                if(debug) debug();
            }

            //Data Source 3: Word List
            if (inputType == 3)
            {
                System.out.println("Data Source 3: Word-List");

                File wordList = new File("word-list");
                Scanner fileScanner;

                linearHashTable = new HashTable<>(size, loadFactor);
                doubleHashTable = new HashTable<>(size, loadFactor);

                try
                {
                    fileScanner = new Scanner(wordList);

                    int i = 0;

                    while (fileScanner.hasNext()&& linearHashTable.getLoadFactor() < loadFactor)
                    {
                        String line = fileScanner.nextLine();

                        HashObject linearObject = new HashObject<>(line);
                        HashObject doubleObject = new HashObject<>(line);

                        linearHashTable.put(linearObject, 1);
                        linearHashTable.put(doubleObject, 2);

                        i++;
                    }

                    System.out.println("LINEAR HASHING");
                    System.out.printf("Input %d elements, of which %d duplicates%n", i, linearHashTable.getFrequencyCount());
                    System.out.printf("load factor = %f, Avg. no. of probes %s%n", loadFactor, linearHashTable.getAverageProbes());

                    System.out.println("DOUBLE HASHING");
                    System.out.printf("Input %d elements, of which %d duplicates%n", i, doubleHashTable.getFrequencyCount());
                    System.out.printf("load factor = %f, Avg. no. of probes %s%n", loadFactor, doubleHashTable.getAverageProbes());

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
     * Method for saving dubug results to an output file
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
        }
        catch (IOException e)
        {
            System.out.println("A IOException Occurred");
        }
    }
}

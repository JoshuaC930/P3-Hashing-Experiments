# Project #: Project Name

* Author: Joshua Corrales
* Class: CS321 Section #2
* Semester: Fall 2022

## Overview

This Lab uses a Hash Table using an array. For the object within that array,
we are tasked to find the average number of probes integers, dates, and a word list.

## Reflection

Overall, this project was fairy straight-forward compared to the previous prohect which was nice.
I had a little of trouble understanding LinearProbing and DoubleHashing as those seemed 
a little above my head at first. Also working on the TwinPrimeGenerator was also a bit
confusing.

I will admit, because of previous commitments, did not start early on this project so I was very
behind when working on it. However, I would say that I did not pull my hair out on
too many things as compared to Lab 02.

## Compiling and Using

Program needs to be compiled using an IDE with the Java JDK 17 or higher.

The main driver class is the HashableTest.java class. However, you
will need to pass in certain arguments to run the tests.

The program takes the following arguments as input:
datatype, load factor, debug level

Valid syntax for the arguments are as follows:

| Argument    | Value     | Definition                                                                       |
|-------------|-----------|----------------------------------------------------------------------------------|
| Datatype    | 1, 2, 3   | 1 - Uses integer objects, 2 - Uses date objects, 3 - Uses a Word list as objects |
| Load Factor | 0.5 - 0.9 | Determines the load factor used for Hashing                                      |
| Debug Level | 1 - 3     | Determines the debug level to be used                                            |


## Results 

The following results are shown in the following tables below.

Data Source 1: Random Integers

| Load Factor | Linear             | Double             |
|-------------|--------------------|--------------------|
| 0.5         | 1.4968473358944379 | 1.3868799064640054 |
| 0.6         | 1.7537538060026099 | 1.524193127446716  |
| 0.7         | 2.140826796313419  | 1.710582831235459  |
| 0.8         | 3.0087299205303197 | 2.0126055354742736 |
| 0.9         | 5.547244003155013  | 2.567786387045887  |
| 0.95        | 10.418188611239314 | 3.1417676728827155 |
| 0.98        | 31.690762282159444 | 3.991733688415446  |
| 0.99        | 106.146940970538   | 4.627872154207924  |

Data Source 2: Date Objects

| Load Factor | Linear             | Double             |
|-------------|--------------------|--------------------|
| 0.5         | 1.0753507599799565 | 1.119070486053115  |
| 0.6         | 1.0862635928664637 | 1.1671509351892126 |
| 0.7         | 1.0940436066453902 | 1.2289199749455662 |
| 0.8         | 1.1530019704304935 | 1.503660303002623  |
| 0.9         | 1.4690994293137847 | 2.1378462395026214 |
| 0.95        | 1.863838157403134  | 3.0292630931188325 |
| 0.98        | 2.642571051173889  | 3.8601985598022925 |
| 0.99        | 3.539648227428981  | 4.494411287091127  |

Data Source 3: Word List

| Load Factor | Linear              | Double             |
|-------------|---------------------|--------------------|
| 0.5         | 1.5969183230332387  | 1.3904918991147486 |
| 0.6         | 2.1493866898651586  | 1.5340930839495432 |
| 0.7         | 3.603871506546962   | 1.7213141647030752 |
| 0.8         | 6.708428483812456   | 2.0160244281184347 |
| 0.9         | 19.814898158029045  | 2.5692247018976477 |
| 0.95        | 110.59400892288082  | 3.1861497549504407 |
| 0.98        | 324.20626145127613  | 4.019834675529422  |
| 0.99        | 471.67139422569966  | 4.695552228103844  |


## Sources used

https://docs.oracle.com/javase/8/docs/api/java/util/Hashtable.html

https://www.geeksforgeeks.org/hashtable-in-java/

https://www.baeldung.com/java-generating-random-numbers-in-range

https://www.geeksforgeeks.org/twin-prime-numbers/

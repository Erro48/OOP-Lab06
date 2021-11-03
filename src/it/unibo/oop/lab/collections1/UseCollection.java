package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {
	
	private static int RANGE_START = 1000;
	private static int RANGE_END = 2000;
	private static int ELEMENTS = 100_000;
	private static int READ_TIMES = 1000;
	

    private UseCollection() {
    }
    
    private static double nanoToSecond(long time) {
    	System.out.println(time);
    	return ((double)time/1_000_000_000);
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
    	
    	ArrayList<Integer> arrList = new ArrayList<>();
    	
    	for (int i = RANGE_START; i < RANGE_END; i++) {
    		arrList.add(i);
    	}
    	
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
    	
    	LinkedList<Integer> linkList = new LinkedList<>();
    	
    	linkList.addAll(arrList);
    	
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
    	
    	int firsElemIndex = 0;
    	int firstElem = arrList.get(firsElemIndex);
    	int lastElemIndex = arrList.size() - 1;
    	
    	arrList.set(firsElemIndex, arrList.get(lastElemIndex));
    	arrList.set(lastElemIndex, firstElem);
    	
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
    	
    	for (int elem : arrList) {
    		System.out.print(elem + " ");
    	}
    	System.out.println();
    	
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
    	
    	long time = System.nanoTime();
    	
    	for (int i = 0; i < ELEMENTS; i++) {
    		arrList.add(0, i);
    	}
    	
    	time = System.nanoTime() - time;
    	System.out.println("Head insert (arraylist): " + nanoToSecond(time));
    	
    	
    	time = System.nanoTime();
    	
    	for (int i = 0; i < ELEMENTS; i++) {
    		arrList.add(0, i);
    	}
    	
    	time = System.nanoTime() - time;
    	System.out.println("Head insert (linkedlist): " + nanoToSecond(time));
    	
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
    	
    	time = System.nanoTime();
    	int middleIndex = (int)(arrList.size() / 2);
    	
    	for (int i = 0; i < READ_TIMES; i++) {
    		arrList.get(middleIndex);
    	}
    	
    	time = System.nanoTime() - time;
    	System.out.println("Get middle element (arraylist): " + nanoToSecond(time));
    	
    	
    	time = System.nanoTime();
    	middleIndex = (int)(linkList.size() / 2);
    	
    	for (int i = 0; i < READ_TIMES; i++) {
    		arrList.get(middleIndex);
    	}
    	
    	time = System.nanoTime() - time;
    	System.out.println("Get middle element (linkedlist): " + nanoToSecond(time));
    	
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
    	
    	Map<String,Long> continentPopulation = new HashMap<>();

    	continentPopulation.put("Africa", 1_110_635_000L);
    	continentPopulation.put("Americas", 972_005_000L);
    	continentPopulation.put("Antartica", 0L);
    	continentPopulation.put("Asia", 4_298_723_000L);
    	continentPopulation.put("Europe", 742_452_000L);
    	continentPopulation.put("Oceania", 38_304_000L);
    	
        /*
         * 8) Compute the population of the world
         */
    	
    	long total = 0;
    	for (var e : continentPopulation.entrySet()) {
    		total += e.getValue();
    	}
    	
    }
}

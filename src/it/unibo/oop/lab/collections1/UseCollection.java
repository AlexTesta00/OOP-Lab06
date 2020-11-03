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

	 private static final int ELEMS = 100;
	 private static final int TO_MS = 100;
    private UseCollection() {
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
    	ArrayList<Integer> arl = new ArrayList<>();
    	for(int i = 1000 ; i < 2000 ; i++) {
    		arl.add(i);
    	}
    	
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
    	LinkedList<Integer> lk = new LinkedList<>(arl);
    	
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
    	
    	final int INDEX_FIRST_POSITION = 0;
    	final int INDEX_LAST_POSITION = lk.size() - 1;
    	final int LAST_NUMBER = lk.get(INDEX_LAST_POSITION);
    	
    	lk.set(INDEX_LAST_POSITION, lk.get(INDEX_FIRST_POSITION));
    	lk.set(INDEX_FIRST_POSITION,LAST_NUMBER);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
    	 for(Integer i : arl) {
    		 System.out.println(i);
    	 }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
    	 long timearl = System.nanoTime();
    	 
    	
    	 for(int i = 1 ; i < ELEMS ; i++) {
    		 arl.add(i, i);
    	 }
    	 timearl = System.nanoTime() - timearl;
         System.out.println("Insert " + ELEMS
                   + " element in ArrayList in " + timearl
                   + "ns (" + timearl / TO_MS + "ms)");
    	 System.out.println(arl);
    	 
    	 long timelk = System.nanoTime();
    	 for(int i = 1 ; i < ELEMS ; i++) {
    		 lk.add(i, i);
    	 }
    	 timelk = System.nanoTime() - timelk;
         System.out.println("Insert " + ELEMS
                   + " element in LinkedList in " + timelk
                   + "ns (" + timelk / TO_MS + "ms)");
    	 System.out.println(lk);
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
    	 long readarl = System.nanoTime();
    	 for(int i = 0 ; i < 100 ; i++ ) {
    		 arl.get(i);
    	 }
    	 readarl = System.nanoTime() - readarl;
         System.out.println("Read " + 100
                   + " element in ArrayList in " + readarl
                   + "ns (" + readarl / TO_MS + "ms)");
         
         long readlk = System.nanoTime();
    	 for(int i = 0 ; i < 100 ; i++ ) {
    		 lk.get(i);
    	 }
    	 readlk = System.nanoTime() - readlk;
         System.out.println("Read " + 100
                   + " element in LinkedList in " + readlk
                   + "ns (" + readlk / TO_MS + "ms)");
    	 
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
         Map<String,Long> mappa = new HashMap<>();
         mappa.put("Africa", (long) 1_110_635_000);
         mappa.put("Americas", (long) 972_005_000);
         mappa.put("Antarctica", (long) 0);
         mappa.put("Asia", 4_298_723_000L );
         mappa.put("Europe", 742_452_000L);
         mappa.put("Oceania", 38_304_000L);
         
        /*
         * 8) Compute the population of the world
         */
         Long npopulation = (long) 0;
         for(Long i : mappa.values()) {
        	 npopulation += i;
         }
         System.out.println(npopulation);
         
    }
}

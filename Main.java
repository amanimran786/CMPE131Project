public class Main {
    public static void main(String[] args)
    {
        // NOTE: if you get StackOverflowError then decrease NUM_ITEMS below.
        final int NUM_ITEMS = 6000;
        QuickSort ob = new QuickSort();
        int[] arr = QuickSort.getAscendingArray(NUM_ITEMS);
        long ascTime = ob.sort(arr, 0, NUM_ITEMS - 1);
        arr = QuickSort.getDescendingArray(NUM_ITEMS);
        long descTime = ob.sort(arr, 0, NUM_ITEMS - 1);
        arr = QuickSort.getRandomArray(NUM_ITEMS);
        long randomTime = ob.sort(arr, 0, NUM_ITEMS - 1);

//printArray(arr); // NOTE: can verify sorted correctly (for small arrays)
        arr = QuickSort.getSameArray(NUM_ITEMS);
        long sameTime = ob.sort(arr, 0, NUM_ITEMS - 1);
        System.out.println("QuickSort times using Lomuto (default) partitioning follow:");
        System.out.println("sorted asc array, time in ms: " + Long.toString(ascTime));
        System.out.println("sorted desc array, time in ms: " + Long.toString(descTime));
        System.out.println("sorted random array, time in ms: " + Long.toString(randomTime));
        System.out.println("sorted same values array, time: " + Long.toString(sameTime));

        arr = QuickSort.getAscendingArray(NUM_ITEMS);
        ascTime = ob.sortHoare(arr, 0, NUM_ITEMS - 1);
        arr = QuickSort.getDescendingArray(NUM_ITEMS);
        descTime = ob.sortHoare(arr, 0, NUM_ITEMS - 1);
        arr = QuickSort.getRandomArray(NUM_ITEMS);
        randomTime = ob.sortHoare(arr, 0, NUM_ITEMS - 1);

//printArray(arr); // NOTE: can verify sorted correctly (for small arrays)
        arr = QuickSort.getSameArray(NUM_ITEMS);
        sameTime = ob.sortHoare(arr, 0, NUM_ITEMS - 1);
        System.out.println("\nQuickSort times using Hoare partitioning follow:");
        System.out.println("sorted asc array, time in ms: " + Long.toString(ascTime));
        System.out.println("sorted desc array, time in ms: " + Long.toString(descTime));
        System.out.println("sorted random array, time in ms: " + Long.toString(randomTime));
        System.out.println("sorted same values array, time: " + Long.toString(sameTime));
    }
}



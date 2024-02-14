import java.util.Random;

public class QuickSort {
    /* This method takes last element as pivot, places the pivot element
    at its correct position in sorted array, and places all smaller
    (smaller than pivot) to left of pivot and all greater elements
    to the right of pivot.
    This is most-frequently seen implementation of QuickSort partition,
    and this is also known as the Lomuto partition */

    int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);                                      // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot) {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;

    }

    /*The main method that implements QuickSort()
        arr[] --> Array to be sorted,
        low --> Starting index,
        high --> Ending index.
        This sorts the array, and returns the time (in ms) it takes to run */
    long sort(int[] arr, int low, int high) {
        long startTime = System.currentTimeMillis();
        if (low < high) {
            /* partIdx is partitioning index, arr[partIdx] is now at right place */
            int partIdx = partition(arr, low, high);
            // Recursively sort elements before partition and after partition
            sort(arr, low, partIdx - 1);
            sort(arr, partIdx + 1, high);

        }
        return System.currentTimeMillis() - startTime;
    }
/* The main method that implements QuickSort() with Hoare partitioning
TODO: Implement this method and make a new method called partitionHoare that is conceptually similar to the partition method in this class.
 */

    int partitionHoare(int[] arr, int low, int high) {
        int pivot = arr[(low + high) / 2];
        int i = low;
        int j = high;

        while (true) {
            while (arr[i] < pivot) {
                i++;
            }while (arr[j] > pivot) {
                j--;
            }if (i >= j) {
                return j;
            }int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }
    long sortHoare(int[] arr, int low, int high) {
        long startTime = System.currentTimeMillis();
        if (low < high) {
            int partIdx = partitionHoare(arr, low, high);
            sort(arr, low, partIdx - 1);
            sort(arr, partIdx + 1, high);

        }
        return System.currentTimeMillis() - startTime;
    }

    static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

                                                        /* method to get an already sorted array of size arraySize */
    static int[] getAscendingArray(int arraySize) {
        int[] newArray = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            newArray[i] = i * 3;                        // arbitrarily increment by 3 each time
        }
        return newArray;
    }

                                                        /* method to get an array of size arraySize in descending order */
    static int[] getDescendingArray(int arraySize) {
        int[] newArray = new int[arraySize];
        int n = 0;
        for (int i = arraySize - 1; i >= 0; i--) {
            n += 4;                                     // arbitrarily increment from end by 4 each time
            newArray[i] = n;                           // gets the array in descending order
        }
        return newArray;
    }

    /* method to get an array of size arraySize in descending order */
    static int[] getRandomArray(int arraySize) {
        Random rand = new Random();
                                                        // Setting upper bound to generate random numbers in specific range
        int upperbound = 1000000;
        int[] newArray = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {

                                                        // Generating random values from 0 - 999999 using nextInt()
            newArray[i] = rand.nextInt(upperbound);
        }
        return newArray;
    }
                                                        /* method to get an array of size arraySize with all values the same */
    static int[] getSameArray(int arraySize) {
        int[] newArray = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            newArray[i] = 42;                           // arbitrary value, same for all elements
        }
        return newArray;
    }
}

/**
 *Even though Hoare and Lomuto are both QuickSort algorithms, Hoare is more efficient in the various scenarios
  we have, when it comes to performance. Both the method use partitioning when it comes to sorting the elements in the array.
 The main difference I observed during the lab was more swapping occurs in the Lomuto method than Hoare, which is why Hoare is suggested
 to be more efficient. In lomuto, after the iteration, the pivot element is swapped with the element at the calculated position.

 In the Hoare method, the array is partitioned by two pointers, one from the left(low), and one from the right(high).
 on the left hand side, all the elements in the array on the left side of the pivot, will be smaller in value than the pivot. Vis versa,
 the right side of the pivot will have all elements in the array larger than the pivot. When the pointers meet, the partitioning is over
 the pivot is in the correct sorted position. As less swapping occurs, it performs more efficiently. For example,
 if there is duplicate elements,more swaps would occur.
 */
import java.util.Arrays;

public class Sort {

    /*
     * sorts the array using insertion Sort.
     * traverses through the array and for each element that is smaller than the element before it,
     * it traverses to the left of the element until it finds the correct position to insert it
     */
    public static void insertionSort(int[] arr) {
        long start = System.nanoTime();
        // traverses through the array from index position 1 instead of 0
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) { // if the element is smaller than the element before it
                int toInsert = arr[i];
                int j = i;
                /*
                 * traverses left of the element at hand, shifts every element before one place to the right,
                 * and inserts the element at had into the correct sorted position
                 */
                while (j > 0 && toInsert < arr[j - 1]) {
                    arr[j] = arr[j - 1];
                    j = j - 1;
                }
                arr[j] = toInsert;
            }
        }
        long end = System.nanoTime();
        System.out.println(end - start);
    }

    // sorts the array using quickSort
    public static void quickSort(int[] arr) {
        long start = System.nanoTime();
        qSort(arr, 0, arr.length - 1);
        long end = System.nanoTime();
        System.out.println(end - start);
    }

    /*
     * sorts the array using quickSort.
     * logically, this code recursively splits the arrays in halves until the arrays turns into arrays of size one.
     * While spliting the arrays, the values are sorted.
     */
    private static void qSort(int arr[], int first, int last) {
        if (first < last) {

            // split is partitioning index
            int split = partition(arr, first, last);

            // Recursively sort elements before partition and after partition
            qSort(arr, first, split);
            qSort(arr, split + 1, last);
        }
    }

    // finds the partitioning index of the array
    private static int partition(int[] arr, int first, int last) {
        int pivot = arr[(first + last) / 2]; // takes the middle value of the array
        int i = (first - 1); // index of smaller element
        int j = last + 1;

        while (true) {
            // increment this value until we have a value on the left side greater than the pivot
            do {
                i++;
            } while (arr[i] < pivot);

            // once the above condition breaks, increment this value on the right side
            do {
                j--;
            } while (arr[j] > pivot);

            if (i < j)
                swap(arr, i, j);
            else
                return j;
        }
    }

    // helper method that swaps the position of two elements in the array
    private static void swap(int[] arr, int i, int j) {
        int save = arr[i];
        arr[i] = arr[j];
        arr[j] = save;
    }

    /*
     * sorts the array using merge sort.
     * recursively splits the array in half until left with only arrays of size one.
     * Afterwards, the size one arrays are merged together in sorted order
     */
    public static void mergeSort(int[] arr) {
        long start = System.nanoTime();
        if(arr.length > 0){
            int[] temp = new int[arr.length];
            mSort(arr, temp, 0, arr.length - 1);
        }
        long end = System.nanoTime();
        System.out.println(end - start);
    }

    /*
     * recursively splits the array in half until there are only arrays with a size of one.
     * Then merges the arrays together in sorted order
     */
    private static void mSort(int[] arr, int[] temp, int start, int end) {
        if (start == end) // base case
            return;

        int middle = (start + end) / 2; // The splitting step
        mSort(arr, temp, start, middle);
        mSort(arr, temp, middle + 1, end);
        merge(arr, temp, start, middle, middle + 1, end);
    }

    // merges two arrays together in sorted order
    private static void merge(int[] arr, int[] temp, int leftStart, int leftEnd, int rightStart, int rightEnd) {
        int i = leftStart; // index into left subarray
        int j = rightStart; // index into right subarray
        int k = leftStart; // index into temp
        // traverses through both arrays and compares the values until reaching the end of one array
        while (i <= leftEnd && j <= rightEnd) {
            if (arr[i] < arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }

        // if there are elements left to traverse in the left array (no need to compare values)
        while (i <= leftEnd)
            temp[k++] = arr[i++];

        // if there are elements left to traverse in the right array (no need to compare values)
        while (j <= rightEnd)
            temp[k++] = arr[j++];

        for (i = leftStart; i <= rightEnd; i++) // copy back
            arr[i] = temp[i];
    }

    /*
    sorts the array using bubble sort.
    loops through and "bubbles" all the bigger elements to the end of the array
    */ 
    public static void bubbleSort(int[] arr) {
        long start = System.nanoTime();
        
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1])
                    swap(arr, j, j+1);
            }
        }
        long end = System.nanoTime();
        System.out.println(end - start);
    }

    // creates an array of size n with the values in between or equal to a and b
    public static int[] randomArray(int n, int a, int b) {
        int min;
        int max;
        int[] arrayToReturn = new int[n];

        if (a < b) {
            min = a;
            max = b;
        } 
        else { // b is greater than or equal to a
            min = b;
            max = a;
        }

        // makes random integers from min -> max including the min & max and inserts it into an array
        for (int i = 0; i < n; i++) {
            arrayToReturn[i] = min + (int) (Math.random() * ((max - min) + 1));
        }

        return arrayToReturn;
    }

        // helper method to print the contents of the array as a string
        private static String printArray(int[] array){
                if(array.length == 0){
                        return "";
                }
                StringBuilder b = new StringBuilder();
                for(int i = 0; i < array.length; i++){
                        b.append(array[i] + ", ");
                }
                b.setLength(b.length() - 2);                    // deletes the extra comma and space at the end 
                return b.toString();
        }

    public static void main(String[] args) {
        // code used to get running time for each sorting algorithm
        /*int size = 1000; 
        System.out.println("Size of 10: ");
        System.out.println("insertionSort: ");
        int[] a1 = Sort.randomArray(size, 0, 5000);
        int[] a2 = Sort.randomArray(size, 0, 5000);
        int[] a3 = Sort.randomArray(size, 0, 5000);
        int[] a4 = Sort.randomArray(size, 0, 5000);
        int[] a5 = Sort.randomArray(size, 0, 5000);
        Sort.insertionSort(a1);
        Sort.insertionSort(a2);
        Sort.insertionSort(a3);
        Sort.insertionSort(a4);
        Sort.insertionSort(a5);
        System.out.println("\n");

        int[] b1 = Sort.randomArray(size, 0, 5000);
        int[] b2 = Sort.randomArray(size, 0, 5000);
        int[] b3 = Sort.randomArray(size, 0, 5000);
        int[] b4 = Sort.randomArray(size, 0, 5000);
        int[] b5 = Sort.randomArray(size, 0, 5000);
        System.out.println("quickSort: ");
        Sort.quickSort(b1);
        Sort.quickSort(b2);
        Sort.quickSort(b3);
        Sort.quickSort(b4);
        Sort.quickSort(b5);
        System.out.println("\n");

        int[] c1 = Sort.randomArray(size, 0, 5000);
        int[] c2 = Sort.randomArray(size, 0, 5000);
        int[] c3 = Sort.randomArray(size, 0, 5000);
        int[] c4 = Sort.randomArray(size, 0, 5000);
        int[] c5 = Sort.randomArray(size, 0, 5000);
        System.out.println("mergeSort: ");
        Sort.mergeSort(c1);
        Sort.mergeSort(c2);
        Sort.mergeSort(c3);
        Sort.mergeSort(c4);
        Sort.mergeSort(c5);
        System.out.println("\n");

        int[] d1 = Sort.randomArray(size, 0, 5000);
        int[] d2 = Sort.randomArray(size, 0, 5000);
        int[] d3 = Sort.randomArray(size, 0, 5000);
        int[] d4 = Sort.randomArray(size, 0, 5000);
        int[] d5 = Sort.randomArray(size, 0, 5000);
        System.out.println("Java's Sort: ");
        long start1 = System.nanoTime();
        Arrays.sort(d1);
        long end1 = System.nanoTime();
        System.out.println(end1 - start1);

        long start2 = System.nanoTime();
        Arrays.sort(d2);
        long end2 = System.nanoTime();
        System.out.println(end2 - start2);

        long start3 = System.nanoTime();
        Arrays.sort(d3);
        long end3 = System.nanoTime();
        System.out.println(end3 - start3);

        long start4 = System.nanoTime();
        Arrays.sort(d4);
        long end4 = System.nanoTime();
        System.out.println(end4 - start4);

        long start5 = System.nanoTime();
        Arrays.sort(d5);
        long end5 = System.nanoTime();
        System.out.println(end5 - start5);
        System.out.println("\n");

        int[] e1 = Sort.randomArray(size, 0, 5000);
        int[] e2 = Sort.randomArray(size, 0, 5000);
        int[] e3 = Sort.randomArray(size, 0, 5000);
        int[] e4 = Sort.randomArray(size, 0, 5000);
        int[] e5 = Sort.randomArray(size, 0, 5000);
        System.out.println("BubbleSort: ");
        Sort.bubbleSort(e1);
        Sort.bubbleSort(e2);
        Sort.bubbleSort(e3);
        Sort.bubbleSort(e4);
        Sort.bubbleSort(e5);
        System.out.println("\n");

        System.out.println("On sorted array with size 1000: ");
        int[] sortedArray = new int[1000];
        for(int i = 0; i < sortedArray.length; i++){
            sortedArray[i] = i;
        }
        System.out.println("insertion sort: ");
        Sort.insertionSort(sortedArray);

        System.out.println("quick sort: ");
        Sort.quickSort(sortedArray);

        System.out.println("merge sort: ");
        Sort.quickSort(sortedArray);

        System.out.println("Java's sort: ");
        long start = System.nanoTime();
        Arrays.sort(sortedArray);
        long end = System.nanoTime();
        System.out.println(end-start);
        
        System.out.println("Bubble sort: ");
        Sort.bubbleSort(sortedArray);

     */   

    // demonstration
    System.out.println("*** Demonstration for Sort ***");
    System.out.println("Insertion sort Code: ");
    System.out.println("int[] array = {10, 2, 5, 8, 9, 1, 1, 6, 3, 4};");
    System.out.println("Sort.insertionSort(array)");
    System.out.println("Sort.printArray(array)");
    System.out.println("\n");

    System.out.println("Insertion sort results: ");
    int[] a = {10, 2, 5, 8, 9, 1, 1, 6, 3, 4};
    System.out.println("Insertion sort running time: ");
    Sort.insertionSort(a);
    System.out.println(Sort.printArray(a));
    System.out.println("\n");

    System.out.println("Quick sort Code: ");
    System.out.println("int[] a1 = {10, 2, 5, 8, 9, 1, 1, 6, 3, 4};");
    System.out.println("Sort.quickSort(a1)");
    System.out.println("Sort.printArray(a1)");
    System.out.println("\n");

    System.out.println("Quick sort results: ");
    int[] a1 = {10, 2, 5, 8, 9, 1, 1, 6, 3, 4};
    System.out.println("Quick sort running time: ");
    Sort.quickSort(a1);
    System.out.println(Sort.printArray(a1));
    System.out.println("\n");

    System.out.println("Merge sort Code: ");
    System.out.println("int[] a2 = {10, 2, 5, 8, 9, 1, 1, 6, 3, 4};");
    System.out.println("Sort.mergeSort(a2)");
    System.out.println("Sort.printArray(a2)");
    System.out.println("\n");

    System.out.println("Merge sort results: ");
    int[] a2 = {10, 2, 5, 8, 9, 1, 1, 6, 3, 4};
    System.out.println("Merge sort running time: ");
    Sort.quickSort(a2);
    System.out.println(Sort.printArray(a2));
    System.out.println("\n");

    System.out.println("Bubble sort Code: ");
    System.out.println("int[] a3 = {10, 2, 5, 8, 9, 1, 1, 6, 3, 4};");
    System.out.println("Sort.bubbleSort(a3)");
    System.out.println("Sort.printArray(a3)");
    System.out.println("\n");

    System.out.println("Bubble sort results: ");
    int[] a3 = {10, 2, 5, 8, 9, 1, 1, 6, 3, 4};
    System.out.println("Bubble sort running time: ");
    Sort.quickSort(a3);
    System.out.println(Sort.printArray(a3));
    }
}

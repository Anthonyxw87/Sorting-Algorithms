import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.lang.StringBuilder;

public class SortTester {
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

        @Test
        public void testInsertionSort(){
                // Test 1: if the array is empty
                int[] array = new int[0];
                Sort.insertionSort(array);
                assertEquals("", SortTester.printArray(array));

                //Test 2: if the array has a size of 1 and is not empty
                array = new int[1];
                array[0] = 10;
                Sort.insertionSort(array);
                assertEquals("10", SortTester.printArray(array));

                // Test 3: if the array size is even, and the elements are not sorted
                array = new int[2];
                array[0] = 2;
                array[1] = 1;
                // array = {2, 1}
                Sort.insertionSort(array);
                assertEquals("1, 2", SortTester.printArray(array));

                array = new int[6];
                array[0] = 2;
                array[1] = 1;
                array[2] = 6;
                array[3] = 3;
                array[4] = 8;
                array[5] = 0;
                // array = {2, 1, 6, 3, 8, 0}
                Sort.insertionSort(array);
                assertEquals("0, 1, 2, 3, 6, 8", SortTester.printArray(array));

                // Test 4: if the array size is odd, and the elements are not sorted
                array = new int[5];
                array[0] = 2;
                array[1] = 1;
                array[2] = 6;
                array[3] = 3;
                array[4] = 8;
                // array = {2, 1, 6, 3, 8}
                Sort.insertionSort(array);
                assertEquals("1, 2, 3, 6, 8", SortTester.printArray(array));

                //Test 5: when the array is in reverse sorted order
                array = new int[5];
                array[0] = 4;
                array[1] = 3;
                array[2] = 2;
                array[3] = 1;
                array[4] = 0;
                // array = {4, 3, 2, 1, 0}
                Sort.insertionSort(array);
                assertEquals("0, 1, 2, 3, 4", SortTester.printArray(array));

        }

        @Test
        public void testQuickSort(){
                // Test 1: if the array is Empty
                int[] array = new int[0];
                Sort.quickSort(array);
                assertEquals("", SortTester.printArray(array));

                //Test 2: if the array has a size of 1 and is not empty
                array = new int[1];
                array[0] = 10;
                Sort.quickSort(array);
                assertEquals("10", SortTester.printArray(array));

                // Test 3: if the array size is even, and the elements are not sorted
                array = new int[2];
                array[0] = 2;
                array[1] = 1;
                // array = {2, 1}
                Sort.quickSort(array);
                assertEquals("1, 2", SortTester.printArray(array));

                array = new int[6];
                array[0] = 2;
                array[1] = 1;
                array[2] = 6;
                array[3] = 3;
                array[4] = 8;
                array[5] = 0;
                // array = {2, 1, 6, 3, 8, 0}
                Sort.quickSort(array);
                assertEquals("0, 1, 2, 3, 6, 8", SortTester.printArray(array));
                

                // Test 4: if the array size is odd, and the elements are not sorted
                array = new int[5];
                array[0] = 2;
                array[1] = 1;
                array[2] = 6;
                array[3] = 3;
                array[4] = 8;
                // array = {2, 1, 6, 3, 8}
                Sort.quickSort(array);
                assertEquals("1, 2, 3, 6, 8", SortTester.printArray(array));
        }

        @Test
        public void testMergeSort(){
                // Test 1: if the array is Empty
                int[] array = new int[0];
                Sort.mergeSort(array);
                assertEquals("", SortTester.printArray(array));

                //Test 2: if the array has a size of 1 and is not empty
                array = new int[1];
                array[0] = 10;
                Sort.mergeSort(array);
                assertEquals("10", SortTester.printArray(array));

                // Test 3: if the array size is even, and the elements are not sorted
                array = new int[2];
                array[0] = 2;
                array[1] = 1;
                // array = {2, 1}
                Sort.mergeSort(array);
                assertEquals("1, 2", SortTester.printArray(array));

                array = new int[6];
                array[0] = 2;
                array[1] = 1;
                array[2] = 6;
                array[3] = 3;
                array[4] = 8;
                array[5] = 0;
                // array = {2, 1, 6, 3, 8, 0}
                Sort.mergeSort(array);
                assertEquals("0, 1, 2, 3, 6, 8", SortTester.printArray(array));
                

                // Test 4: if the array size is odd, and the elements are not sorted
                array = new int[5];
                array[0] = 2;
                array[1] = 1;
                array[2] = 6;
                array[3] = 3;
                array[4] = 8;
                // array = {2, 1, 6, 3, 8}
                Sort.mergeSort(array);
                assertEquals("1, 2, 3, 6, 8", SortTester.printArray(array));

        }

        @Test
        public void testBubbleSort(){
                // Test 1: if the array is Empty
                int[] array = new int[0];
                Sort.bubbleSort(array);
                assertEquals("", SortTester.printArray(array));

                //Test 2: if the array has a size of 1 and is not empty
                array = new int[1];
                array[0] = 10;
                Sort.bubbleSort(array);
                assertEquals("10", SortTester.printArray(array));

                // Test 3: if the array size is even, and the elements are not sorted
                array = new int[2];
                array[0] = 2;
                array[1] = 1;
                // array = {2, 1}
                Sort.bubbleSort(array);
                assertEquals("1, 2", SortTester.printArray(array));

                array = new int[6];
                array[0] = 2;
                array[1] = 1;
                array[2] = 6;
                array[3] = 3;
                array[4] = 8;
                array[5] = 0;
                // array = {2, 1, 6, 3, 8, 0}
                Sort.bubbleSort(array);
                assertEquals("0, 1, 2, 3, 6, 8", SortTester.printArray(array));
                

                // Test 4: if the array size is odd, and the elements are not sorted
                array = new int[5];
                array[0] = 2;
                array[1] = 1;
                array[2] = 6;
                array[3] = 3;
                array[4] = 8;
                // array = {2, 1, 6, 3, 8}
                Sort.bubbleSort(array);
                assertEquals("1, 2, 3, 6, 8", SortTester.printArray(array));
        }

        @Test
        public void testRandomArray(){
                // can't do assertEquals since the values will be different each time
                System.out.println(printArray(Sort.randomArray(10,0,8)));
        }
        
}

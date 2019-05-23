package package_Heapsort;
import java.util.Arrays;

public class HeapSort {

    public void sort(int arrA[]) {
        int size = arrA.length;

        // Build heap
        for (int i = size / 2 - 1; i >= 0; i--)
            heapMax(arrA, size, i);

        // One by one extract (Max) an element from heap and
        // replace it with the last element in the array
        for (int i=size-1; i>=0; i--) {

            //arrA[0] is a root of the heap and is the max element in heap
            int x = arrA[0];
            arrA[0] = arrA[i];
            arrA[i] = x;

            // call  heapMax on the reduced heap
            heapMax(arrA, i, 0);
        }
    }

    // To heap_Max with node i
    void heapMax(int arrA[], int heapSize, int i) {
        int largest = i;                // Initialize largest as root
        int leftChildIdx  = 2*i + 1;    // left = 2*i + 1
        int rightChildIdx  = 2*i + 2;   // right = 2*i + 2

        // If left child is larger than root
        if (leftChildIdx  < heapSize && arrA[leftChildIdx ] > arrA[largest])
            largest = leftChildIdx ;

        // If right child is larger than largest so far
        if (rightChildIdx  < heapSize && arrA[rightChildIdx ] > arrA[largest])
            largest = rightChildIdx ;

        // If largest is not root
        if (largest != i) {
            int swap = arrA[i];
            arrA[i] = arrA[largest];
            arrA[largest] = swap;

            // swap Nodes
            heapMax(arrA, heapSize, largest);
        }
    }



    public static void main(String args[]) {
        int arrA[] = {9, 10, 5, 3, 1, 2, 6};
        int arrB[] = {90, 100, 55, 33, 10, 30, 20};

        System.out.println("Die Elemente vor der Sortierung : " + Arrays.toString(arrA));
        HeapSort heapSort = new HeapSort();
        heapSort.sort(arrA);

        System.out.println("Elemente nach der Sortierung : " + Arrays.toString(arrA));
        
        System.out.println("Die Elemente vor der Sortierung  : " + Arrays.toString(arrB));
        HeapSort heapSort2 = new HeapSort();
        heapSort2.sort(arrB);

        System.out.println("Elemente nach der Sortierung : " + Arrays.toString(arrB));
    }
}

package Heap;

import java.net.Socket;

public class MinHeap {
    
    int[] arr;
    int size;
    int capacity;

    public MinHeap(int c) {
        arr = new int[c];
        size = 0;
        capacity = c;
    }

    int left(int i) {
        return 2 * i + 1;
    }

    int right(int i) {
        return 2 * i + 2;
    }

    int parent(int i) {
        return (i-1) / 2;
    }

    void insert(int number) {

        if(size == capacity) {
            return;
        }

        size++;
        arr[size - 1] = number;
        
        int insertedPos = arr[size - 1];

        while(arr[insertedPos] < arr[parent(insertedPos)] && insertedPos != 0) {
            swap(arr, insertedPos, parent(insertedPos));
            insertedPos = parent(insertedPos);
        }

    }

    void minHeapify(int i) {

        int leftChild = left(i);
        int rightChild = right(i);

        if(leftChild < size && rightChild < size) {
            int smallest = min(i, leftChild, rightChild);

            if(arr[i] != arr[smallest]) {
                swap(arr, arr[i], arr[smallest]);
                minHeapify(smallest);
            }
        }

    }

    public int extractMin() 
    { 
    if (size <= 0) 
        return Integer.MAX_VALUE; 
    if (size == 1) 
    { 
        size--; 
        return arr[0]; 
    }  
    int temp = arr[0]; 
    arr[0] = arr[size-1]; 
    arr[size-1] = temp;
    size--; 
    minHeapify(0); 
  
    return arr[size]; 
    } 

    int min(int a, int b, int c) {
        if(arr[a] < arr[b] && arr[a] < arr[c]) {
            return a;
        }

        if(arr[b] < arr[a] && arr[b] < arr[c]) {
            return b;
        }

        return c;
    }


    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    void decreaseKey(int i, int x) {
        arr[i] = x;
        
        int insertedPos = i;

        while(arr[insertedPos] < arr[parent(insertedPos)] && insertedPos != 0) {
            swap(arr, insertedPos, parent(insertedPos));
            insertedPos = parent(insertedPos);
        }
    }

    void deleteKey(int i) {
        decreaseKey(i, -Integer.MIN_VALUE);
        extractMin();
        minHeapify(0);
    }

    void buildHeap() {
        for(int i = (size - 2)/ 2; i>=0; i--) {
            minHeapify(i);
        }

    }

    //HEAP SORT Time complexity: nlogn
    //Step 1: We build a max heap

    void maxHeapify(int[] arr, int n, int i) {

        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if(left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if(right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if(largest != i) {
            swap(arr[largest], arr[i]);
            maxHeapify(arr, n, largest);
        }

    }

    void buildHeap(int[] arr, int n) {
        for(int i = (n - 2) / 2; i >= 0; i--) {
            maxHeapify(arr, n, i);
        }
    }
    // Step 2: Repeatedly swap root with last node, reduce heap size by one, and heapify
    void heapSort(int[] arr, int n) {
        buildHeap();
        for(int i = n - 1; i >= 1; i--) {
            swap(arr[0], arr[i]);
            maxHeapify(arr, n, 0);
        }
    }

    void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }


}

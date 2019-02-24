import java.util.*;
import java.lang.*;
import java.io.*;

class HeapSort {
    public void printArray(int []arr){
       for (int i = 0; i < arr.length; i++) {
           System.out.print(arr[i] + "->");
       }
       System.out.println("null");
    }

    public void heapify(int arr[], int n, int idx) {
        if (idx == 0) return;

        int largest = idx;
        int left = getLeftChild(idx);
        int right = getRightChild(idx);

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != idx) {
            int tmp = arr[idx];
            arr[idx] = arr[largest];
            arr[largest] = tmp;

            heapify(arr, n, largest);
        }

    }

    public void heapSort(int arr[]) {
        int n = arr.length;

        for (int i = n/2; i >= 1; i--) {
            heapify(arr, n, i);
        }

        for (int i = n-1; i > 1; i--) {
            int tmp = arr[1];
            arr[1] = arr[i];
            arr[i] = tmp;
            arr[0]--;
            heapify(arr, i, 1);
        }
    }

    public int getParent(int node) {
        return node/2;
    }

    public int getLeftChild(int node) {
        return 2*node;
    }

    public int getRightChild(int node) {
        return 2*node+1;
    }

    public static void main(String[] args) {
        int []arr = {20, 15, 96, 60, 70, 50, 10, 5, 21, 32, 67, 1, 9, 8, 55, 41, 23, 29, 88, 45, 39};
        HeapSort ob = new HeapSort(); 

        System.out.println("Before sorting array is"); 
        ob.printArray(arr); 

        ob.heapSort(arr); 
  
        System.out.println("Sorted array is"); 
        ob.printArray(arr); 

    }
}

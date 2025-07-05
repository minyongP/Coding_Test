package base;

public class HeapSort {
    public static void main(String[] args) {
        int[] output = heapSort(new int[]{5, 4, 3, 2, 1});
        for (int a : output)System.out.println(a); // --> [1, 2, 3, 4, 5]

        output = heapSort(new int[]{3, 1, 21});
        for (int a : output)System.out.println(a); // --> [1, 3, 21]

        output = heapSort(new int[]{4, 10, 3, 5, 1});
        for (int a : output)System.out.println(a); // --> [1, 3, 4, 5, 10]
    }

    private static int[] heapSort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) heapify(arr, n, i);
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
        return arr;
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if (leftChild < n && arr[leftChild] > arr[largest])
            largest = leftChild;
        if (rightChild < n && arr[rightChild] > arr[largest])
            largest = rightChild;
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }
}

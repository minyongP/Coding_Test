package base;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] output = quickSort(new int[]{3, 1, 21});
        Arrays.stream(output).forEach(System.out::println); // --> [1, 3, 21]
    }

    private static int[] quickSort(int[] arr) {
        sort(arr, 0, arr.length-1);
        return arr;
    }

    private static int[] sort(int[] arr, int start, int end) {
        int pivot = partition(arr, start, end);
        if (start < pivot - 1) arr = sort(arr, start, pivot - 1);
        if (end > pivot) arr = sort(arr, pivot, end);
        return arr;
    }

    private static int partition(int[] arr, int start, int end) {
        if (start+1 == end){
            if (arr[start] > arr[end]) swap(arr, start, end);
            return end;
        }
        int mid = (start + end) / 2;
        swap(arr, start, mid);  // 중앙값을 첫번째로
        int pivot = arr[start];
        int i = start+1, j = end;
        while (i <= j) {
            while (pivot < arr[j] && j > 0) j--;
            while (pivot > arr[i] && i < arr.length-1) i++;
            if (i <= j) swap(arr, i++, j--);
        }
        arr[start] = arr[j];
        arr[j] = pivot;
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
package sort.quick;

import java.util.Scanner;

public class P11004 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        quickSort(A, 0, N-1, K-1);
        System.out.println(A[K-1]);
    }

    private static void quickSort(int[] arr, int start, int end, int K) {
        if (start < end) {
            int pivot = partition(arr, start, end);
            if (pivot == K) return;
            else if (K < pivot) quickSort(arr, start, pivot-1, K);
            else quickSort(arr, pivot+1, end, K);
        }
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

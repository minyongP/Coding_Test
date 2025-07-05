package base;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {3, 1, 21};
        int[] sortedArr = mergeSort(arr);
        for (int a : sortedArr) {
            System.out.println(a);
        }
    }

    private static int[] mergeSort(int[] arr) {
        int[] tmp = new int[arr.length];
        sort(0, arr.length - 1, arr, tmp);
        return arr;
    }

    private static void sort(int start, int end, int[] arr, int[] tmp) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            sort(start, mid, arr, tmp);
            sort(mid + 1, end, arr, tmp);
            merge(start, mid, end, arr, tmp);
        }
    }

    private static void merge(int start, int mid, int end, int[] arr, int[] tmp) {
        int leftIdx = start;
        int rightIdx = mid + 1;
        int tmpIdx = start;

        while (leftIdx <= mid && rightIdx <= end) {
            if (arr[leftIdx] <= arr[rightIdx]) {
                tmp[tmpIdx] = arr[leftIdx];
                leftIdx++;
            } else {
                tmp[tmpIdx] = arr[rightIdx];
                rightIdx++;
            }
            tmpIdx++;
        }

        while (leftIdx <= mid) {
            tmp[tmpIdx] = arr[leftIdx];
            leftIdx++;
            tmpIdx++;
        }

        while (rightIdx <= end) {
            tmp[tmpIdx] = arr[rightIdx];
            rightIdx++;
            tmpIdx++;
        }

        for (int i = start; i <= end; i++) {
            arr[i] = tmp[i];
        }
    }
}

package base;

public class InsertionSort {
    public static void main(String[] args) {
        int[] output = insertionSort(new int[]{3, 1, 21});
        for (int a : output) System.out.println(a); // --> [1, 3, 21]
    }

    private static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int target = arr[i];
            int j = i-1;
            while (j >= 0 && target < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j+1] = target;
        }
        return arr;
    }
}

package base;

public class RadixSort {
    public static void main(String[] args) {
        int[] output = radixSort(new int[]{3, 1, 21});
        for(int a : output) System.out.println(a); // --> [1, 3, 21]
    }

    private static int[] radixSort(int[] arr) {
        int[] output = new int[arr.length];   // 임시 저장 배열
        int size = 6; // 최대 자릿수
        int digit = 1;
        for (int k = 0; k < size; k++) {
            int[] box = new int[10]; // 0~9까지 자리수 배열
            for (int i = 0; i < arr.length; i++) box[arr[i]/digit%10]++;
            for (int i = 1; i < 10; i++) box[i] += box[i-1];
            for (int i = arr.length-1; i >= 0; i--) {
                output[box[arr[i]/digit%10]-1] = arr[i];
                box[arr[i]/digit%10]--;
            }
            for (int i = 0; i < arr.length; i++) arr[i] = output[i];
            digit *= 10;
        }
        return arr;
    }
}

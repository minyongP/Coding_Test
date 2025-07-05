package base;

import java.util.Arrays;

public class ReverseArr {
    public static void main(String[] args) {
        int[] output = reverseArr(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(output)); // --> [3, 2, 1]
    }
//    private static int[] reverseArr(int[] arr){
//        return reverse(arr, 0, arr.length - 1);
//    }
//
//    private static int[] reverse(int[] arr, int start, int end) {
//        if (start >= end) {
//            return arr;
//        }
//
//        int temp = arr[start];
//        arr[start] = arr[end];
//        arr[end] = temp;
//
//        reverse(arr, start + 1, end - 1);
//        return arr;
//    }
    private static int[] reverseArr(int[] arr){
        if(arr.length == 0) return new int[]{};
        int[] head = Arrays.copyOfRange(arr, arr.length-1, arr.length);
        int[] tail = reverseArr(Arrays.copyOfRange(arr, 0, arr.length-1));

        int[] dest = new int[head.length + tail.length];
        System.arraycopy(head, 0, dest, 0, head.length);
        System.arraycopy(tail, 0, dest, head.length, tail.length);
        return dest;
    }
}
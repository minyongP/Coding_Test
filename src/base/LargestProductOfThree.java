package base;

import java.util.Arrays;

public class LargestProductOfThree {
    public static void main(String[] args) {
        int output = largestProductOfThree(new int[]{2, 1, 3, 7});
        System.out.println(output); // --> 42 (= 2 * 3 * 7)

        output = largestProductOfThree(new int[]{-1, 2, -5, 7});
        System.out.println(output); // --> 35 (= -1 * -5 * 7)
    }

    private static int largestProductOfThree(int[] arr) {
        /*
        * 배열 정렬
        * (모든 값이 양수, 음수일때 가장큰 배열 3개가 크다.)
        * (음수가 1개일땐 가장큰 3개가 크다)
        * (음수가 2개일땐 가장큰 배열3개 or 음수 2개와 가장 큰값의 곱)
        * (음수가 3개일땐 //)
        * (..)
        * 최대값이 되는 건
        * 가장큰 수 3개 곱
        * 가장 작은 음수 두개와 가장 큰 양수 하나의 곱
        * 둘중 큰걸 반환
        * */
        Arrays.sort(arr);
        int a = arr[arr.length-1] * arr[arr.length-2] * arr[arr.length-3];
        int b = arr[arr.length-1] * arr[0] * arr[1];
        return Math.max(a, b);
    }
}

package base;

public class SuperIncreasing {
    public static void main(String[] args) {
        boolean output = superIncreasing(new int[]{1, 3, 6, 13, 54});
        System.out.println(output); // --> true

        output = superIncreasing(new int[]{1, 3, 5, 9});
        System.out.println(output); // --> false
    }

    private static boolean superIncreasing(int[] arr) {
        // 0 ~ i-1 합이 i보다 커야한다
//        long sum = Long.MIN_VALUE;
        long sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (sum >= arr[i]) return false;
            sum += arr[i];
        }
        return true;
    }
}
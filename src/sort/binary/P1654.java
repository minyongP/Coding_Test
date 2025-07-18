package sort.binary;

import java.util.Arrays;
import java.util.Scanner;

public class P1654 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int N = sc.nextInt();
        long[] A = new long[K];
        for (int i = 0; i < K; i++) {
            A[i] = sc.nextInt();
        }

        long max = Arrays.stream(A).max().orElse(0);
        long min = 1;
        long ans = 0;

        while (min <= max) {
            long mid = (max + min) / 2;
            long sum = 0;
            for (int i = 0; i < K; i++) {
                sum += Math.max(A[i] / mid, 0);
            }
            if (sum >= N) {
                ans = mid;
                min = mid + 1;
            } else if (sum < N) {
                max = mid - 1;
            }
        }

        System.out.println(ans);
    }
}

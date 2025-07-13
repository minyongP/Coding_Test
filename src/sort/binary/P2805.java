package sort.binary;

import java.util.Arrays;
import java.util.Scanner;

public class P2805 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);
        int low = 0;    // low는 가장 작은 나무가 아니다 ans의 최솟값이다
        int high = Arrays.stream(A).max().orElse(0);
        int ans = 0;

        while (low <= high) {
            long sum = 0;
            int mid = (high + low) / 2;
            for (int i : A) {
                sum += Math.max(i - mid, 0);
            }
            if (sum >= M) {
                ans = mid;
                low = mid + 1;
            }
            else if (sum < M) high = mid - 1;
        }

        System.out.println(ans);
    }
}

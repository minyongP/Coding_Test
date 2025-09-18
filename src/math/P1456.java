package math;

import java.util.Scanner;

public class P1456 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A, B;
        A = sc.nextLong();
        B = sc.nextLong();

        // 에라토스테네스의 체로 소수 구하기
        // input이 10^14이므로 10^7까지 구하기
        long[] arr = new long[10000001];
        for (int i = 2; i < arr.length; i++) {
            arr[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(arr.length); i++) {
            if (arr[i] == 0) continue;

            for (int j = i + i; j < arr.length; j += i) {
                arr[j] = 0;
            }
        }

        int ans = 0;
        for (int i = 2; i < arr.length; i++) {
            if (arr[i]!=0) {
                long temp = i;

                // 곱이 long의 범위를 넘어갈 수 있어 이항정리
                while ((double)arr[i] <= (double)B / (double)temp) {
                    if ((double)arr[i] >= (double)A / (double)temp) ans++;
                    temp *= i;
                }
            }
        }

        System.out.println(ans);
    }
}

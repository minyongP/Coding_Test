package sort.counting;

import java.util.Arrays;
import java.util.Scanner;

public class P2108 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[8001];
        for (int i = 0; i < N; i++) {
            int input = sc.nextInt() + 4000;
            A[input] += 1;
        }

        // 평균
        long avg = 0;
        for (int i = 0; i < A.length; i++) avg += (i - 4000) * A[i];
        System.out.println((int) Math.round((double) avg / N));

        // 중앙값
        int mid = 0;
        int cnt = 0;
        for (int i = 0; i < A.length; i++) {
            cnt += A[i];
            if (cnt >= N / 2) {
                mid = i - 4000;
                break;
            }
        }
        System.out.println(mid);

        // 최빈값 (여러개일 경 두번째로 작은 값)
        int max_freq = Arrays.stream(A).max().getAsInt();
        int freq = 0;
        cnt = 0;
        for (int i = 0; i < A.length; i++) {
            if (max_freq == A[i]) {
                freq = i - 4000;
                cnt++;
            }
            if (cnt == 2) break;
        }
        System.out.println(freq);

        // 최대 최소 차이
        int min = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                min = i - 4000;
                break;
            }
        }
        int max = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] > 0) {
                max = i - 4000;
                break;
            }
        }
        int diff = max - min;
        System.out.println(diff);
    }
}

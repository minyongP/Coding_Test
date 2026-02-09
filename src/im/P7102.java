package im;

import java.util.Arrays;
import java.util.Scanner;

public class P7102 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc < T+1; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] A = new int[N+M+1];
            for (int i = 1; i < N+1; i++) {
                for (int j = 1; j < M+1; j++)
                    A[i+j]++;
            }

            String ans = "";
            int max = Arrays.stream(A).max().getAsInt();
            for (int i = 2; i < N+M+1; i++) {
                if (max == A[i]) ans += " " + i;
            }

            System.out.println("#" + tc + ans);
        }
    }
}

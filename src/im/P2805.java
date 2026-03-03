package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] A = new int[N][N];
            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                A[i][0] = s.charAt(0) - '0';
                for (int j = 1; j < N; j++) {
                    // prefix sum
                    A[i][j] = (s.charAt(j) - '0') + A[i][j-1];
                }
            }

            long ans = 0;
            // two point
            int s = N / 2;
            int e = N / 2;
            for (int i = 0; i <= N / 2; i++) {
                if (i == N / 2) ans += A[i][e];
                else {
                    ans += A[i][e] - A[i][s - 1];
                    s--;
                    e++;
                }
            }
            for (int i = N / 2 + 1; i < N; i++) {
                s++;
                e--;
                ans += A[i][e] - A[i][s-1];
            }
            System.out.println("#" + tc + " " + ans);
        }
    }
}

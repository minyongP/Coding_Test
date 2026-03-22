import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] A = new int[2][N];

            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    A[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[2][N];
            dp[0][0] = A[0][0];
            dp[1][0] = A[1][0];

            for (int i = 1; i < N; i++) {
                // up
                dp[0][i] = dp[1][i - 1] + A[0][i];
                // down
                dp[1][i] = dp[0][i - 1] + A[1][i];
                // jump
                if (i >= 2) {
                    dp[0][i] = Math.max(
                            dp[0][i],
                            Math.max(dp[0][i - 2], dp[1][i - 2]) + A[0][i]
                    );

                    dp[1][i] = Math.max(
                            dp[1][i],
                            Math.max(dp[0][i - 2], dp[1][i - 2]) + A[1][i]
                    );
                }
            }

            System.out.println(Math.max(dp[0][N - 1], dp[1][N - 1]));
        }
    }
}

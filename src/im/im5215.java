package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class im5215 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            int[] A = new int[N];
            int[][] dp = new int[N+1][L+1];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int taste = Integer.parseInt(st.nextToken());
                int cal = Integer.parseInt(st.nextToken());
                A[cal] = taste;
            }

            for (int i = 0; i < N+1; i++) { // 선택 개수
                for (int maxCal = 1; maxCal < N + 1; maxCal++) {
                    for (int k = 0; k < A.length; k++) {
                        if (dp[i-1] + A[k] <= maxCal)
                        dp[i][maxCal] = ;
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(dp[N]);
        }
        System.out.print(sb);
    }
}

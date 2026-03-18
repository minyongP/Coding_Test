package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class im5215 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= TC; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            int[] T = new int[N];
            int[] K = new int[N];
            long[] dp = new long[L+1];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                T[i] = Integer.parseInt(st.nextToken());
                K[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < N; i++) {
                for (int j = L; j >= 0; j--) {
                    if (K[i] + j <= L) {
                        dp[j + K[i]] = Math.max(dp[j + K[i]], dp[j] + T[i]);
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(Arrays.stream(dp).max().getAsLong()).append("\n");
        }
        System.out.print(sb);
    }
}

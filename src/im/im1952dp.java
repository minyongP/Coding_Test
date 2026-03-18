package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class im1952dp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb= new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int[] tickets = new int[4];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) tickets[i] = Integer.parseInt(st.nextToken());

            int[] months = new int[16];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= 12; i++) months[i] = Integer.parseInt(st.nextToken());

            long[] dp = new long[16];
            for (int i = 1; i < dp.length; i++) {
                // 1일권 추가 or 1달권 추가 or 3달전에 3달권 사기
                dp[i] = Math.min(dp[i - 1] + months[i] * tickets[0], dp[i - 1] + tickets[1]);
                if (i >= 3) dp[i] = Math.min(dp[i], dp[i - 3] + tickets[2]);
            }

            sb.append("#").append(tc).append(" ").append(Math.min(tickets[3], dp[15])).append("\n");
        }
        System.out.print(sb);
    }
}

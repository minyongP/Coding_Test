package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1970 {
    public static void main(String[] args) throws IOException {
        final int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append("\n");
            int N = Integer.parseInt(br.readLine().trim());
            for (int i = 0; i < money.length; i++) {
                sb.append(N / money[i]).append(" ");
                N %= money[i];
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

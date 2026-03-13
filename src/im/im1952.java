package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class im1952 {
    static int[] price;
    static int[] plan;
    static long minPrice;

    static void dfs(int month, long curPrice) {
        if (curPrice >= minPrice) return;
        if (month >= 12) {
            minPrice = Math.min(minPrice, curPrice);
            return;
        }

        // 1일권
        dfs(month+1, curPrice + (plan[month] * price[0]));

        // 1달권
        if (plan[month] * price[0] > price[1]) {
            dfs(month+1, curPrice + price[1]);
        }

        // 3달권
        dfs(month+3, curPrice + price[2]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            price = new int[4];
            plan = new int[15];
            minPrice = Long.MAX_VALUE;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                price[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 12; i++) {
                plan[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);
            minPrice = Math.min(minPrice, price[3]);

            sb.append("#").append(tc).append(" ").append(minPrice).append("\n");
        }
        System.out.print(sb);
    }
}

package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class im14510 {
    static int[] A;

    private static long getAns(int max) {
        long a = 0;
        long b = 0;
        for (int i : A) {
            long diff = max - i;
            a += diff / 2;
            b += diff % 2;
        }

        while (a - 1 > b) {
            a--;
            b += 2;
        }
        return a >= b ? a * 2 : b * 2 - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine().trim());A = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
            int max = Arrays.stream(A).max().getAsInt();

            long ans = Math.min(getAns(max), getAns(max + 1));

            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }
}

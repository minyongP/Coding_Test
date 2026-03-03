package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P9940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            String ans = "Yes";
            int N = Integer.parseInt(br.readLine());
            boolean[] v = new boolean[N+1];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                // 중복 검사
                int input = Integer.parseInt(st.nextToken());
                if(v[input]) ans = "No";
                v[input] = true;
            }

            for (int i = 1; i < v.length; i++) {
                // 순열 검사
                if (!v[i]) {
                    ans = "No";
                    break;
                }
            }

            sb.append(ans);
            if (tc != T) sb.append('\n');
        }
        System.out.println(sb.toString());
    }
}

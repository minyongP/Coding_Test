package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P6782 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            long N = Long.parseLong(br.readLine());
            long cnt = 0;

            while (N > 2) {
                long sqrt = (long) Math.floor(Math.sqrt(N));
                // 제곱수인 경우
                if (sqrt * sqrt == N) {
                    N = sqrt;
                    cnt++;
                }
                // 그리디 점프 (제곱수까지 만들고 루트만들기)
                else {
                    long next = (sqrt + 1) * (sqrt + 1);
                    cnt += next - N;
                    N = (long) Math.sqrt(next);
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb.toString());
    }
}

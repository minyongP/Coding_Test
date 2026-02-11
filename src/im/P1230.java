package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = 10;
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            int[] a = new int[20000];
            int size = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) a[size++] = Integer.parseInt(st.nextToken());

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                char cmd = st.nextToken().charAt(0);

                if (cmd == 'I') {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    int[] s = new int[y];
                    for (int j = 0; j < y; j++) s[j] = Integer.parseInt(st.nextToken());
                    System.arraycopy(a, x, a, x + y, size - x);   // 오른쪽 shift
                    System.arraycopy(s, 0, a, x, y);
                    size += y;
                } else if (cmd == 'D') {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    int end = x + y;
                    System.arraycopy(a, end, a, x, size - end);   // 왼쪽 shift
                    size -= (end - x);
                } else { // 'A'
                    int y = Integer.parseInt(st.nextToken());
                    int[] s = new int[y];
                    for (int j = 0; j < y; j++) s[j] = Integer.parseInt(st.nextToken());
                    System.arraycopy(s, 0, a, size, y);
                    size += y;
                }
            }

            sb.append('#').append(tc);
            for (int i = 0; i < 10; i++) {
                sb.append(' ').append(a[i]);
            }
            sb.append('\n');
        }

        System.out.print(sb.toString());
    }
}

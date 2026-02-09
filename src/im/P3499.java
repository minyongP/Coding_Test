package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class P3499 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Deque<String> q1 = new ArrayDeque<>();
        Deque<String> q2 = new ArrayDeque<>();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc < T+1; tc++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < Math.ceil(N / 2.0); i++) q1.add(st.nextToken());
            for (int i = 0; i < N / 2; i++) q2.add(st.nextToken());

            System.out.print("#" + tc);

            for (int i = 0; i < N / 2; i++){
                System.out.print(" " + q1.poll());
                System.out.print(" " + q2.poll());
            }
            if (N % 2 == 1) System.out.print(" " + q1.poll());
            System.out.println();
        }
    }
}

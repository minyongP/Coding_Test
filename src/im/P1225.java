package im;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P1225 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = 10;

        for (int test_case = 1; test_case < T+1; test_case++) {
            int t = sc.nextInt();
            Deque<Long> q = new ArrayDeque<>();
            for (int i = 0 ; i < 8; i ++) {
                q.add(sc.nextLong());
            }

            int k = 1;
            while (true) {
                long now = q.poll() - k;
                if (now <= 0) {
                    q.add(0L);
                    break;
                }

                q.add(now);
                k = (k % 5) + 1;
            }


            System.out.print("#" + t);
            for (long l : q) System.out.print(" " + l);
            System.out.println();
        }
    }
}

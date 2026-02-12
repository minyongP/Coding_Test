package im;

import java.util.Scanner;

public class P10726 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc < T + 1; tc++) {
            int N = sc.nextInt();
            long M = sc.nextLong();
            long a = (1L << N) - 1;
            if ((M & a) == a) System.out.println("#" + tc + " ON");
            else System.out.println("#" + tc + " OFF");
        }
    }
}

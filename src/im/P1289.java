package im;

import java.util.Arrays;
import java.util.Scanner;

public class P1289 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for (int tc = 1; tc < T + 1; tc++) {
            String s = sc.nextLine();
            long ans = 0;
            char now = '0';
            for (char c : s.toCharArray()) {
                if (c != now) {
                    ans++;
                    now = (now == '0') ? '1' : '0';
                }
            }
            System.out.println("#" + tc + " " + ans);
        }
    }
}

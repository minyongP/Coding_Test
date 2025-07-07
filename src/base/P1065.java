package base;

import java.util.Scanner;

public class P1065 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int ans = 0;
        boolean isAP;
        for (int i = 1; i <= N; i++) {
            if (i < 100) {
                ans++;
            } else {
                isAP = true;
                char[] c = String.valueOf(i).toCharArray();
                int diff = Integer.parseInt(String.valueOf(c[1])) - Integer.parseInt(String.valueOf(c[0]));
                for (int j = 2; j < c.length; j++) {
                    if (diff != Integer.parseInt(String.valueOf(c[j])) - Integer.parseInt(String.valueOf(c[j-1]))) {
                        isAP = false;
                        break;
                    }
                }
                if (isAP) ans++;
            }
        }
        System.out.println(ans);
    }
}

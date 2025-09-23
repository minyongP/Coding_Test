package string;

import java.util.*;

public class P1302 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] A = new String[N];
        for (int i = 0; i < N; i++) A[i] = sc.next();
        Arrays.sort(A);

        String ans = A[0];
        int max = 1;
        int cnt = 1;

        for (int i = 1; i < N; i++) {
            if (A[i].equals(A[i-1])) {
                cnt++;
            } else {
                cnt = 1;
            }

            if (cnt > max) {
                max = cnt;
                ans = A[i];
            }
        }

        System.out.println(ans);
    }
}

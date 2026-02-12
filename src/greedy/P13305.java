package greedy;

import java.util.Scanner;

public class P13305 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] node  = new int[N];
        int[] edge = new int[N-1];

        for (int i = 0; i < N-1; i++) edge[i] = sc.nextInt();
        for (int i = 0; i < N; i++) node[i] = sc.nextInt();

        long ans = 0;
        int minGas = Integer.MAX_VALUE;
        for (int i = 0; i < N-1; i++) {
            if (minGas > node[i]) {
                minGas = node[i];
            }
            ans += (long) minGas * edge[i];
        }
        System.out.println(ans);
    }
}

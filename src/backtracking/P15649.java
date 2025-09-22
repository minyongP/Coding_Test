package backtracking;

import java.util.Scanner;

public class P15649 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 1; i < fact(n) * fact(n - m); i++){

            for (int j = 1; j < m; j++) {
                System.out.println(i + " " + j);
            }
        }
    }

    private static int fact(int i) {
        if (i == 1) return 1;
        return fact(i-1) * i;
    }
}

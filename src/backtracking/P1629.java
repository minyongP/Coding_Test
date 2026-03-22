package backtracking;

import java.util.Scanner;

public class P1629 {
    static int A,B,C;

    static long pow(int A, int B) {
        if (B == 1) return A % C;
        long temp = pow(A, B / 2);
        if (B % 2 == 0) return temp * temp % C;
        else return (temp * temp % C) * (A % C) % C;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();
        System.out.println(pow(A, B));
    }
}

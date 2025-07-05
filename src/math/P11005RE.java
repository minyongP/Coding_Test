package math;

import java.util.Scanner;

public class P11005RE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int B = scanner.nextInt();
        StringBuilder A = new StringBuilder();

        while (N != 0) {
            int temp = N % B;
            if (temp < 10) A.append((char) (temp + '0'));
            else A.append((char) (temp + - 10 + 'A'));
            N /= B;
        }
        A.reverse();
        System.out.print(A);
    }
}
package dfs;

import java.util.Scanner;

public class P2023 {
    static int N;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        // n번째 수가 소수인건 4개뿐
        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
    }

    private static void dfs(int num, int digit) {
        if (digit == N) {
            if (isPrime(num)) System.out.println(num);
            return;
        }
        for (int i = 1; i < 10; i++) {
            if (isPrime(num*10 + i))
                dfs(num*10+i, digit+1);
        }
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i <= (int)Math.sqrt(num); i++)
            if (num % i == 0) return false;
        return true;
    }
}

package math;

import java.util.Scanner;

public class P1747 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 소수 구하기
        int[] A = new int[1000001];
        for (int i = 2; i < A.length; i++) A[i] = i;

        for (int i = 2; i < Math.sqrt(A.length); i++) {
            if (A[i] == 0) continue;
            for (int j = i + i; j < A.length; j += i) A[j] = 0;
        }

        // 팰린드롬 구하기
        int i = N;
        while (true) {
            if (A[i] != 0) {
                int result = A[i];
                if (isPalindrome(result)) {
                    System.out.println(result);
                    break;
                }
            }
            i++;
        }
    }

    private static boolean isPalindrome(int result) {
        char[] temp = String.valueOf(result).toCharArray();
        // 투포인터
        int s = 0;
        int e = temp.length-1;

        while (s < e) {
            if (temp[s++] != temp[e--]) return false;
        }
        return true;
    }
}

package math;

import java.util.Scanner;

public class P13235 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.nextLine();
        System.out.println(isPalindrome(N));
    }

    private static boolean isPalindrome(String str) {
        char[] arr = str.toCharArray();

        // 투포인터
        int s = 0;
        int e = arr.length-1;

        while (s < e) {
            if (arr[s++] != arr[e--]) return false;
        }
        return true;
    }
}

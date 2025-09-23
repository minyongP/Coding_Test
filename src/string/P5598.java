package string;

import java.util.Scanner;

public class P5598 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] code = sc.next().toCharArray();
        String ans = "";
        for (char c : code) ans += (char)((c - 42) % 26 + 65);
        System.out.println(ans);
    }
}
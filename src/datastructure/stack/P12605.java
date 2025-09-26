package datastructure.stack;

import java.util.Scanner;
import java.util.Stack;

public class P12605 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= n; i++) {
            Stack<String> stack = new Stack<>();
            for (String s : sc.nextLine().split(" ")) {
                stack.push(s);
            }
            System.out.print("Case #"+ i + ":");
            while (!stack.isEmpty()) {
                System.out.print(" " + stack.pop());
            }
            System.out.println();
        }
    }
}

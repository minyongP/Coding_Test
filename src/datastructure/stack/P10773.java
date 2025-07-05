package datastructure.stack;

import java.util.Scanner;
import java.util.Stack;

public class P10773 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < K; i++) {
            int input = scanner.nextInt();
            if (input == 0) stack.pop();
            else stack.push(input);
        }

        System.out.println(stack.stream().reduce(0, Integer::sum));
    }
}

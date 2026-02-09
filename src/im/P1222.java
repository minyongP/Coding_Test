package im;

import java.util.*;

public class P1222 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int test_case = 1; test_case <= 10; test_case++) {
            Deque<Integer> stack = new ArrayDeque<>();
            sc.nextLine();
            char[] A = sc.nextLine().toCharArray();

            for (char c : A) {
                if (!stack.isEmpty() && stack.peek() == ('+' - '0')) {
                    stack.pop();
                    stack.push(stack.pop() + (int) ((c -'0')));
                } else stack.push((int) (c -'0'));
            }

            System.out.println("#" + test_case + " " + stack.pop());
        }

    }
}

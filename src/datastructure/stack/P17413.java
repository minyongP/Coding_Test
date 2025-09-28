package datastructure.stack;

import java.util.*;

public class P17413 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        boolean inTag = false;

        for (char c : sc.nextLine().toCharArray()) {
            if ('>' == c) {
                while (!stack.isEmpty()) sb.append(stack.pop());
                inTag = false;
                sb.append(c);
            } else if ('<' == c) {
                while (!stack.isEmpty()) sb.append(stack.pop());
                inTag = true;
                sb.append(c);
            } else if (inTag) {
                sb.append(c);
            } else if (' ' == c) {
                while (!stack.isEmpty()) sb.append(stack.pop());
                sb.append(" ");
            } else {
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) sb.append(stack.pop());
        System.out.println(sb);
    }
}

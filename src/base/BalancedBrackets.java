package base;

import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) {
        boolean output = balancedBrackets(")");
        System.out.println(output);

        boolean output1 = balancedBrackets("[](){}");
        System.out.println(output1); // --> true

        boolean output2 = balancedBrackets("[({})]");
        System.out.println(output2); // --> true

        boolean output3 = balancedBrackets("[(]{)}");
        System.out.println(output3); // --> false
    }

    static Stack<Character> stack;
    private static boolean balancedBrackets(String str) {
        stack = new Stack<>();
        char[] C = str.toCharArray();
        for (char c : C) {
            switch (c) {
                case '[': {
                    stack.push('[');
                    break;
                }
                case ']': {
                    if (valid('[')) return false;
                    break;
                }
                case '{': {
                    stack.push('{');
                    break;
                }
                case '}': {
                    if (valid('{')) return false;
                    break;
                }
                case '(': {
                    stack.push('(');
                    break;
                }
                case ')': {
                    if (valid('(')) return false;
                    break;
                }
            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }
    private static boolean valid(char c) {
        if (stack.isEmpty() || stack.pop() != c) return true;
        return false;
    }
}

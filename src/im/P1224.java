package im;

import java.util.*;

public class P1224 {
    public static void main(String[] args) {
        /*
        * 연산자는 스택에 넣고 숫자는 버퍼에 저장
        * 닫는 괄호가 나오면 여는 괄호가 나올때까지 pop
        * 마지막 스택 다 pop
        * */
        Scanner sc = new Scanner(System.in);
        StringBuilder sb;
        Map<Character, Integer> priority = new HashMap<>();
        priority.put('(', 0);
        priority.put('+', 1);
        priority.put('*', 2);

        for(int test_case = 1; test_case <= 10; test_case++) {
            sc.nextLine();
            String input = sc.nextLine();
            sb = new StringBuilder();
            Deque<Character> op = new ArrayDeque<>();

            for (char c : input.toCharArray()) {
                if ('0' < c && c < '9' + 1) {
                    sb.append(c);
                } else if (c == '(') {
                    op.push(c);
                } else if (c == ')') {
                    while (op.peek() != '(') {
                        sb.append(op.pop());
                    }
                    op.pop(); // (
                } else {
                    while (!op.isEmpty() && priority.get(op.peek()) >= priority.get(c)) {
                        sb.append(op.pop());
                    }
                    op.push(c);
                }
            }

            Deque<Long> ans = new ArrayDeque<>();
            for (char c : sb.toString().toCharArray()) {
                if ('0' < c && c < '9' + 1) {
                    ans.push((long) (c - '0'));
                } else {
                    if (c == '+') {
                        ans.push(ans.pop() + ans.pop());
                    }
                    if (c == '*') {
                        ans.push(ans.pop() * ans.pop());
                    }
                }
            }

            System.out.println("#" + test_case + " " + ans.pop());
        }
    }
}

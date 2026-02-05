package im;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P5432 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = Integer.parseInt(sc.nextLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            long ans = 0;
            char[] A = sc.nextLine().toCharArray();
            Deque<Character> deque = new ArrayDeque<>();

            for (int i = 0; i < A.length; i++) {
                // 레이저인 경우: 스택 길이 만큼 추가
                char c = A[i];
                if (c == ')' && A[i-1] == '(') {
                    deque.pop();
                    ans += deque.size();
                }
                // 닫히는 경우: +1
                else if (c == ')') {
                    deque.pop();
                    ans++;
                }
                else deque.push(c);
            }

            System.out.println("#" + test_case + " " + ans);
        }
    }
}

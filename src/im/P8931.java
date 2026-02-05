package im;

import java.util.*;

public class P8931 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                int input = sc.nextInt();
                if (input == 0) deque.pop();
                else deque.push(input);
            }
            System.out.println("#" + test_case + " " + deque.stream().mapToInt(Integer::intValue).sum());
        }
    }
}
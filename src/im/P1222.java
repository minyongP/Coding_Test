package im;

import java.util.*;

public class P1222 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int test_case = 1; test_case <= 10; test_case++) {
            Deque<Integer> stack = new ArrayDeque<>();
            sc.nextLine();


            System.out.println("#" + test_case + " " + stack.pop());
        }

    }
}

package im;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P1224 {
    public static void main(String[] args) {
        /*
        * 연산자는 스택에 넣고 숫자는 버퍼에 저장
        * 닫는 괄호가 나오면 여는 괄호가 나올때까지 pop
        * 마지막 스택 다 pop
        * */
        Scanner sc = new Scanner(System.in);
        for(int test_case = 1; test_case <= 10; test_case++) {
            Deque<Integer> stack = new ArrayDeque<>();

            System.out.println("#" + test_case + " " + stack.pop());
        }
    }
}

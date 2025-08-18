package recursiveFunc;

import java.util.Scanner;

public class P11729 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        System.out.println((int) Math.pow(2, count) - 1);

        hanoi(count, 1, 3, 2);

        System.out.println(sb.toString());
    }
    // count(시작지점의 원반, 시작지점, 목표지점, 보조지점)
    static void hanoi(int count, int start, int target, int sub) {
        if (count == 1) {
            sb.append(start).append(" ").append(target).append("\n");
            return;
        }
        hanoi(count-1, start, sub, target);
        sb.append(start).append(" ").append(target).append("\n");
        hanoi(count-1, sub, target, start);
    }
}

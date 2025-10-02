package datastructure.deque;

import java.util.*;

public class P2346 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Deque<int[]> deque = new ArrayDeque<>();
        
        for (int i = 1; i <= N; i++) {
            deque.add(new int[]{i, sc.nextInt()});
        }

        while (!deque.isEmpty()) {
            int[] now = deque.pollFirst();
            System.out.print(now[0] + " ");
            int paper = now[1];

            if (deque.isEmpty()) break;

            if (paper > 0) {
                for (int j = 0; j < paper - 1; j++) {
                    deque.addLast(deque.pollFirst()); // 오른쪽 회전
                }
            } else {
                for (int j = 0; j < -paper; j++) {
                    deque.addFirst(deque.pollLast()); // 왼쪽 회전
                }
            }
        }
    }
}

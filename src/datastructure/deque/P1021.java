package datastructure.deque;

import java.util.*;

//좌우맹.. 왼쪽과 오른쪽이동중 더 가까운것 고르기 시간제한은 괜찮을듯 N은 50보다 작거나 같은 자연수이고, M은 N보다 작거나 같은 자연수이다
public class P1021 {
    static Deque<Integer> deque;
    static int result = 0;

    public static void main(String[] args) {
        deque = new ArrayDeque();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }
        int m = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= m; i++) {
            q.add(sc.nextInt());
        }

        while (!q.isEmpty()) {
            int now = q.poll();

            int cnt = task(now);
            result += Math.min(cnt, deque.size()-cnt);
        }

        System.out.println(result);
    }

    private static int task(int now) {
        int cnt = 0;
        while (true) {
            if (now == deque.peek()) {
                deque.poll();
                break;
            }
            deque.addFirst(deque.pollLast());
            cnt++;
        }
        return cnt;
    }
}

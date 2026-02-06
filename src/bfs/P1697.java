package bfs;

import java.util.*;
public class P1697 {
    public static void main(String[] args) {
        final int MAX_DISTANCE = 100001;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        Deque<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[MAX_DISTANCE];

        q.add(new int[]{N, 0});
        visited[N] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int cnt = now[1];

            if (x == K) {
                System.out.println(cnt)     ;
                break;
            }
            // 뒤로
            if (x-1 >= 0 && !visited[x-1]) {
                q.add(new int[] {x-1, cnt+1});
                visited[x-1] = true;
            }
            // 앞으로
            if (x+1 < MAX_DISTANCE && !visited[x+1]) {
                q.add(new int[] {x+1, cnt+1});
                visited[x+1] = true;
            }
            // 두배
            if (2*x < MAX_DISTANCE && !visited[2*x]) {
                q.add(new int[] {2*x, cnt+1});
                visited[2*x] = true;
            }
        }
    }
}

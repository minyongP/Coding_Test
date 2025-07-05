package bfs;
import java.util.*;
public class P1697 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        System.out.println(BFS(N, K));
    }
    private static int BFS(int N, int K) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{N, 0});
        boolean[] v = new boolean[K*2];
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (now[0] == K) return now[1];
            if (now[0]-1 >= 0 && !v[now[0]-1]) {
                q.offer(new int[] {now[0]-1, now[1]+1});
                v[now[0]-1] = true;
            }
            if (now[0]*2 <= K && !v[now[0]*2]) {
                q.offer(new int[]{now[0]*2, now[1]+1});
                v[now[0*2]] = true;
            }
            if (now[0]+1 <= K && !v[now[0]+1]) {
                q.offer(new int[]{now[0]+1, now[1]+1});
                v[now[0]+1] = true;
            }
        }
        return -1;
    }
}
/*
* N(시작점) K(도착점)
* BFS(N,F) 출력
* BFS {
*   큐에 시작점, 연산횟수 저장
*   방문배열에 시작점 저장
*   while(큐가 빌때까지) {
*       if(now == K) q[1];
*       if(now > K && 미방문) {now-1큐에 저장, 방문배열++ 저장}
*       if(now*2 <= K && 미방문) { now*2큐 저장, 방문저장++ }
*       if(now+1 <= K && 미방문) { now+1 저장++ }
*   }
* }
* */
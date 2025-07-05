package bfs;

import java.util.*;

public class P25418 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int K = scanner.nextInt();
        System.out.println(BFS(A,K));
    }
    private static int BFS(int A, int K) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[K+1];
        queue.offer(new int[]{A,0});
        visited[A] = true;
        while (!queue.isEmpty()) {
            int now[] = queue.poll();
            if (now[0] == K) return now[1];
            if (now[0]*2 <= K && !visited[now[0]*2]) {
                queue.offer(new int[]{now[0]*2, now[1]+1});
                visited[now[0]*2] = true;
            }
            if (now[0]+1 <= K && !visited[now[0]+1]) {
                queue.offer(new int[]{now[0]+1, now[1]+1});
                visited[now[0]+1] = true;
            }
        }
        return -1;
    }
}
/*
* A(시작점) K(도착점)
* BFS실행
* BFS {
*   큐에 시작점과 연산횟수 저장
*   방문배열 초기화
*   while(큐가 빌때까지) {
*       if(now==K) 현재점의 연산횟수 출력
*       if(2배가 K보다 작고, 미방문시) 큐에 2배점과 연산횟수+1저장, 방문배열 저장
*       if(+1이 K보다 작고, 미방문시) 큐에 +1점과 연산횟수+1저장, 방문배열 저장
*   }
* }
 */
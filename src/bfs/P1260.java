package bfs;

import java.util.*;

public class P1260 {
    /*
    * N(노드수) M(엣지수) start(시작점)
    * A(인접리스트)
    * visited(방문배열)
    *
    * for(N){인접리스트 초기화}
    * for(M){인접리스트에 엣지 저장}
    *
    * 방문배열 초기화 - dfs(start)
    * 방문배열 초기화 - dfs(start)
    *
    * dfs{
    *   현재 노드 출력
    *   방문배열에 현재 노드 기록
    *   if(!visited(현재 노드)){dfs실행}
    * }
    * bfs{
    *   큐에 시작 노드 삽입
    *   방문배열에 현재 노드 기록
    *   while(큐가 빌때까지){
    *       큐에서 노드 가져오기
    *       현재 노드 출력
    *       현재 노드에 연결 노드중 방문하지 않은 노드 큐에 삽입하고 방문배열에 기록
    *   }
    * }
    * */
    static ArrayList<Integer> A[];
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int start = scanner.nextInt();
        A = new ArrayList[N+1];

        for (int i = 1; i < N+1; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int s = scanner.nextInt();
            int e = scanner.nextInt();
            A[s].add(e);
            A[e].add(s);
        }

        // 시작노드의 연결노드중 작은 수부터 방문하기 위한 정렬
        for (int i = 1; i < N+1; i++) {
            Collections.sort(A[i]);
        }

        visited = new boolean[N+1];
        dfs(start);
        System.out.println();
        visited = new boolean[N+1];
        bfs(start);
    }

    private static void dfs(int now) {
        System.out.print(now + " ");
        visited[now] = true;
        for (int i : A[now]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");
            for (int i : A[now]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}

package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1167 {
    static ArrayList<Edge>[] A;
    static boolean[] visited;
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        A = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            while (true) {
                int E = Integer.parseInt(st.nextToken());
                if (E == -1) break;
                int V = Integer.parseInt(st.nextToken());
                A[S].add(new Edge(E, V));
            }
        }
        visited = new boolean[N+1];
        distance = new int[N+1];
        BFS(1);
        int max = 1;
        for (int i = 2; i <= N; i++) {
            if (distance[max] < distance[i]) max=i;
        }
        visited = new boolean[N+1];
        distance = new int[N+1];
        BFS(max);
        Arrays.sort(distance);
        System.out.println(distance[N]);
    }
    private static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (Edge i : A[now]) {
                int e = i.e;
                int v= i.value;
                if (!visited[e]) {
                    visited[e] = true;
                    distance[e] = distance[now] + v;
                    queue.offer(e);
                }
            }
        }
    }
    private static class Edge {
        int e, value;
        private Edge(int e, int value) {
            this.e = e;
            this.value = value;
        }
    }
}
/*
* N(노드개수)
* A(노드배열) visited(방문배열) distance(거리배열)
* for(N){ A인접리스트 초기화 }
* for(N){ A에 그래프 저장 }
* visited, distance 초기화
* BFS(임의의 점)
* distance에서 가장 큰 노드 저장
* visited, distance 초기화
* BFS(가장 큰 노드)
* distance에서 가장 큰 노드 출력
* BFS {
*   큐에 시작노드 삽입
*   방문배열에 저장
*   while(큐가 빌때까지) {
*       큐에서 노드 가져오기
*       방문하지 않은 노드로 큐에 넣고 방문배열 저장
*       현재 노드 + 엣지길이로 거리배열 저장
*   }
* }
* Edge {
*   e(목적지), value(길이)
* }
* */
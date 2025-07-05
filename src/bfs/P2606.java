package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2606 {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        A = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }
        BFS(1);
        int result = -1;
        for (boolean i : visited) {
            if (i == true) result++;
        }
        System.out.println(result);
    }
    private static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i : A[now]) {
                if (!visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
/*
* N(노드수) M(엣지수)
* A(연결배열) visited(방문배열)
* for(M) { A초기화 }
* BFS(1)
* 방문한 노드 값 출력
* BFS {
*   큐에 노드 추가
*   방문배열 추가
*   while(큐가 빌때까지) {
*       큐에서 노드 꺼내기
*       for(연결노드 가져오기) {
*           if(방문하지 않았을때){
*               큐에 저장
*               방문배열에 저장
* }}}}
*   */
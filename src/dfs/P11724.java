package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P11724 {
    /*
     * N(노드 개수) M(엣지 개수)
     * A(그래프 인접리스트)
     * visited(방문 배열)
     * for(n) A 리스트 초기화
     * for(m) A 초기화
     * for(n)
     *   if(!visited)
     *       연결 요소 개수++
     *       dfs()
     * //재귀함수
     * dfs
     *   if(현재 노드 == 방문 노드) return;
     *   방문배열 기록
     *   dfs(현재 노드의 연결 노드 중 방문 하지 않는 노드로)
     * */
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 노드 개수
        int M = Integer.parseInt(st.nextToken());   // 엣지 개수
        A = new ArrayList[N+1];
        visited = new boolean[N+1];
        for (int i = 1; i < N+1; i++) A[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        // 방향이 없으므로 양방향으로 추가
        A[s].add(e);
        A[e].add(s);
    }
        int count = 0;
        for (int i = 1; i < N+1; i++) {
            if (!visited[i]) {
                count++;
                dfs(i);
            }
        }
        System.out.println(count);
    }

    private static void dfs(int node) {
        if (visited[node]) return;
        visited[node] = true;
        for (int i : A[node])
            if (!visited[i]) dfs(i);
    }
}

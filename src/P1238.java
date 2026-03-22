import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1238 {
    static int N,M,X;
    static ArrayList<Node>[] listFrom;
    static ArrayList<Node>[] listTo;
    static boolean[] visit;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        listFrom = new ArrayList[N+1];
        listTo = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            listFrom[i] = new ArrayList<>();
            listTo[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            listFrom[s].add(new Node(e, v));
            listTo[e].add(new Node(s, v));
        }
        dist = new int[2][N+1];
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist[i].length; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        visit = new boolean[N+1];
        dijkstra(0, listFrom);    // 정방향
        visit = new boolean[N+1];
        dijkstra(1, listTo);    // 역방향

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[0][i] == Integer.MAX_VALUE || dist[1][i] == Integer.MAX_VALUE) continue;
            ans = Math.max(ans, dist[0][i] + dist[1][i]);
        }
        System.out.print(ans);
    }

    private static void dijkstra(int dir, ArrayList<Node>[] list) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(X, 0)); // 시작점 수정
        dist[dir][X] = 0;
        while (!q.isEmpty()) {
            Node current = q.poll();
            int c_v = current.vertex;
            if (visit[c_v]) continue;
            visit[c_v] = true;
            for (int i = 0; i < list[c_v].size(); i++) {
                Node temp = list[c_v].get(i);
                int next = temp.vertex;
                int value = temp.value;
                if (dist[dir][next] > dist[dir][c_v] + value) {
                    dist[dir][next] = dist[dir][c_v] + value;
                    q.add(new Node(next, dist[dir][next]));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int vertex, value;

        public Node(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            if (this.value > o.value) return 1;
            else return -1;
        }
    }
}

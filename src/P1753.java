import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1753 {
    static class Node implements Comparable<Node>{
        int v;
        int e;

        public Node(int v, int e) {
            this.v = v;
            this.e = e;
        }

        @Override
        public int compareTo(Node o) {
            if (this.e > o.e) return 1;
            else return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        List<Node>[] A = new List[V+1];
        for (int i = 0; i <= V; i++) A[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            A[s].add(new Node(e, v));
        }

        int[] distance = new int[V+1];
        for (int i = 1; i < distance.length; i++) distance[i] = Integer.MAX_VALUE;
        boolean[] visited = new boolean[V+1];
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(K, 0));
        distance[K] = 0;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            int curV = cur.v;
            if (visited[curV]) continue;
            visited[curV] = true;

            for (int i = 0; i < A[curV].size(); i++) {
                Node tmp = A[curV].get(i);
                int next = tmp.v;
                int nextValue = tmp.e;
                if (distance[next] > distance[curV] + nextValue) {
                    distance[next] = distance[curV] + nextValue;
                    q.add(new Node(next, distance[next]));
                }
            }
        }
        for (int i = 1; i <= V; i++) {
            if (visited[i]) System.out.println(distance[i]);
            else System.out.println("INF");
        }
    }
}

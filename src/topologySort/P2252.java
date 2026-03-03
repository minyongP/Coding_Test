package topologySort;

import java.io.*;
import java.util.*;

public class P2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer>[] graph = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) {
            graph[i] = new ArrayList<>();
        }
        long[] indeg = new long[N+1];
        boolean[] v = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(B);
            indeg[B]++;
        }

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int now = q.poll();
            sb.append(now + " ");
            for (int i = 0; i < graph[now].size(); i++) {
                int next = graph[now].get(i);
                if (!v[next]) {
                    v[next] = true;
                    q.add(next);
                }
            }
        }

        System.out.println(sb.toString());
    }
}

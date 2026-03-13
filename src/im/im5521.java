package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class im5521 {
    static int N;
    static int M;
    static List<Integer>[] A;
    static boolean[] V;

    static private class Person {
        int num;
        int depth;

        public Person(int num, int depth) {
            this.num = num;
            this.depth = depth;
        }
    }

    private static void bfs(int s) {
        Queue<Person> q = new ArrayDeque<>();
        q.offer(new Person(s, 0));

        while (!q.isEmpty()) {
            Person p = q.poll();

            if (p.depth == 2) continue;

            for (int next : A[p.num]) {
                if (V[next]) continue;
                V[next] = true;
                q.offer(new Person(next, p.depth + 1));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            A = new List[N+1];
            V = new boolean[N+1];
            for (int i = 0; i < A.length; i++) {
                A[i] = new ArrayList<>();
            }

            for (int i = 0; i< M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                A[s].add(e);
                A[e].add(s);
            }

            V[1] = true;
            bfs(1);

            int ans = 0;
            for (int i = 2; i <= N; i++) {
                if (V[i]) ans++;
            }

            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }

}

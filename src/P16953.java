import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P16953 {
    static int N, M;
    static int ans = Integer.MAX_VALUE;

    static void bfs() {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{M, 1});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int temp = now[0];
            int depth = now[1];

            if (temp < N) continue;

            if (temp == N) ans = Math.min(ans, depth);

            if (temp % 10 == 1) q.add(new int[]{temp / 10, depth+1});

            if (temp % 2 == 0)q.add(new int[]{temp / 2, depth+1});
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        bfs();
        System.out.print(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}

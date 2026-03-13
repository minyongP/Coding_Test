package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class im1767 {
    static int N;
    static List<int[]> core = new ArrayList<>();
    static int[][] A;
    static long maxCoreCnt;
    static long minWireLen;

    static void dfs(int idx, long connCnt, long wireLen) {
        if (connCnt >= maxCoreCnt) {
            maxCoreCnt = connCnt;
            minWireLen = Math.min(minWireLen, wireLen);
        }
        if (idx >= core.size()) return;

        int[] curCore = core.get(idx);
        for (int i = 0; i < 4; i++) {
            long useWireLen = 0;
            // 코어 선택

            // todo 전선 충돌 체크
            if (i == 0) { // 상
                useWireLen = curCore[0];
            }
            if (i == 1) { // 하
                useWireLen = N - curCore[0] - 1;
            }
            if (i == 2) { // 좌
                useWireLen = curCore[1];
            }
            if (i == 3) { // 우
                useWireLen = N - curCore[1] - 1;
            }

            dfs(idx+1, connCnt+1, wireLen + useWireLen);
        }
        // 미선택
        dfs(idx+1, connCnt, wireLen);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine().trim());
            A = new int[N][N];
            core.clear();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int input = Integer.parseInt(st.nextToken());
                    if (input == 1 && !(i == 0 || i == N-1 || j == 0 || j == N-1)) core.add(new int[]{i, j});
                    A[i][j] = input;
                }
            }

            maxCoreCnt = 0;
            minWireLen = Long.MAX_VALUE;
            dfs(0, 0, 0);
            sb.append("#").append(tc).append(" ").append(minWireLen).append("\n");
        }
        System.out.print(sb);
    }
}

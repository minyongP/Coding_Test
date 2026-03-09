package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class im6808 {
    static int[] A = new int[9];
    static int[] B = new int[9];
    static int wCnt;
    static int lCnt;

    static boolean[] v = new boolean[19];

    static void dfs(int depth, int[] arr) {
        if (depth == 9) {
            int a = 0;
            int b = 0;
            for (int i = 0; i < 9; i++) {
                if(A[i] > arr[i]) {
                    a += A[i] + arr[i];
                } else {
                    b += A[i] + arr[i];
                }
            }
            // 승패 확인
            if (a > b) wCnt++;
            else lCnt++;
            return;
        }

        for (int i = 1; i < v.length; i++) {
            if (!v[i]) { // 선택 안한 배열
                // 선택
                v[i] = true;
                arr[depth] = i;
                dfs(depth+1, arr);
                v[i] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            v = new boolean[19];
            for (int i = 0; i < 9; i++) {
                A[i] = Integer.parseInt(st.nextToken());
                v[A[i]] = true;
            }
            Arrays.sort(A);
            int idx = 0;
            for (int i = 1; i <= 18; i++) {
                if (!v[i]) B[idx++] = i;
            }
            Arrays.sort(B);

            wCnt = 0;
            lCnt = 0;
            dfs(0, new int[9]);

            sb.append("#").append(tc).append(" ").append(wCnt).append(" ").append(lCnt).append("\n");
        }
        System.out.println(sb);
    }
}

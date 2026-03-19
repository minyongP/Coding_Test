package datastructure.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2473 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        long[] A = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(A);

        long[] ans = new long[3];
        long minSum = Long.MAX_VALUE;
        for (int i = 0; i < N-1; i++) {
            // i는 한개 고정
            int s = i + 1;
            int e = A.length - 1;
            while(s < e) {
                if (minSum > Math.abs(A[i] + A[s] + A[e])) {
                    minSum = Math.abs(A[i] + A[s] + A[e]);
                    ans[0] = A[i];
                    ans[1] = A[s];
                    ans[2] = A[e];
                }

                if (A[i] + A[s] + A[e] < 0) s++;
                else e--;
            }
        }

        Arrays.sort(ans);
        for (long l : ans) System.out.print(l + " ");

    }
}

package sort.insertion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11399 {
    public static void main(String[] args) throws IOException {
        /*
        * N(사람 수) A(소요 시간 배열)
        * D(합배열)
        * 삽입정렬 실행
        * for(N까지)
        *   합배열 생성
        *   합배열 더하기
        * 값 출력
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] D = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = 0;
        while (st.hasMoreTokens()) {
            A[k] = Integer.parseInt(st.nextToken());
            k++;
        }
        // 선택 정렬
        for (int i = 1; i < N; i++) {
            int target = A[i];
            int j = i-1;
            while (j >= 0 && target < A[j]) {
                A[j + 1] = A[j];
                j--;
            }
            A[j+1] = target;
        }
        // 합배열
        int sum = A[0];
        D[0] = A[0];
        for (int i = 1; i < N; i++) {
            D[i] = D[i-1] + A[i];
            sum += D[i];
        }

        System.out.print(sum);
    }
}
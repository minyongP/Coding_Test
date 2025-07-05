package base;

public class OrderOfPresentation {
    public static void main(String[] args) {
        int output = orderOfPresentation(3, new int[]{2, 3, 1});
        System.out.println(output); // 3

        output = orderOfPresentation(5, new int[]{1, 3, 2, 4, 5});
        System.out.println(output); // 6
    }

    private static int orderOfPresentation(int N, int[] K) {
        /*
         * 순열문제 팩토리얼
         * */
        int[] F = new int[N+1]; // 팩토리얼 배열
        int[] S = new int[N];
        boolean visited[] = new boolean[N+1];
        // 팩토리얼 배열 초기화
        F[0] = 1;
        for (int i = 1; i <= N; i++) {
            F[i] = F[i - 1] * i;
        }

        int idx = 0;    // 인덱스의 위치여서 1이 아닌 0부터
        for (int i = 0; i < N; i++) {
            S[i] = K[i];
            long cnt = 0;
            for (int j = 1; j < S[i]; j++) {
                if (!visited[j]) cnt++;
            }
            idx += cnt * F[N - i - 1];  // 숫자가 올라갈수록 추가되는 팩토리얼
            visited[S[i]] = true;
        }
        return idx;
    }
}

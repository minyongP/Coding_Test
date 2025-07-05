package sort.bubble;

import java.util.Arrays;
import java.util.Scanner;

public class P2750 {
    public static void main(String[] args) {
        /*
        * N(수의 개수)
        * A(수 배열)
        * for(N) 수 배열 저장
        * for(i:N-1까지)
        *   for(j:i~N-1-i까지)
        *       j가 j+1보다 크면 위치 변경
        * 결과 출력
        * */
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
//         버블 정렬
        for (int i = 0; i < N-1; i++) {
            for (int j = 0; j < N-1-i; j++) {
                if (A[j] > A[j+1]) {
                    int tmp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = tmp;
                }
            }
        }
//        Arrays.sort(A);
        for (int i : A) System.out.println(i);
    }
}
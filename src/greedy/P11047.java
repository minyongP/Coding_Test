package greedy;

import java.util.Scanner;

public class P11047 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] A = new int[N];
        int cnt = 0;
        for (int i = 0; i < N; i++) A[i] = scanner.nextInt();
        for (int i = N-1; i >=0; i--) {
            if (K >= A[i]) {
                cnt += K / A[i];
                K %= A[i];
            }
        }
        System.out.println(cnt);
    }
}
/*N(동전개수) K(목표금액)
* A(동전배열)
* for(N) { A배열 초기화 }
* for(N역순){
*   if(현재K > 동전 금액) {
*       동전 수 += K / 현재 동전
*       K = K % 현재 동전
*   }
* }*/

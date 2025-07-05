package datastructure.twopointer;

import java.util.Scanner;

public class P2018 {
    public static void main(String[] args) {
        /*
        * N(자연수 합), result(경우의 수)
        * D(합배열)
        * while(e<=N){
        *   e-s가 N이면 result++ e++ 낮으면 e++ 높으면 s++
        * }
        * 결과 반환
        * */
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] D = new int[N+1];
        for (int i = 1; i < D.length; i++) D[i] = D[i-1] + i;
        int result = 0;
        int s = 0, e = 1;
        while (e <= N) {
            if (D[e] - D[s] < N) e++;
            else if (D[e] - D[s] > N) s++;
            else {
                result++;
                e++;
            }
        }
        System.out.println(result);
    }
}
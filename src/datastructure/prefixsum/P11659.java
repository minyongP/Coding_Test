package datastructure.prefixsum;
/*
N(수의 개수) M(질문 횟수) 저장
for(N 만큼 반복)
    합 배열 생성(S[i] = S[i-1] + A[i])
for(M 만큼 반복)
    구간합 범위 받기(s, e)
    구간합 출력(S[j]-S[i])
*/

import java.util.Scanner;

public class P11659 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] A = new int[N+1];
        long[] S = new long[N+1];
        for (int i = 1; i < A.length; i++) A[i] = scanner.nextInt();
        for (int i = 1; i < A.length; i++) S[i] = S[i-1] + A[i];
        for (int i = 0; i < M; i++) {
            int s = scanner.nextInt();
            int e = scanner.nextInt();
            System.out.println(S[e] - S[s-1]);
        }
    }
}
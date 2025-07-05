package datastructure.prefixsum;

import java.util.Scanner;

public class P10986 {
    public static void main(String[] args) {
        /*
        * N(입력개수), M(나누어 떨어질 수)
        * S(합 배열) , C(같은 나머지의 인덱스를 카운트 배열)
        * for(1~N){
        *   합배열 저장
        * }
        * for(0~N){
        *   합배열M으로 나눈 값으로 갱신
        *   S[i]==0이면 정답 1 증가
        *   C[S[i]]++
        * }
        * for(0~M){
        *   C[i]개 중 2개를 뽑는 경우의 수 계산해 정답 덧셈
        * */
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        long[] S = new long[N];
        long[] C = new long[M];
        long answer = 0;

        S[0] = scanner.nextInt();
        for (int i = 1; i < N; i++) {
            S[i] = S[i-1] + scanner.nextInt();
        }

        for (int i = 0; i < N; i++) {
            S[i] = (int) (S[i] % M);
            if (S[i] == 0) answer++;
            C[(int) S[i]]++;
        }

        for (int i = 0; i < M; i++) {
            if (C[i] > 1) answer += (C[i] * (C[i] - 1) / 2);
        }
        System.out.println(answer);
    }
}
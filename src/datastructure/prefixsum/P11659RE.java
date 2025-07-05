package datastructure.prefixsum;
/*

N(수의 개수) M(질문 횟수) 저장
for(N 만큼 반복)
    합 배열 생성(S[i] = S[i-1] + A[i])
for(M 만큼 반복)
    구간합 범위 받기(s, e)
    구간합 출력(S[j]-S[i])
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P11659RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] A = new long[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < A.length; i++) A[i] = A[i-1] + Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            System.out.println(A[e] - A[s-1]);
        }
    }
}
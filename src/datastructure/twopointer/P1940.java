package datastructure.twopointer;

import java.util.Arrays;
import java.util.Scanner;

public class P1940 {
    public static void main(String[] args) {
        /*
        * N(재료 개수), M(필요 재료 수)
        * cnt(정답)
        * A(재료 배열)
        * 배열 오름차순 정렬
        * while(s<e){
        *   if(합이 작을때) s++
        *   if(합이 클때) e--
        *   else cnt++, s++, e--
        * }
        * 정답 반환
        * */
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) A[i] = scanner.nextInt();
        Arrays.sort(A);
        int s = 0, e = N-1, cnt = 0;
        while (s < e) {
            if (A[s] + A[e] < M) s++;
            else if (A[s] + A[e] > M) e--;
            else {
                cnt++;
                s++;
                e--;
            }
        }
        System.out.println(cnt);
    }
}
package datastructure.twopointer;

import java.util.Arrays;
import java.util.Scanner;

public class P1253 {
    public static void main(String[] args) {
        /*
         * N(수의 개수)
         * A(수 배열)
         * for(0~N){
         *  배열에 수 저장
         * }
         * 배열 정렬
         * for(0~N){
         *   s = 0, e = N-1
         *   while(s<e){
         *       if(합이 A[i]보다 작을때) s++
         *       else if(합이 A[i]보다 클때) e--
         *       else {
         *          if(s == i) s++
         *          else if(e == i) e--
         *          else cnt++, s++, e--
         *   }
         * }
         * 정답반환
         * */
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < A.length; i++) {
            A[i] = scanner.nextInt();
        }
        Arrays.sort(A);
        int cnt = 0;
        for (int i = 0; i < A.length; i++) {
            int s = 0, e = N - 1;
            while (s < e) {
                if (A[s] + A[e] < A[i]) s++;
                else if (A[s] + A[e] > A[i]) e--;
                else {
                    if (s == i) s++;
                    else if (e == i) e--;
                    else {
                        cnt++;
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
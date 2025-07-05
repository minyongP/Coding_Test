package binarysearch;

import java.util.Scanner;

public class P1300 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        long s = 1, e = K;
        long ans = 0;
        while(s<=e) {
            long m = (s+e)/2;
            long cnt = 0;
            for (int  i = 1; i < N+1; i++) {
                cnt += Math.min(m/i, N);
            }
            if (cnt<K) s = m+1;
            else {
                ans = m;
                e = m-1;
            }
        }
        System.out.println(ans);
    }
}
/*
* N(배열크기) K(찾는 index)
* while(s<=e){
*   for(N){ cnt에 중앙 인덱스를  i로 나눈 값과 N중 작은 값을 더함 }
*   if(cnt<K) { s=m+1 }
*   else{ e=m-1, 정답에 중앙값 저장 }
* }*/
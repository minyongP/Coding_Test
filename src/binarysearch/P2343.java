package binarysearch;

import java.util.Scanner;

public class P2343 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] A = new int[N];
        int s = 0;
        int e = 0;
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
            if(s < A[i]) s = A[i];
            e += A[i];
        }
        while (s <= e) {
            int mid = (s + e) / 2;
            int sum = 0;
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if(sum + A[i] > mid) {
                    cnt++;
                    sum = 0;
                }
                sum += A[i];
            }
            if(sum != 0) cnt++;
            if(cnt > M) s = mid+1;
            else e = mid-1;
        }
        System.out.println(s);
    }
}
/*
* N(강의 수) M(블루레이 수)
* A(강의 배열)
* s(강의 최대 값) e(강의 구간 합)
* for(N){ A 초기화 }
* while(s <= e) {
*   mid(중간 인덱스)
*   sum(구간 합)
*   cnt(현재 블루레이 개수)
*   for(N){
*       if(sum + 현재 강의 시간 > 중간 값) { cnt++, sum=0 }
*       sum + 현재 강의 시간
*   }
* if(sum != 0) { cnt++ }
* if(cnt > M) s = m+1
* else e = m-1
* }
* s 출력
* */
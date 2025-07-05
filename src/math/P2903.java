package math;

import java.util.Scanner;
/*
N(반복 횟수) P(초기 점의 수열)
A(0~15까지 점의 개수 배열)
for(배열 크기)
    수열 이용하여 점의 개수 입력
A[N] 출력
-----
점의 개수는
0번은 2^2
1번은 3^2
2번은 5^2
3번은 9^2
4번은 수열상 17^2
n번은 (2(n-1번째의 P)-1)^2
*/
public class P2903 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int N = scanner.nextInt();
        int[] A = new int[16];
        int P = 2;
        for (int i = 1; i < A.length; i++) {
            P = P*2-1;
            A[i] = (int) Math.pow(P, 2);
        }
        System.out.println(A[N]);
    }
}
package math;

import java.util.Scanner;

/*
T(테스트 개수) C(거스름돈)
A(거스름돈 개수 배열)
for(테스트 개수만큼)
    C입력
    while(C == 0)
        for(A에 0 ~ 3 까지)
            A에 25, 10, 5, 1나눈 몫 입력
            C에 나머지 값 저장
    배열 출력
*/
public class P2720 {
    public static void main(String[] args) {
        int[] unit = {25, 10, 5, 1};
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int C = scanner.nextInt();
            int[] A = new int[4];
            int j = 0;
            while (C != 0) {
                A[j] = C / unit[j];
                C %= unit[j];
                j++;
            }
            for (int a : A) System.out.print(a + " ");
            System.out.println();
        }
    }
}
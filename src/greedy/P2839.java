package greedy;

import java.util.Scanner;
/*
5로 나눈 나머지를 들을 배열에 저장
가장 작은 3의 배수를 선택 없다면 -1
 */
public class P2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int ans = 0;
        int[] arr = new int[(N/5) + 1];
        arr[0] = N;

        for (int i = 1; i <= N/5; i++) {
            arr[i] = N - (5 * i);
        }

        boolean check = false;
        for (int i = arr.length-1; i >= 0; i--) {
            if (arr[i] % 3 == 0) {
                check = true;
                ans += i;
                ans += arr[i] / 3;
                break;
            }
        }

        if (check) {
            System.out.println(ans);
        } else System.out.println(-1);
    }
}

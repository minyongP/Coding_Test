package sort;

import java.util.Arrays;
import java.util.Scanner;

public class 수_정렬하기2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);
        for (int i = 0; i < N; i++) {
            System.out.println(A[i]);
        }
    }
}

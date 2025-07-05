package sort.selection;

import java.util.Scanner;

public class P1427 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char[] c = str.toCharArray();
        int[] A = new int[c.length];
        for (int i = 0; i < A.length; i++) A[i] = c[i] - '0';
        for (int i = 0; i < A.length; i++) {
            int max = i;
            for (int j = i+1; j < A.length; j++) {
                if (A[j] > A[max]) max = j;
            }
            int tmp = A[i];
            A[i] = A[max];
            A[max] = tmp;
        }
        for (int a : A)
        System.out.print(a);
    }
}
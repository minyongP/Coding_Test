package sort.selection;

import java.util.Scanner;

public class P1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] A = new int[s.length()];
        for (int i = 0; i < s.length(); i++) A[i] = s.charAt(i) - '0';

        for (int i = 0; i < A.length - 1; i++) {
            int max = A[i];
            int idx = i;
            for (int j = i+1; j < A.length; j++) {
                if (max < A[j]) {
                    max = A[j];
                    idx = j;
                }
            }
            int temp = A[i];
            A[i] = A[idx];
            A[idx] = temp;
        }
        for (int i : A) System.out.print(i);;
    }
}
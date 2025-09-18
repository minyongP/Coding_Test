package bruteForce;

import java.util.Scanner;

public class P25643 {
    static int M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        M = sc.nextInt();
        String[] A = new String[N];
        for (int i = 0; i < N; i++){
            A[i] = sc.next();
        }

        for (int i = 0; i < N-1; i++) {
            if (!canBuild(A[i], A[i+1])) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }

    // 새로 쌓을 블록을 기존 블록의 왼쪽부터 밀어 넣어보거나 오른쪽부터 밀어 넣어보기
    private static boolean canBuild(String s1, String s2) {
        for (int i = 1; i <= M; i++) {
            if (s1.substring(M-i).equals(s2.substring(0,i))) return true;
            if (s2.substring(M-i).equals(s1.substring(0,i))) return true;
        }
        return false;
    }
}



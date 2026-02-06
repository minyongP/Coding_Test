import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int test_case = 1; test_case <= 10; test_case++) {
            st = new StringTokenizer(br.readLine());
            int[][] A = new int[100][100];

            int ans = 0;
            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    int temp = Integer.parseInt(st.nextToken());
                    if (temp == 2) ans = j;
                    A[i][j] = temp;
                }
            }

            int i = 99;
            while (i > 1) {
                if (ans > 1 && A[i][ans - 1] == 1) {
                    while (ans > 1 && A[i][ans - 1] != 0) {
                        ans--;
                    }
                    i--;
                } else if (ans < 99 && A[i][ans + 1] == 1) {
                    while (ans < 99 && A[i][ans + 1] != 0) {
                        ans++;
                    }
                    i--;
                } else i--;
            }

            System.out.println("#" + test_case + " " + ans);
        }
    }
}
package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] A = input.split("\\-");

        String[] plus = A[0].split("\\+");
        int ans = Arrays.stream(plus).mapToInt(Integer::parseInt).sum();

        for (int i = 1; i < A.length; i++) {
            String[] minus = A[i].split("\\+");
            ans -= Arrays.stream(minus).mapToInt(Integer::parseInt).sum();
        }

        System.out.println(ans);
    }
}

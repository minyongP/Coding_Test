package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] N = String.valueOf(st.nextToken()).toCharArray();
        int [] base = new int[N.length];
        int B = Integer.parseInt(st.nextToken());
        long result = 0;
        int power = 1;

        for (int i = 0; i < N.length; i++) {
            if (48 <= N[i] && N[i] <= 57) base[i] = N[i] - 48;                // 0~9일때
            else base[i] = N[i] - 55;               // A~Z일때, A = 10
        }
        // B진법 to 10진법
        result += base[N.length-1];
        for (int i = N.length-2; i >= 0; i--) {

            int pow = (int) Math.pow(B, power);
            result += base[i] * pow;
            power++;
        }

        System.out.println(result);
    }
}
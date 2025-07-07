package base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class P1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<Character> set = new HashSet<>();
        int ans = N;

        for (int i = 0; i < N; i++) {
            char[] c = br.readLine().toCharArray();
            boolean isGroupWord = true;
            set.add(c[0]);

            for (int j = 1; j < c.length; j++) {
                if (c[j] != c[j-1] && set.contains(c[j])) {
                    isGroupWord = false;
                }
                else {
                    set.add(c[j]);
                }
            }

            if (!isGroupWord) {
                ans--;
            }
            set.clear();
        }

        System.out.println(ans);
    }
}

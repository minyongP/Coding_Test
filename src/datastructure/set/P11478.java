package datastructure.set;

import java.util.*;

public class P11478 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        // hashSet을 이용하여 자동 중복 제거
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < S.length(); i++) {
            for (int j = S.length(); j > i; j--) {
                set.add(S.substring(i, j));
            }
        }

        System.out.println(set.size());
    }
}

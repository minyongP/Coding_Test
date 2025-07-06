package sort;

import java.util.*;

public class P1181 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        HashSet<String> hashSet = new HashSet<>();

        for (int i = 0; i < N; i++) {
            hashSet.add(sc.nextLine());
        }

        ArrayList<String> A = new ArrayList<>(hashSet);

        A.sort((s1, s2) -> {
            if (s1.length() == s2.length()) {
                return s1.compareTo(s2);
            } else {
                return Integer.compare(s1.length(), s2.length());
            }
        });

        for (String s : A) {
            System.out.println(s);
        }
    }
}

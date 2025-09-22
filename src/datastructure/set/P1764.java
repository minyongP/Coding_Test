package datastructure.set;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P1764 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) set.add(sc.next());

        Set<String> ans = new TreeSet<>();
        for (int i = 0; i < M; i++) {
            String s = sc.next();
            if (set.contains(s)) ans.add(s);
        }
        System.out.println(ans.size());
        for (String s : ans) System.out.println(s);
    }
}

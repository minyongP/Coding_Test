package datastructure.set;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P3052 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) set.add(Integer.parseInt(sc.next())%42);
        System.out.println(set.size());
    }
}

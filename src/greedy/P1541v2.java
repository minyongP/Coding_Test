package greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1541v2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Long> list = new ArrayList<>();
        for (String s : sc.nextLine().split("-")) {
            String[] A = s.split("\\+");
            long sum = 0;
            for (int i = 0; i < A.length; i++) sum += Integer.parseInt(A[i]);
            list.add(sum);
        }
        long ans = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            ans -= list.get(i);
        }
        System.out.println(ans);
    }
}

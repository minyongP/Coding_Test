package datastructure.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P11866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        int k = sc.nextInt();

        String ans = "<";

        while (!q.isEmpty()) {
            for (int i = 1; i < k; i++) {
                q.add(q.poll());
            }
            ans += String.valueOf(q.poll()) + ", ";

        }
        ans = ans.substring(0, ans.length() - 2) + ">";
        System.out.println(ans);
    }
}

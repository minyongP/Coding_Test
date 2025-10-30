package datastructure.deque;

import java.util.*;
import java.util.stream.Collectors;

public class P13417 {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        StringTokenizer st;
        Deque<String> deque;
        int T = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= T; i++) {
            sc.nextLine();
            deque = new ArrayDeque<>();
            st = new StringTokenizer(sc.nextLine());
            deque.add(st.nextToken());
            while (st.hasMoreTokens()) {
                String token = st.nextToken();
                if (deque.peekFirst().charAt(0) >= token.charAt(0)) deque.addFirst(token);
                else deque.addLast(token);
            }

            System.out.println(deque.stream().map(String::valueOf).collect(Collectors.joining()));
        }

    }
}

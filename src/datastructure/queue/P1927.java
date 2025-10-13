package datastructure.queue;

import java.util.*;

public class P1927 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int fir = Math.abs(o1);
            int sec = Math.abs(o2);
            if (fir == sec) return o1 > o2 ? 1: -1;
            else return fir - sec;
        });
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int input = sc.nextInt();
            if (input == 0) {
                if (pq.isEmpty()) System.out.println("0");
                else System.out.println(pq.poll());
            }
            else pq.add(input);
        }
    }
}

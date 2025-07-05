package datastructure.queue;

import java.util.PriorityQueue;
import java.util.Scanner;

public class P11286 {
    public static void main(String[] args) {
        /*
        * N(연산의 개수)
        * pq(절댓값 기준으로 정렬, 절댓값이 같으면 음수 우선)
        * for(N만큼 반복){
        *   if(input == 0){
        *       if(isEmpty) 0 반환
        *       else poll 반환
        *   }
        *   else{
        *       add
        *   }
        * }
        * */
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int fir = Math.abs(o1);
            int sec = Math.abs(o2);
            if (fir == sec) return o1 > o2 ? 1: -1;
            else return fir - sec;
        });
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            int input = scanner.nextInt();
            if (input == 0) {
                if (pq.isEmpty()) System.out.println("0");
                else System.out.println(pq.poll());
            }
            else pq.add(input);
        }
    }
}
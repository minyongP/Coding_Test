package datastructure.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1158 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        Queue<Integer> queue = new LinkedList<>();
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        for (int i = 1; i < N+1; i++) queue.add(i);

        sb.append("<");

        while (!queue.isEmpty()) {
            for (int i = 1; i < K; i++) queue.add(queue.poll());
            sb.append(queue.poll() + ", ");
        }

        sb.delete(sb.length()-2, sb.length()); // 마지막 ,제거
        sb.append(">");

        System.out.println(sb);
    }
}
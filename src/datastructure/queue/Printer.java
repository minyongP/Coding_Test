package datastructure.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Printer {
    public static void main(String[] args) {
        int bufferSize = 2;
        int capacities = 10;
        int[] documents = new int[]{7, 4, 5, 6};

        int output = queuePrinter(bufferSize, capacities, documents);
        System.out.println(output); // 8
    }

    private static int queuePrinter(int bufferSize, int capacities, int[] documents) {
        Queue<Integer> queue = new LinkedList<>();
        int time = 0;
        // 큐 크기 초기화
        for (int i = 0; i < bufferSize; i++) queue.add(0);

        while (documents.length != 0 || !queue.isEmpty()) {   // 배열과 큐가 남았을 경우
            if (documents.length != 0) { // 배열이 남았을때
                queue.poll();   // 1번큐를 제외하고
                // 2번 큐와 새 큐의 합이 한도보다 작을 경우
                if (capacities >= queue.stream().reduce(0, Integer::sum) + documents[0]) {
                    time++;
                    queue.add(documents[0]);
                    documents = Arrays.copyOfRange(documents, 1, documents.length);
                } else { // 한도초과일 경우
                    time++;
                    queue.add(0);
                }
            } else { // 배열이 없을 때 큐 정리
                time++;
                queue.poll();
            }
        }
        return time;
    }
}
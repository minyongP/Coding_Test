package greedy;

import java.util.PriorityQueue;
import java.util.Scanner;

public class P1715 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add(scanner.nextInt());
        }
        int data1 = 0, data2 = 0, sum = 0;
        while (pq.size() != 1) {
            data1 = pq.remove();
            data2 = pq.remove();
            sum += data1 + data2;
            pq.add(data1 + data2);
        }
        System.out.println(sum);
    }
}

/*
* 카드 뭉치 중 작은 거 2개 선택 -> 합친 후 다시 정렬 - 한묶음 남을때까지 반복
* N(카드 묶음 수)
* pq(우선순위 큐)
* for(N) pq에 데이터 저장
* while(pq >= 1) {
*   카드 뭉치 중 작은 거 2개 선택(remove)
*   두 값을 합친 값을 누적 값에 더함
*   합친 값을 pq에 넣음(add)
* }
* 누적 값 출력
 * */
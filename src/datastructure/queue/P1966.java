package datastructure.queue;

import java.util.*;
public class P1966 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0){
            int N = sc.nextInt();
            int M = sc.nextInt();
            int cnt = 0;
            Queue<int[]> queue = new LinkedList<>();
            // 인덱스가 섞이지 않게 인덱스와 중요도를 배열로 삽입
            for (int j = 0; j < N; j++) queue.add(new int[] {j,sc.nextInt()});

            while (true) {
                int now[] = queue.poll();
                boolean flag = true;

                for (int q[] : queue) {
                    if(q[1] > now[1]) {     // 뽑은 값보다 큰 중요도가 존재 (1)
                        flag = false;
                        break;
                    }
                }

                if(flag) {                  // 뽑은 값보다 큰 중요도가 존재 X (2)
                    cnt++;                  // 순서 증가
                    if(now[0] == M) break;  // 만약 찾는 인덱스와 같으면 while탈출
                }else {                     // 큰 중요도 존재 (1)
                    queue.add(now);         // 큐 뒤에 다시 삽입
                }
            }
            System.out.println(cnt);
        }
    }
}
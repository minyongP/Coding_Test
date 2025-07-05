package datastructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//배열로 받는다
//정렬한다
//원하는 큐의 숫자를 받아온다
//배열과 비교해 몇번째 인덱스인지 가져온다
//+1해서 출력한다
public class P1966H {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int test = Integer.parseInt(st.nextToken());

        for (int i = 0; i < test; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            Integer[] A = new Integer[N];
            int find = 0;

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[j] = Integer.parseInt(st.nextToken());
                queue.add(A[j]);
            }
            Arrays.sort(A, Collections.reverseOrder()); // 내림차순은 배열을 Integer로 선언
            // 찾을 인덱스
            find = queue.poll();
            for (int j = 0; j < M; j++) find = queue.poll();

            for (int j = 0; j < A.length; j++) {
                if (A[j] == find) {
                    System.out.println(j+1);
                    break;
                }
            }
        }
    }
}
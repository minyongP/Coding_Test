package datastructure.slidingwindow;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P11003 {
    public static void main(String[] args) throws IOException {
        /*
        * N(숫자 개수) L(쵯솟값 구하는 범위)
        * Deque<Node> deque(범위를 담을 덱)
        *
        * for(N만큼 반복){
        *  now(현재 값)
        *   덱의 마지막 위치에서 now보다 큰 값은 덱에서 제거
        *   덱의 마지막 위치에 now값 저장
        *   덱의 1번째 위치부터 L의 범위를 벗어난 값(now index-L <= index)를 덱에서 제거
        *   덱에서 1번째 데이터 출력
        * }
        *
        * 덱에 저장할 노드 클래스 생성
        * 노드 클래스에는 index(자신의 위치), value(자신의 값) 담기
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Deque<Node> deque = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());
            // 만약 덱의 마지막 값보다 새로운 값이 더 작으면 대체
            while (!deque.isEmpty() && deque.getLast().value > now) {
                deque.removeLast();
            }
            deque.addLast(new Node(now, i));
            // 범위에서 벗어나면 첫번째 삭제
            if (deque.getFirst().index < i - L + 1) {
                deque.removeFirst();
            }
            bw.write(deque.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }
    private static class Node {
        int value;
        int index;

        Node (int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
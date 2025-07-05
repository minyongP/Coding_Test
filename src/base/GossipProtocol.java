package base;

import java.util.Arrays;

public class GossipProtocol {
    public static void main(String[] args) {
        String[] village = new String[]{
                "0101", // 첫 번째 줄
                "0111",
                "0110",
                "0100",
        };
        int row = 1;
        int col = 2;
        int output = gossipProtocol(village, row, col);
        System.out.println(output); // --> 3

/*1. 시작: (1, 2)에서 시작, 소문이 퍼진 곳을 x로 표기
 [
  "0101",
  "01x1",
  "0110",
  "0100",
 ]

2. 1일 뒤
 [
  "0101",
  "0xxx",
  "01x0",
  "0100",
 ]

3. 2일 뒤
 [
  "0x0x",
  "0xxx",
  "0xx0",
  "0100",
 ]

4. 3일 뒤: 소문이 전부 퍼짐 (끝)
 [
  "0x0x",
  "0xxx",
  "0xx0",
  "0x00",
 ]*/
    }

    // 순환 큐에서 사용할 변수를 필드변수로 선언한다.
    static int front = 0;
    static int rear = 0;
    static int[][] queue;

    public static int gossipProtocol(String[] village, int row, int col) {
        // bfs 구현을 위해 큐를 선언한다.
        // enQueue, deQueue시마다 인덱싱을 다시 하지 않기 위해
        // 순환 큐(circular queue)로 구현한다.
        // queue의 가능한 최대 크기만큼 배열을 선언한다.
        // 문제의 특성에 따라 큐에는 좌표 평면의 한 점이 삽입되고, 한번 삽입된 요소는 두 번 다시 삽입되지 않는다.
        int R = village.length;
        int C = village[0].length();
        int[][] matrix = createMatrix(village);
        int[][] MOVES = new int[][]{
                {-1, 0},  // UP
                {1, 0},   // DOWN
                {0, 1},   // RIGHT
                {0, -1}   // LEFT
        };

        int MAX_SIZE = R * C;
        queue = new int[MAX_SIZE][];
        int cnt = 0;
        enQueue(queue, new int[]{row, col}, MAX_SIZE);

        // 소문이 퍼지는 데 걸리는 시간을 저장한다.
        matrix[row][col] = 0;
        while (isEmpty()) {
            // 큐의 가장 앞 자리의 좌표를 얻는다.
            int[] pos = deQueue(queue, MAX_SIZE);
            row = pos[0];
            col = pos[1];
            cnt = matrix[row][col];

            // 현재 지점을 기준으로 네 방향을 검토한다.
            for(int[] move : MOVES) {
                int rDiff = move[0];
                int cDiff = move[1];
                int nextRow = row + rDiff;
                int nextCol = col + cDiff;
                if(isValid(nextRow, nextCol, R, C) && matrix[nextRow][nextCol] == 1) {
                    enQueue(queue, new int[]{nextRow, nextCol}, MAX_SIZE);
                    matrix[nextRow][nextCol] = matrix[row][col]+ 1;
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        return cnt;
    }
    public static void enQueue(int[][] queue, int[] pos, int MAX_SIZE) {
        // 실행 중에 큐가 가득차지는 않기 때문에 별도의 조건문을 작성할 필요가 없다.
        queue[rear] = pos;
        // 모듈러스 연산을 할 필요도 사실 없다.
        rear = (rear + 1) % MAX_SIZE;
    }
    public static boolean isEmpty() {
        return front != rear;
    }

    public static int[] deQueue(int[][] queue, int MAX_SIZE) {
        int[] pos = queue[front];
        front = (front + 1) % MAX_SIZE;
        return pos;
    }

    public static boolean isValid(int row, int col, int R, int C) {
        return row >= 0 && row < R && col >= 0 && col < C;
    }

    public static int[][] createMatrix(String[] village) {
        int[][] matrix = new int[village.length][];
        for(int i = 0; i < village.length; i++) {
            String str = village[i];
            int[] row = new int[str.length()];
            for(int j = 0; j < str.length(); j++) {
                row[j] = Character.getNumericValue(str.charAt(j));
            }
            matrix[i] = row;
        }
        return matrix;
    }
}
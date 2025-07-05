package base;

import java.util.LinkedList;
import java.util.Queue;

public class RobotPath {
    public static void main(String[] args) {
        int[][] room = new int[][]{
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 1, 0},
                {0, 1, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 0}
        };
        int[] src = new int[]{4, 2};
        int[] dst = new int[]{2, 2};
        int output = robotPath(room, src, dst);
        System.out.println(output); // --> 8
    }

    private static int robotPath(int[][] room, int[] src, int[] dst) {
        int result = Integer.MAX_VALUE;
        int N = room[0].length; // 가로
        int M = room.length;    // 세로
        // 위 오른쪽 아래 왼쪽
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        boolean[][] visited = new boolean[M][N];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src[1], src[0]});    // 시작 지점
        visited[src[0]][src[1]] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            if (x == dst[1] && y == dst[0]) {
                result = Math.min(result, room[y][x]);
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (room[ny][nx] == 0 && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        room[ny][nx] = room[y][x] + 1;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return result;
    }
}
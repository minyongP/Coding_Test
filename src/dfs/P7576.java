package dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Tomato {
    int x;
    int y;
    int day;

    public Tomato(int x, int y, int day) {
        this.x = x;
        this.y = y;
        this.day = day;
    }
}
public class P7576 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] days;
    static int[][] boxs;
    static int M, N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        boxs = new int[N][M];
        days = new int[N][M];
        for (int i = 0; i < boxs.length; i++) {
            for (int j = 0; j < boxs[i].length; j++) {
                boxs[i][j] = sc.nextInt();
            }
        }

        int maxdays = bfs(boxs);

        boolean isDone = true;
        for (int[] box : boxs) {
            for (int tomato : box) {
                if (tomato == 0) {
                    isDone = false;
                    break;
                }
            }
            if (!isDone) break;
        }

        if (isDone) System.out.println(maxdays);
        else System.out.println(-1);
    }


    private static int bfs(int[][] boxs) {
        Queue<Tomato> queue = new LinkedList<>();

        for (int y = 0; y < boxs.length; y++) {
            for (int x = 0; x < boxs[y].length; x++) {
                if (boxs[y][x] == 1) {
                    queue.offer(new Tomato(x, y, 0));
                    days[y][x] = 0;
                }
            }
        }

        int maxDays = 0;

        while (!queue.isEmpty()) {
            Tomato current = queue.poll();

            if (current.day > maxDays) {
                maxDays = current.day;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    if (boxs[ny][nx] == 0) {
                        boxs[ny][nx] = 1;
                        days[ny][nx] = current.day + 1;
                        queue.offer(new Tomato(nx, ny, current.day + 1));
                    }
                }
            }
        }
        return maxDays;
    }
}

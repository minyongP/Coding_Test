package dfs;

import java.util.ArrayList;
import java.util.Scanner;

public class P13023 {
    /*
     * 재귀함수의 깊이가 5이상인지 확인
     * N(노드수) M(엣지수)
     * A(인접리스트)
     * visited(방문배열)
     * arrive(요구조건 확인 변수)
     * for(N 반복){배열 초기화}
     * for(M 반복){A에 데이터 저장}
     * for(N 반복){ DFS실행 if(arrive) 반복문종료}
     * if(arrive) 1 else 0 출력
     *
     * DFS{
     * if(깊이가 5 or arrive){arrive = true;} 함수 종료
     * 방문배열에 현재노드 기록
     * 현재노드의 연결노드중 방문하지 않은 노드로 dfs실행(깊이+1)
     * }
     * */

    static boolean visited[];
    static ArrayList<Integer> A[];
    static boolean arrive;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        arrive = false;
        A = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int s = scanner.nextInt();
            int e = scanner.nextInt();
            A[s].add(e);
            A[e].add(s);
        }

        for (int i = 0; i < N; i++) {
            dfs(i, 1);
            if (arrive) break;
        }

        if (arrive) System.out.println("1");
        else System.out.println("0");
    }

    private static void dfs(int now, int depth) {
        if (depth == 5 || arrive) {
            arrive = true;
            return;
        }
        visited[now] = true;
        for (int i : A[now]) {
            if (!visited[i]) {
                dfs(i, depth+1);
            }
        }
        visited[now] = false;
    }
}

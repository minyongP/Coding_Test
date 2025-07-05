package graph;

import java.util.Arrays;

public class AdjMatrix {
    public static void main(String[] args) {
        int[][] output1 = createMatrix(new int[][]{
                {0, 3, 0},
                {0, 2, 0},
                {1, 3, 0},
                {2, 1, 0},
        });
        System.out.println(output1);
/**
 * [
 *  [0, 0, 1, 1],
 *  [0, 0, 0, 1],
 *  [0, 1, 0, 0],
 *  [0, 0, 0, 0]
 * ]
 */
        int[][] output2 = createMatrix(new int[][]{
                {0, 2, 0},
                {2, 4, 1},
                {1, 3, 1},
                {2, 1, 0},
        });

        System.out.println(output2);
/**
 * [
 *  [0, 0, 1, 0, 0],
 *  [0, 0, 0, 1, 0],
 *  [0, 1, 0, 0, 1],
 *  [0, 1, 0, 0, 0],
 *  [0, 0, 1, 0, 0],
 * ]
 */
    }

    public static int[][] createMatrix(int[][] edges) {
        int N = Arrays.stream(edges)
                .flatMapToInt(Arrays::stream)
                .max()
                .getAsInt();
        int[][] result = new int[N+1][N+1];

        for (int[] edge : edges) {
            result[edge[0]][edge[1]] = 1;                   // s->e
            if (edge[2] == 1) result[edge[1]][edge[0]] = 1; // 양방향일 경우 e->s
        }

        return result;
    }


//    public static int[][] createMatrix(int[][] edges) {
//        int[][] graph;
//
//        // 행렬의 크기를 구합니다.
//        // edgesLength 변수를 0으로 할당하고, edges를 전부 순회해 제일 큰 숫자를 max에 할당합니다.
//        // edgesLength 크지 않을 경우엔 바꾸지 않습니다.
//        int edgesLength = 0;
//
//        for (int i = 0; i < edges.length; i++) {
//            for (int j = 0; j < edges[i].length; j++) {
//                if (edgesLength < edges[i][j]) edgesLength = edges[i][j];
//            }
//        }
//        // matrix의 뼈대를 잡습니다.
//        // max로 구한 최대값에 1을 더하여 array를 생성합니다.(0번째부터 있기 때문입니다)
//        // 자동으로 모든 배열의 요소는 0으로 만들어집니다.
//        graph = new int[edgesLength + 1][edgesLength + 1];
//
//        // edges를 순회하며 무향인 곳엔 각각의 간선에 1로 바꾸어 주고, 방향이 있는 간선엔 해당 간선에만 1로 바꾸어 줍니다.
//        // 만약, [0, 3, 0]가 들어왔다면,
//        // 만들어 둔 result의 0 번째 row에 3 번째 col에 1을 추가합니다.
//        // [ 0, 0, 0, 1 ] => 0번째 버텍스가 갈 수 있는 간선 중, 3 번으로 가는 간선만 갈 수 있습니다.
//        for(int i = 0; i < edges.length; i++) {
//            int from = edges[i][0];
//            int to = edges[i][1];
//            int direction = edges[i][2];
//            //일시 방향일 경우
//            if(direction == 0) graph[from][to] = 1;
//                //일시 무향일 경우
//            else if(direction == 1) {
//                graph[from][to] = 1;
//                graph[to][from] = 1;
//            }
//        }
//        return graph;
//    }
}

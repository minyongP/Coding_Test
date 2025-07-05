package graph;

import java.util.Arrays;

public class Pathfinding {
    public static void main(String[] args) {
        boolean result = getDirections(new int[][]
                        {
                                {0, 1, 0, 0},
                                {0, 0, 1, 0},
                                {0, 0, 0, 1},
                                {0, 1, 0, 0}
                        },
                0,
                2
        );
        System.out.println(result); // true
// 정점 0에서 2로 가는 길이 존재하는지 확인합니다.
// 0 --> 1 로 가는 간선이 존재하고, 1 --> 2 로 가는 간선이 존재하기 때문에 true를 반환합니다.

        boolean result2 = getDirections(new int[][]
                        {
                                {0, 1, 0, 0, 0},
                                {0, 0, 0, 1, 0},
                                {0, 1, 0, 0, 0},
                                {0, 1, 1, 0, 0},
                                {1, 1, 1, 1, 0}
                        },
                1,
                4
        );
        System.out.println(result2); // false

// 정점 1에서 4로 가는 길이 존재하는지 확인합니다.
// 1 --> 3,
// 3 --> 1 (정점 1을 다녀왔으니 다시 돌아가지 않습니다),
// 3 --> 2,
// 2 --> 1 (정점 1을 다녀왔으니 다시 돌아가지 않습니다)
// ...으로, 4에 도달할 수 없습니다.
    }

    private static boolean getDirections(int[][] matrix, int from, int to) {
        int[][] newMatrix = Arrays.stream(matrix).map(int[]::clone).toArray(int[][]::new);  // 매트릭스 복제
        if(newMatrix[from][to] == 1) return true;   // 바로 갈 수 있으면 true
        for(int i = 0; i < newMatrix[from].length; i++) {
            if (newMatrix[from][i] == 1) {  //  BFS
                newMatrix[from][i] = 0;     //  무한 순회를 막기 위해 visited
                if(getDirections(newMatrix, i, to)) return true;    // BFS재귀
            }
        }
        return false;
    }

//    public static boolean getDirections(int[][] matrix, int from, int to) {
//        //2차원 배열을 선언합니다.
//        int[][] currentMatrix = new int[matrix.length][];
//        for(int i = 0; i < matrix.length; i++) currentMatrix[i] = Arrays.copyOf(matrix[i], matrix[i].length);
//        //입력된 출발점과 도착점이 같다면 true를 반환합니다 (재귀 함수의 도착 부분)
//        if(from == to) return true;
//
//        // 입력된 출발지점의 1차원 배열을 순회합니다.
//        for(int i = 0; i < currentMatrix[from].length; i++) {
//            //길이 존재한다면
//            if(currentMatrix[from][i] == 1) {
//                //해당 루트를 순회했다고 표시합니다( 1 -> 0으로 변경)
//                currentMatrix[from][i] = 0;
//                //표시된 행렬과, 출발지점을 현재 지점인 i로 변경하여 재귀함수를 실행합니다. 재귀함수가 끝까지 도달하였을때 true를 반환한 경우 true를 반환합니다.
//                if(getDirections(currentMatrix, i, to)) return true;
//            }
//        }
//        //길을 찾을수 없는 경우 false를 반환합니다.
//        return false;
//    }
}

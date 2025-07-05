package base;

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int K = 2; // 시계 방향으로 K번 회전

        System.out.println(matrix[0][0]); // --> 1
        System.out.println(matrix[3][2]); // --> 15

        int[][] rotatedMatrix = rotateMatrix(matrix, K);
        System.out.println(rotatedMatrix[0][0]); // --> 13
        System.out.println(rotatedMatrix[3][2]); // --> 8
    }

    private static int[][] rotateMatrix(int[][] matrix, int K) {
//        K %= 4; // 4번돌면 원상태
//        if (matrix == null || K == 0) return matrix;
//        // 회전 수에 따라 가로 세로 길이 변화
//        int[][] result = K % 2 == 0 ?
//                new int[matrix.length][matrix[0].length] : new int[matrix[0].length][matrix.length];
//        while (K != 0) {
//            for (int i = 0; i < matrix.length; i++) {
//                for (int j = 0; j < matrix[i].length; j++) {
//                    result[j][matrix.length - 1 - i] = matrix[i][j];
        // 한번씩 회전시키면 배열의 가로 세로를 계속 초기화 해줘야해서 조건문으로 1,2,3 회전을 하는게 맞다
//                }
//            }
//            matrix = result;
//            K--;
//        }
//        return result;
        if (matrix == null) return matrix;
        K %= 4; // 4번돌면 원상태
        int N = matrix.length;
        int M = matrix[0].length;
        // 회전 수에 따라 가로 세로 길이 변화
        int[][] result = K % 2 == 0 ?
                new int[N][M] : new int[M][N];
        for(int i = 0; i < result.length; i++) {
            for(int j = 0; j < result[i].length; j++) {
                if(K == 1) {
                    result[i][j] = matrix[N - j - 1][i];
                } else if(K == 2) {
                    result[i][j] = matrix[N - i - 1][M - j - 1];
                } else {
                    result[i][j] = matrix[j][M - i - 1];
                }
            }
        }
        return result;
    }
}
package greedy;

public class BoardGame {
    public static void main(String[] args) {
        int[][] board1 = new int[][]{
                {0, 0, 0, 1},
                {1, 1, 1, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 0}
        };
        Integer output1 = boardGame(board1, "RRDLLD");
        System.out.println(output1); // 4


        int[][] board2 = new int[][]{
                {0, 0, 1},
                {1, 1, 1},
                {1, 0, 0}
        };
        Integer output2 = boardGame(board2, "UUUDD");
        System.out.println(output2); // null

        int[][] board3 = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0}
        };
        Integer output3 = boardGame(board3, "DDRRRUDUDUD");
        System.out.println(output3); // 0
    }

    private static Integer boardGame(int[][] board, String operation) {
        /*
        * player[](게임말 좌표 0,0 세로가로), point(게임 점수)
        * A[](조작이 들어갈 캐릭터 배열)
        * for(A크기){
        *   if(말이 판 밖으로 나가면) null반환
        *   swich(A[i]){
        *       조작만큼 게임말 좌표를 이동한다.
        *       게임말 좌표의 점수를 더한다
        *   }
        * 점수 반환
        * }
        * */

        int point = board[0][0];    //시작지점 점수
        int[] player = {0, 0};
        char[] command = operation.toCharArray();
        for (int i = 0; i < command.length; i++) {
            switch (command[i]) {
                case 'U': {
                    player[0]--;
                    break;
                }
                case 'D': {
                    player[0]++;
                    break;
                }
                case 'L': {
                    player[1]--;
                    break;
                }
                case 'R': {
                    player[1]++;
                    break;
                }
            }
            if (player[0] < 0 || player[1] < 0 || player[0] >= board.length || player[1] >= board.length) return null;
            point += board[player[0]][player[1]];
        }

        return point;
    }
}

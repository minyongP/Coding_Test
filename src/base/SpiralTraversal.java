package base;

public class SpiralTraversal {
    public static void main(String[] args) {
        Character[][] matrix = new Character[][]{
                {'A', 'B', 'C'},
                {'D', 'E', 'F'},
                {'G', 'H', 'I'},
        };
        String output = spiralTraversal(matrix);
        System.out.println(output); // --> "ABCFIHGDE"

        matrix = new Character[][]{
                {'A', 'B', 'C' , 'D'},
                {'E', 'F', 'G', 'H'},
                {'I', 'J', 'K', 'L'},
        };
        output = spiralTraversal(matrix);
        System.out.println(output); // --> "ABCDHLKJIEFG"

        matrix = new Character[][]{
                {'T', 'y', 'r', 'i'},
                {'i', 's', 't', 'o'},
                {'n', 'r', 'e', 'n'},
                {'n', 'a', 'L', ' '},
        };
        output = spiralTraversal(matrix);
        System.out.println(output); // --> 'Tyrion Lannister'
    }

    private static String spiralTraversal(Character[][] matrix) {
        StringBuilder sb = new StringBuilder();
        int x = 0;
        int y = 0;
        // 좌하우상
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int width = matrix.length;
        int height = matrix[0].length;
        boolean[][] visited = new boolean[width][height];
        int control = 0;
        for (int i = 0; i < height * width; i++) {
            if (x >= 0 && y >= 0 && x < width && y < height && !visited[x][y]) {
                visited[x][y] = true;
                sb.append(matrix[x][y]);
                x += dx[control];
                y += dy[control];
            }
            else {
                x -= dx[control];
                y -= dy[control];
                control++;
                if (control == 4) control = 0;
                x += dx[control];
                y += dy[control];
                i--;
            }
        }
        return sb.toString();
    }
}

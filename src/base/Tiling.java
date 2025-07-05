package base;

public class Tiling {
    public static void main(String[] args) {
        int output = tiling(2);
        System.out.println(output); // --> 2

        output = tiling(4);
        System.out.println(output); // --> 5
    }

    private static int tiling(int num) {
        if (num < 3) return num;
        int[] D = new int[num+1];
        D[1] = 1;
        D[2] = 2;
        for (int i = 3; i < num+1; i++) D[i] = D[i-2] + D[i-1];
        return D[num];
    }
}

package programmers;

import java.util.Arrays;

public class 진료_순서_정하기 {
    public static void main(String[] args) {
        int[] emergency = {1, 2, 3, 4, 5, 6, 7};
        int[] sorted_emergency = Arrays.stream(emergency).sorted().toArray();
        int[] ans = new int[emergency.length];

        for (int i = 0; i < emergency.length; i++) {
            int rank = 1;
            for (int j = emergency.length-1; j >= 0; j--) {
                if (emergency[i] == sorted_emergency[j] ) {ans[j] = rank;}
                rank++;
            }
        }
        System.out.println(Arrays.toString(ans));
    }
}

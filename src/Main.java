import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] arr = {20, 100, 50, 50, 50};

        // 1) copy + sort desc
        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);
        // Arrays.sort는 오름차순이므로 뒤에서 앞으로 보거나, Integer로 바꿔 reverse해도 됨

        // 2) value -> rank (competition rank)
        Map<Integer, Integer> rankMap = new HashMap<>();
        int n = sorted.length;

        int prev = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) { // 뒤에서 앞으로 = 내림차순 순회
            int v = sorted[i];
            if (v != prev) {
                // 내림차순에서의 "몇 번째 위치"는 (n - i)
                int rank = n - i;
                rankMap.put(v, rank);
                prev = v;
            }
        }

        // 3) output ranks in original order
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) sb.append(' ');
            sb.append(rankMap.get(arr[i]));
        }
        System.out.println(sb.toString()); // 5 1 2 2 2
    }
}

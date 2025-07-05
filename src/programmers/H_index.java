package programmers;
import java.util.*;
public class H_index {
    public static void main(String[] args) {
        H_index solution = new H_index();
        System.out.println(solution(new int[]{3, 0, 6, 1, 5}));
        System.out.println(solution(new int[]{3, 3, 3, 4}));
    }

    private static int solution(int[] citations) {
        int answer = 0;

        Map<Integer, Integer> hMap = new TreeMap<>(Comparator.reverseOrder());
        for (int citation : citations) {
            for (int i = 0; i <= citation; i++) {
                hMap.put(i, hMap.getOrDefault(i, 0) + 1);
            }
        }

        for (int key : hMap.keySet()) {
            if (hMap.get(key) >= key) return key;
        }

        return answer;
    }
}

package programmers.해시;

import java.util.*;
public class 의상 {
    public static void main(String[] args) {
        의상 solution = new 의상();
        System.out.println(solution(new String[][]{
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        }));
        System.out.println(solution(new String[][]{
                {"crow_mask", "face"},
                {"blue_sunglasses", "face"},
                {"smoky_makeup", "face"}
        }));
    }

    private static int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> hashMap = new HashMap();
        for (String[] cloth : clothes) {
            hashMap.put(cloth[1], hashMap.getOrDefault(cloth[1], 0) + 1);
        }

        for (int count : hashMap.values()) {
            answer *= (count +1);
        }

        return answer-1;
    }
}

package programmers;
import java.util.*;

class Solution {
    public int[] solution(String s) {
        Set<Integer> resultTuple = new LinkedHashSet<>();
        String processed = s.substring(2, s.length() - 2);
        String[] tupleSets = processed.split("\\},\\{");
        Arrays.sort(tupleSets, Comparator.comparingInt(String::length));

        for (String set : tupleSets) {
            String[] numbers = set.split(",");
            for (String numStr : numbers) {
                resultTuple.add(Integer.parseInt(numStr));
            }
        }

        return resultTuple.stream().mapToInt(Integer::intValue).toArray();
    }
}

// 실행을 위한 main 메소드를 포함하는 클래스
public class 튜플 {
    public static void main(String[] args) {
        // 1. Solution 클래스의 인스턴스 생성
        Solution sol = new Solution();

        // 2. 테스트할 입력 데이터 준비
        String s1 = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        String s2 = "{{1,2,3},{2,1},{1,2,4,3},{2}}"	;
        String s3 = "{{20,111},{111}}";
        String s4 = "{{123}}";
        String s5 = "{{4,2,3},{3},{2,3,4,1},{2,3}}";

        // 3. solution 메소드 호출
        int[] result1 = sol.solution(s1);
        int[] result2 = sol.solution(s2);
        int[] result3 = sol.solution(s3);
        int[] result4 = sol.solution(s4);
        int[] result5 = sol.solution(s5);

        // 4. 결과 출력 (Arrays.toString을 사용하면 배열 내용이 보기 좋게 출력됨)
        System.out.println("테스트 1 결과: " + Arrays.toString(result1)); // 예상 결과: [2, 1, 3, 4]
        System.out.println("테스트 2 결과: " + Arrays.toString(result2)); // 예상 결과: [2, 1, 3, 4]
        System.out.println("테스트 3 결과: " + Arrays.toString(result3)); // 예상 결과: [111, 20]
        System.out.println("테스트 4 결과: " + Arrays.toString(result4)); // 예상 결과: [123]
        System.out.println("테스트 5 결과: " + Arrays.toString(result5)); // 예상 결과: [3, 2, 4, 1]
    }
}
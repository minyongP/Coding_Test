package combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SourceRecipe {
    public static void main(String[] args) {
        ArrayList<Integer[]> output1 = newChickenRecipe(new int[]{1, 10, 1100, 1111}, 2);
        System.out.println(output1);
/*
  [
    [1, 10], [1, 1100], [1, 1111],
    [10, 1], [10, 1100], [10, 1111],
    [1100, 1], [1100, 10], [1100, 1111],
    [1111, 1], [1111, 10], [1111, 1100]
  ];
*/

        ArrayList<Integer[]> output2 = newChickenRecipe(new int[]{10000, 10, 1}, 3);
        System.out.println(output2);
        // []

        ArrayList<Integer[]> output3 = newChickenRecipe(new int[]{11, 1, 10, 1111111111, 10000}, 4);
        System.out.println(output3);
/*
  [
    [1, 10, 11, 1111111111],
    [1, 10, 1111111111, 11],
    [1, 11, 10, 1111111111],
    [1, 11, 1111111111, 10],
    [1, 1111111111, 10, 11],
    [1, 1111111111, 11, 10],
    [10, 1, 11, 1111111111],
    [10, 1, 1111111111, 11],
    [10, 11, 1, 1111111111],
    [10, 11, 1111111111, 1],
    [10, 1111111111, 1, 11],
    [10, 1111111111, 11, 1],
    [11, 1, 10, 1111111111],
    [11, 1, 1111111111, 10],
    [11, 10, 1, 1111111111],
    [11, 10, 1111111111, 1],
    [11, 1111111111, 1, 10],
    [11, 1111111111, 10, 1],
    [1111111111, 1, 10, 11],
    [1111111111, 1, 11, 10],
    [1111111111, 10, 1, 11],
    [1111111111, 10, 11, 1],
    [1111111111, 11, 1, 10],
    [1111111111, 11, 10, 1],
  ]
*/
    }

    private static ArrayList<Integer[]> newChickenRecipe(int[] stuffArr, int choiceNum) {
        // 0이 연속 3개 이하인 재료 선별
        ArrayList<Integer> freshArr = new ArrayList<>();

//        for(int i = 0; i < stuffArr.length; i++) {
//            String str = String.valueOf(stuffArr[i]);
//            int[] element = str.chars().filter(c -> c == '0').toArray();
//            if(element.length <= 2) {
//                freshArr.add(stuffArr[i]);
//            }
//        }

        // 스트림과 이중반복문의 복잡도는 같다.
        // 일반적으론 char 배열로 받아 0의 개수를 세는 방법을 떠올린다
        for (int i = 0; i < stuffArr.length; i++) {
            int cnt = 0;
            char[] c = String.valueOf(stuffArr[i]).toCharArray();
            for (int j = 0; j < c.length; j++) {
                if (c[j] == '0') cnt++;
            }
            if (cnt < 3) freshArr.add(stuffArr[i]);
        }

        // 정렬화
        Collections.sort(freshArr);

        // 예외처리
        if (freshArr.size() == 0 || freshArr.size() < choiceNum) return null;

        // 재귀
        ArrayList<Integer[]> result = new ArrayList<>();
        boolean[] visited = new boolean[freshArr.size()];

        return permutation(choiceNum, new Integer[]{}, result, freshArr, visited, 0);
    }

    public static ArrayList<Integer[]> permutation(int choiceNum, Integer[] bucket, ArrayList<Integer[]> result, ArrayList<Integer> freshArr, boolean[] visited, int depth) {
        // base (다 선택했다면)
        if(depth == choiceNum) {
            result.add(bucket);
            return result;
        }

        for(int i = 0; i < freshArr.size(); i++) {
            // DFS BFS처럼 사용여부 확인 (중복X순열)
            if(!visited[i]) {
                visited[i] = true;
                Integer[] concatArray = Arrays.copyOf(bucket, bucket.length + 1);
                concatArray[concatArray.length - 1] = freshArr.get(i);

                result = permutation(choiceNum, concatArray, result, freshArr, visited, depth + 1);
                //한번 재귀를 순회한 이후, 반복문을 다시 시작하기 위해 첫 시작재료의 사용여부를 false로 변경합니다.
                visited[i] = false;
            }
        }
        return result;
    }
}

package combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class PowerSet {
    public static void main(String[] args) {
        ArrayList<String[]> output = missHouseMeal(new String[]{"eggroll", "kimchi", "fishSoup"});
        System.out.println(output);
        /*
        [ [],
          [eggroll, fishSoup, kimchi],
          [eggroll, fishSoup],
          [eggroll, kimchi],
          [eggroll],
          [fishSoup, kimchi],
          [fishSoup],
          [kimchi],
        ]
        */
    }

    private static ArrayList<String[]> missHouseMeal(String[] sideDishes) {
        Stack<String> stack = new Stack<>();
        ArrayList<String[]> result = new ArrayList<>();
        // 오름차순
        Arrays.sort(sideDishes);
        result = search(stack, 0, sideDishes, result);
        // 오름차순
        result.sort((o1, o2) -> Arrays.toString(o1).compareTo(Arrays.toString(o2)));
        return result;
    }

    private static ArrayList<String[]> search(Stack<String> stack, int idx, String[] sideDishes, ArrayList<String[]> result) {
        // base
        if (idx >= sideDishes.length) {
            String[] arr = stack.toArray(new String[0]);
            result.add(arr);
            return result;
        } else {    // push와 pop으로 모든 배열 만들기
            stack.push(sideDishes[idx]);
            search(stack, idx + 1, sideDishes, result);

            stack.pop();
            search(stack, idx + 1, sideDishes, result);
        }
        return result;
    }
}
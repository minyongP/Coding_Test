package datastructure.stack;

import java.util.*;

public class Browser {
    public static void main(String[] args) {
        String[] actions = new String[]{"B", "C", "-1", "D", "A", "-1", "1", "-1", "-1"};
        String start = "A";
        ArrayList<Stack> output = browserStack(actions, start);
        System.out.println(output);

        String[] actions2 = new String[]{"B", "-1", "B", "A", "C", "-1", "-1", "D", "-1", "1", "E", "-1", "-1", "1"};
        String start2 = "A";
        ArrayList<Stack> output2 = browserStack(actions2, start2);

        System.out.println(output2); // [["A", "B"], ["D"], ["E"]]
    }

    public static ArrayList<Stack> browserStack(String[] actions, String start) {
        Stack<String> prevStack = new Stack<>();
        Stack<String> nextStack = new Stack<>();
        Stack<String> current = new Stack<>();

        current.push(start);                        // 현재 = 시작

        for (String action : actions) {
            if (action.equals("-1")) {              // 뒤로가기
                if (prevStack.isEmpty()) continue;  // 비활성화
                nextStack.push(current.pop());      // 현재 -> 다음
                current.push(prevStack.pop());      // 이전 -> 현재
            }
            else if (action.equals("1")) {          // 앞으로가기
                if (nextStack.isEmpty()) continue;  // 비활성화
                prevStack.push(current.pop());      // 현재 -> 이전
                current.push(nextStack.pop());      // 다음 -> 현재
            }
            else{                                   // 새창열기
                nextStack.clear();                  // 다음 리셋
                prevStack.push(current.pop());      // 현재 -> 이전
                current.push(action);               // 현재 = 새창
            }
        }
        return new ArrayList<>(Arrays.asList(prevStack, current, nextStack));
    }
}

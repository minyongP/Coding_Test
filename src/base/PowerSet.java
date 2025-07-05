package base;

import java.util.*;

public class PowerSet {
    public static void main(String[] args) {
        ArrayList<String> output1 = powerSet("abc");
        System.out.println(output1); // ["", "a", "ab", "abc", "ac", "b", "bc", "c"]

        ArrayList<String> output2 = powerSet("jjump");
        System.out.println(output2); // ["", "j", "jm", "jmp", "jmpu", "jmu", "jp", "jpu", "ju", "m", "mp", "mpu", "mu", "p", "pu", "u"]
    }

    private static ArrayList<String> powerSet(String str) {
        String words = deduplication(str).toString();
        Stack<String> stack = new Stack<>();

        ArrayList<String> list = new ArrayList<>();

        list = pickOrNot(stack, 0, words, list);

        Collections.sort(list);
        return list;
    }

    private static StringBuilder deduplication(String str) {
        Set<Character> uniqueChars = new TreeSet<>();
        for (char c : str.toCharArray()) {
            uniqueChars.add(c);
        }

        StringBuilder result = new StringBuilder();
        for (char c : uniqueChars) {
            result.append(c);
        }
        return result;
    }

    public static ArrayList<String> pickOrNot(Stack<String> stack, int idx, String subset, ArrayList<String> result) {
        if (idx == subset.length()) {
            StringBuilder sb = new StringBuilder();
            for (String str : stack) {
                sb.append(str);
            }
            result.add(sb.toString());
            return result;
        }

        // 현재 문자를 선택하여 스택에 추가
        stack.push(Character.toString(subset.charAt(idx)));
        pickOrNot(stack, idx + 1, subset, result);
        stack.pop(); // 재귀 호출이 끝난 후 스택에서 제거

        // 현재 문자를 선택하지 않고 다음 문자로 넘어감
        pickOrNot(stack, idx + 1, subset, result);

        return result;
    }
}
package programmers;
/*
문제 설명 생략
https://school.programmers.co.kr/learn/courses/30/lessons/12981
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 영어_끝말잇기 {
    public static void main(String[] args) {
        /*
        1.중복단어 있는지 확인 -> 알고리즘 실행
        2. 끝말잇기가 맞는지 확인 -> 아니라면 위치 반환
        3. 이상 없다 -> 0,0 반환
         */
        int n = 2;
        String[] words = {"hello", "one", "even", "never", "now", "world", "raw"};
        int[] answer = new int[2];

        Set<String> set = new HashSet<>();
        int count = 0;
        boolean isFindDuplication = false;

        for (String s : words) {
            count++;
            // 중복 단어 발견 ( set.add()는 중복된 값을 넣을시 false 반환 )
            if (!set.add(s)) {
                isFindDuplication = true;
                answer = new int[]{count % n  == 0 ? n : count % n , (int) Math.ceil((double) count / n)};
                break;
            }
        }

        // 탈락자 발생
        boolean isChain = true;
        if (!isFindDuplication) {
            for (int i = 0; i < words.length - 1; i++) {
                if (words[i].charAt(words[i].length() - 1) != words[i+1].charAt(0)) {
                    answer = new int[]{(i + 2) % n == 0 ? n : (i + 2) % n , (int) Math.ceil((double) (i + 2) / n)};
                    isChain = false;
                    break;
                }
            }
        }

        if (!isFindDuplication && isChain) {
            answer = new int[]{0, 0};
        }

        System.out.println(Arrays.toString(answer));
    }
}

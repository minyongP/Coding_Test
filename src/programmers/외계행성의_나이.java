package programmers;

import java.util.Scanner;

public class 외계행성의_나이 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();

//        // 숫자를 문자열로 변환
//        StringBuilder sb = new StringBuilder(String.valueOf(age));
//        StringBuilder ans = new StringBuilder();
//        // 숫자를 하나씩 가져와 패턴에 맞게 변화
//        for (int i = 0; i < sb.length(); i++) {
//            char temp = sb.charAt(i);
//            ans.append(Character.toChars(temp + 49));
//        }
//        System.out.println(ans);

        String IntegerAge = Integer.toString(age);
        String result = "";

        for (int i = 0; i < IntegerAge.length(); i++) {
            result += (char)(IntegerAge.charAt(i) + 49);
        }

        System.out.println(result);
    }
}
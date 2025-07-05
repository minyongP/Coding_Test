package base;

import java.util.Arrays;

public class ReadVertically {
    public static void main(String[] args) {
        String[] input = new String[]{
                "hello",
                "wolrd",
        };
        String output = readVertically(input);
        System.out.println(output); // --> "hweolllrod"

        input = new String[]{
                "hi",
                "wolrd",
        };
        output = readVertically(input);
        System.out.println(output); // --> "hwiolrd"
    }

    private static String readVertically(String[] arr) {
        /*
        * length(input배열의 모든 문자열 길이를 저장)
        * for(i:0~길이배열중 가장 긴 문자열 길이 만큼){
        *   for(j:0~arr배열 크기만큼){
        *       if(length[j] > i) arr[j]의 i번째 문자 추가
        *   }
        * }
        * 결과 반환
        * */
        int[] length = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            length[i] = arr[i].length();
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < Arrays.stream(length).max().getAsInt(); i++) {
            for (int j = 0; j < arr.length; j++){
                if (length[j] > i) sb.append(arr[j].charAt(i));
            }
        }
        return sb.toString();
    }
}
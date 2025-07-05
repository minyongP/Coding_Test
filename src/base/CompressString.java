package base;

public class CompressString {
    public static void main(String[] args) {
        String output = compressString("abc");
        System.out.println(output); // --> "abc"

        output = compressString("wwwggoppopppp");
        System.out.println(output); // --> "3wggoppo4p"
    }

    private static String compressString(String str) {
        /*
        * count(연속된 같은 문자)
        * A(문자 배열)
        * n=0
        * while(n<A길이)
        *  count = 0;
        *  for(i: n+1~A길이)
        *   if(A[i-1] == A[i]
        *    count++
        *   else
        *    if(count>=3)
        *       A의 n부분에 count추가 단어 1개로 줄이기
        *    else
        *       문자 추가
        *       n = i;
        *배열 출력
        * */

//        char[] A = str.toCharArray();
//        String result = "";
//
//        int count = 1;
//        for (int i = 0; i < A.length-1; i++) {
//            if (A[i] == A[i+1] && i+1 < A.length) {  //todo 마지막까지 같은게 이어지면 else로 넘어가야함
//                count++;
//            }
//            else {
//                if (count > 2) {
//                    result += (char) (count + 48);
//                    result += (char) A[i];
//                }
//                else {
//                    for (int j = 0; j < count; j++) {
//                        result += (char) A[i];
//                    }
//                }
//                count = 1;
//            }
//        }
//        result += (char)A[A.length-1];
//        return result;

        StringBuilder result = new StringBuilder();

        int count = 1;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                if (count > 2) {
                    result.append(count).append(str.charAt(i));
                } else {
                    for (int j = 0; j < count; j++) {
                        result.append(str.charAt(i));
                    }
                }
                count = 1;
            }
        }

        // 마지막 문자 처리
        if (count > 2) {
            result.append(count).append(str.charAt(str.length() - 1));
        } else {
            for (int j = 0; j < count; j++) {
                result.append(str.charAt(str.length() - 1));
            }
        }
        return result.toString();
    }
}

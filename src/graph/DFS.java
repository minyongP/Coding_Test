package graph;

public class DFS {
    public static void main(String[] args) {
        String output = barcode(3);
        System.out.println(output); // "121"

        output = barcode(7);
        System.out.println(output); // "1213121"

        output = barcode(20);
        System.out.println(output); // "12131231321231213123"
    }

//    private static String barcode(int i) {
//    }

    public static String barcode(int len) {
        return aux("", len);
    }

    public static boolean isValid(String str) {
        // index 관리를 편하게 하기 위해 string reverse
        StringBuffer sb = new StringBuffer(str);
        String reverse = sb.reverse().toString();
        // 인접한 두 개의 부분 수열이 동일한지 확인한다.
        // 최대 절반 길이만큼만 두 개의 부분 수열이 가능하다.
        int halfLen = (int)Math.floor((double) str.length() / 2);

        for(int i = 1; i <= halfLen; i++) {
            if(reverse.substring(0, i).equals(reverse.substring(i, i + i))) {
                return false;
            }
        }
        return true;
    }

    public static String aux(String str, int len) {
        String chr = "123";
        // 유효성을 통과해서 만든 길이 len의 str을 리턴한다.
        if(str.length() == len) return str;
        // 조건을 만족하는 가장 작은 수를 찾고 있으므로,
        // 1, 2, 3 순서대로 검토한다.
        // 실제 수(number) 비교는 필요없다.
        for(int i = 0; i < chr.length(); i++) {
            String currentStr = str + chr.charAt(i);
            if(isValid(currentStr)) {
                String founded = aux(currentStr, len);
                if(founded != null) return founded;
            }
        }
        // 현재 str에서 1, 2, 3을 이어붙여서 유효한 문자열을 만들 수 없는 경우
        return null;
    }
}
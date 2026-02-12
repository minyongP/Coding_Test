package im;

import java.util.*;

public class P1928 {
    private static final String TABLE = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    private static Map<Character, Integer> tableMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < TABLE.length(); i++) tableMap.put(TABLE.charAt(i), i);
        for (int tc = 1; tc <= T; tc++) {
            String encode = sc.nextLine();
            sb.append("#" + tc + " ");
            for (int i = 0; i < encode.length(); i+=4) {
                // 6비트씩 4개  = 24비트
                // 6비트로 4개를 뽑아 24비트로 만들기
                int c1 = tableMap.get(encode.charAt(i));
                int c2 = tableMap.get(encode.charAt(i+1));
                int c3 = tableMap.get(encode.charAt(i+2));
                int c4 = tableMap.get(encode.charAt(i+3));
                // 6비트 4개 24비트로 차례대로 합치기
                int bit = (c1 << 18) | (c2 << 12) | (c3 << 6) | c4;
                // 1byte = 8bit  | 0xff = 1111 1111 (8bit)
                // 비트 마스킹
                char b1 = (char) (bit >> 16);
                char b2 = (char) ((bit >> 8) & 0xff);
                char b3 = (char) (bit & 0xff);

                sb.append(b1).append(b2).append(b3);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}

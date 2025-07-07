package base;

public class P4673 {
    public static void main(String[] args) {
        boolean[] A = new boolean[10036];
        for (int i = 1; i <= 10000; i++) {
            int selfNum = i;
            String s = Integer.toString(i);
//            char[] temp = s.toCharArray();
//            for (int j = 0; j < temp.length; j++) {
//                selfNum += Integer.parseInt(String.valueOf(temp[j]));
//            }
            for (char c : s.toCharArray()) {
                selfNum += Character.getNumericValue(c);
            }
            A[selfNum] = true;
            selfNum = 0;
        }

        for (int i = 1; i <= 10000; i++) {
            if (!A[i]) System.out.println(i);
        }
    }
}

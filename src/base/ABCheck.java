package base;

public class ABCheck {
    public static void main(String[] args) {
        boolean output = ABCheck("lane Borrowed");
        System.out.println(output); // --> true
    }

    private static boolean ABCheck(String str) {
        str = str.toLowerCase();

//        char[] c = str.toCharArray();
//        for (int i = 0; i < c.length-1; i++) {
//            if (c[i] == 'a') {
//                for (int j = i + 1; j < c.length; j++) {
//                    if (c[j] == 'b') {
//                        if (j-i+1 == 5) return true;
//                    }
//                }
//            }
//            if (c[i] == 'b') {
//                for (int j = i + 1; j < c.length; j++) {
//                    if (c[j] == 'a') {
//                        if (j-i+1 == 5) return true;
//                    }
//                }
//            }
//        }
        for(int i = 4; i < str.length(); i++) {
            if((str.charAt(i) == 'a' && str.charAt(i - 4) == 'b') || (str.charAt(i) == 'b' && str.charAt(i - 4) == 'a')) {
                return true;
            }
        }
        return false;
    }
}

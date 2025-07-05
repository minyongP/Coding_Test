package base;

public class IsIsogram {
    public static void main(String[] args) {
        boolean output = isIsogram("aba");
        System.out.println(output); // false

        output = isIsogram("Dermatoglyphics");
        System.out.println(output); // true

        output = isIsogram("moOse");
        System.out.println(output); // false
    }

    private static boolean isIsogram(String str) {
        char[] c = str.toLowerCase().toCharArray();
        int[] alpha = new int[26];
        for (int i = 0; i < str.length(); i++) {
            if (alpha[(int) c[i]-'a'] == 1) return false;
            alpha[(int) c[i]-'a']++;
        }
        return true;
    }
}
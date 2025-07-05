package base;

import java.util.ArrayList;

public class RemoveExtremes {
    public static void main(String[] args) {
        String[] output = removeExtremes(new String[]{"iAmLongest", "iAmNotShortest", "iAmLongest", "long"});
        System.out.println(output); // --> ["a"', "b"]

        output = removeExtremes(new String[]{"where", "is", "the", "longest", "word"});
        System.out.println(output); // --> ["where", "the", "word"]
    }

    private static String[] removeExtremes(String[] arr) {
//        if (arr.length < 3) return null;
        if (arr.length == 0) return null;
        ArrayList<String> arrayList = new ArrayList<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int minIndex = 0, maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() <= min) {
                min = arr[i].length();
                minIndex = i;
            }
            if (arr[i].length() >= max) {
                max = arr[i].length();
                maxIndex = i;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (i != minIndex && i != maxIndex) {
                arrayList.add(arr[i]);
            }
        }

        return arrayList.toArray(new String[arrayList.size()]);
    }
}

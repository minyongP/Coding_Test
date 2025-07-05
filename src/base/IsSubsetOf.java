package base;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IsSubsetOf {
    public static void main(String[] args) {
        int[] base = new int[]{1, 2, 3, 4, 5};
        int[] sample = new int[]{1, 3};
        boolean output = isSubsetOf(base, sample);
        System.out.println(output); // --> true

        sample = new int[]{6, 7};
        output = isSubsetOf(base, sample);
        System.out.println(output); // --> false

        base = new int[]{10, 99, 123, 7};
        sample = new int[]{11, 100, 99, 123};
        output = isSubsetOf(base, sample);
        System.out.println(output); // --> false
    }

//    private static boolean isSubsetOf(int[] base, int[] sample) {
//        if (base.length < sample.length) return false;
//        for (int i = 0; i < sample.length; i++) {
//            boolean isSubset = false;
//            for (int j = 0; j < base.length; j++) {
//                if (sample[i] == base[j]){
//                    isSubset = true;
//                    break;
//                }
//            }
//            if (!isSubset) return false;
//        }
//        return true;
//    }
    public static boolean isSubsetOf(int[] base, int[] sample) {
        if (base.length < sample.length) return false;
    //배열을 List로 변경후, List.contains 명령어를 사용하여 중복여부 검사
        List<Integer> intList
                = Arrays.stream(base)
                .boxed()
                .collect(Collectors.toList());

        for (int i : sample) {
            if (!intList.contains(i)) {
                return false;
            }
        }
        return true;
    }
}

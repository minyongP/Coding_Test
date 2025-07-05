package base;

public class GetItemFromTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 4, 8, 10};
        int[] arr2 = new int[]{2, 3, 5, 9};
        int result = getItemFromTwoSortedArrays(arr1, arr2, 6);
        System.out.println(result); // --> 8

        arr1 = new int[]{1, 1, 2, 10};
        arr2 = new int[]{3, 3};
        result = getItemFromTwoSortedArrays(arr1, arr2, 4);
        System.out.println(result); // --> 3
    }

    private static int getItemFromTwoSortedArrays(int[] arr1, int[] arr2, int k) {
        boolean select = true;
        int s1 = 0;
        int s2 = 0;
        int c1 = 0;
        int c2 = 0;
        for (int i = 0; i < k; i++) {
            if (arr1[s1] < arr2[s2]) {
                s1++;
                c1++;
                select = true;
            } else {
                s2++;
                c2++;
                select = false;
            }
        }
        return select ? arr1[k - 1 - c2] : arr2[k - 1 - c1];
    }
}
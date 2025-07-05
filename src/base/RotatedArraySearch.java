package base;

import java.lang.reflect.Array;

public class RotatedArraySearch {
    public static void main(String[] args) {
        int output = rotatedArraySearch(new int[]{4, 5, 6, 0, 1, 2, 3}, 2);
        System.out.println(output); // --> 5

        int output1 = rotatedArraySearch(new int[]{4, 5, 6, 0, 1, 2, 3}, 100);
        System.out.println(output1); // --> -1

        int output2 = rotatedArraySearch(new int[]{4, 5, 6, 3}, 2);
        System.out.println(output2); // --> 2
    }

    private static int rotatedArraySearch(int[] rotated, int target) {
        int left = 0;
        int right = rotated.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (rotated[mid] == target) {
                return mid;  // 원하는 값(target)을 찾았을 경우 인덱스 반환
            }

            // 왼쪽 절반은 정렬되어 있는 부분
            if (rotated[left] <= rotated[mid]) {
                if (target >= rotated[left] && target < rotated[mid]) {
                    right = mid - 1;  // 왼쪽 절반에서 이진 검색을 계속
                } else {
                    left = mid + 1;  // 오른쪽 절반에서 이진 검색을 계속
                }
            }

            // 오른쪽 절반은 정렬되어 있는 부분
            else {
                if (target > rotated[mid] && target <= rotated[right]) {
                    left = mid + 1;  // 오른쪽 절반에서 이진 검색을 계속
                } else {
                    right = mid - 1;  // 왼쪽 절반에서 이진 검색을 계속
                }
            }
        }

        return -1;  // 원하는 값(target)이 배열에 존재하지 않을 경우 -1 반환
    }
}

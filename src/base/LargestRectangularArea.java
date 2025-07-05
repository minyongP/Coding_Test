package base;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangularArea {
    public static void main(String[] args) {
        int[] histogram = new int[]{2, 1, 4, 5, 1, 3, 3};
        int output = largestRectangularArea(histogram);
        System.out.println(output); // --> 8

        histogram = new int[]{6, 2, 5, 4, 5, 1, 6};
        output = largestRectangularArea(histogram);
        System.out.println(output); // --> 12
/*
6 | x           x
5 | x   x   x   x
4 | x   O O O   x
3 | x   O O O   x
2 | x x O O O   x
1 | x x O O O x x
------------------
*/
    }

    private static int largestRectangularArea(int[] histogram) {
        int maxArea = 0;
        int[] tempPLE = new int[histogram.length];
        int[] tempNLE = new int[histogram.length];
        Arrays.fill(tempPLE, -1);
        Arrays.fill(tempNLE, -1);

        int[] PLE = findPLE(tempPLE, histogram);
        int[] NLE = findNLE(tempNLE, histogram);
        for(int i = 0; i < histogram.length; i++) {
            int barsOnLeft = PLE[i] == -1 ? i : i - PLE[i] - 1;
            int barsOnRight = NLE[i] == -1 ? histogram.length - 1 - i : NLE[i] - i - 1;
            int width = barsOnLeft + barsOnRight + 1;
            maxArea = Math.max(maxArea, width * histogram[i]);
        }
        return maxArea;
    }
    public static int[] findPLE(int[] PLE, int[] histogram) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < histogram.length; i++) {
            while (stack.size() > 0 && histogram[stack.get(stack.size() - 1)] >= histogram[i]) {
                stack.pop();
            }
            if(stack.size() > 0) {
                PLE[i] = stack.get(stack.size() - 1);
            }
            stack.push(i);
        }
        return PLE;
    }

    public static int[] findNLE(int[] NLE, int[] histogram) {
        Stack<Integer> stack = new Stack<>();
        for(int i = histogram.length - 1; i >= 0; i--) {
            while (stack.size() > 0 && histogram[stack.get(stack.size() - 1)] >= histogram[i]) {
                stack.pop();
            }
            if(stack.size() > 0) {
                NLE[i] = stack.get(stack.size() - 1);
            }
            stack.push(i);
        }
        return NLE;
    }

//    private static int largestRectangularArea(int[] histogram) {
//         int max = 0;
////        for (int i = 0; i < histogram.length-1; i++) {
////            int width = 1;
////            int hight = histogram[i];
////            max = max >= width * hight ? max : width * hight;
////            for (int j = i+1; j < histogram.length; j++) {
////                width++;
////                hight = hight > histogram[j] ? histogram[j] : hight;
////                max = max >= width * hight ? max : width *hight;
//            }
//        }
//        return max;
//    }
}

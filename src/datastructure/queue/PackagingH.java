package datastructure.queue;

public class PackagingH {
    public static void main(String[] args) {
        int[] boxes = new int[]{};
        int output = paveBox(boxes);
        System.out.println(output); // 3

        int[] boxes2 = new int[]{1, 5, 7, 9};
        int output2 = paveBox(boxes2);
        System.out.println(output2); // 1
    }
    public static int paveBox(int[] boxes) {
        if (boxes.length == 0) return 0;
        int result = 1;
        int count = 0;
        for (int i = 0; i < boxes.length; i++) {
            if (result < count) result = count;
            count = 0;
            int max = boxes[i];
            for (int j = i; j < boxes.length; j++) {
                if (max >= boxes[j]) count++;
                else break;
            }
        }
        return result;
    }
}
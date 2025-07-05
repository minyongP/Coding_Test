package base;

public class TheBabylonianMethod {
    public static void main(String[] args) {
        String output = computeSquareRoot(9);
        System.out.println(output); // --> "3.00"

        output = computeSquareRoot(6);
        System.out.println(output); // --> "2.45"
    }

    private static String computeSquareRoot(int num) {
        double multipleNum = 1;
        while (true) {
            if (multipleNum * multipleNum == num) {
                return String.format("%.2f", multipleNum);
            } else if (multipleNum * multipleNum > num) {
                multipleNum -= 1;
                break;
            }
            multipleNum++;
        }
        int count = 0;
        double guess = multipleNum;
        while (true) {
            count++;
            if (count == 1000) {
                return String.format("%.2f", guess);
            }
            guess = (guess + (num / guess)) / 2;
        }
    }
}
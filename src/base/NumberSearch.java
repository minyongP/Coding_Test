package base;

public class NumberSearch {
    public static void main(String[] args) {
        int output = numberSearch("5");
        System.out.println(output); // --> 1

        output = numberSearch("Hello6 9World 2,");
        System.out.println(output); // --> 2

        output = numberSearch("Hello6 9World 2, Nic8e D7ay!");
        System.out.println(output); // --> 2
    }

    private static int numberSearch(String str) {
        char[] c = str.trim().toCharArray();
        double sum = 0;
        int count = 0;
        for(int i = 0; i < c.length; i++){
            if(Character.isDigit(c[i])){
                sum += c[i] - '0';
            } else count++;
        }
//        if (count == 0) return (int) sum;
        return (int) Math.round(sum/count);
    }
}

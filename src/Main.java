import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(-5.0/0);  // -Infinity
        System.out.println(Math.round(-5.0/0)); // -9223372036854775808
        System.out.println((int) Math.round(-5.0/0)); // 0
    }
}
package base.stream.oddgugudan;

import java.util.stream.IntStream;

public class OddTimesGugudan {
    public static void main(String[] args) {
        IntStream.rangeClosed(2, 9)
                .filter(i -> i % 2 != 0)
                .forEach(i -> IntStream.rangeClosed(1, 9)
                        .map(j -> i * j)
                        .forEach(num -> System.out.println(
                                i + " * " + (num / i) + " = " + num)));
    }
}

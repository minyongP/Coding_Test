package base.stream.takesSum;

import java.util.List;
import java.util.stream.Stream;

public class TakesSum {
    public static void main(String[] args) {
//        int sum1 = Stream.of(SampleData.salesOfBakeryA, SampleData.salesOfBakeryB, SampleData.salesOfBakeryC)
//                .flatMap(List::stream)
//                .mapToInt(Integer::intValue)
//                .sum();
//        int sum2 = SampleData.salesOfBakeryA.stream()
//                        .mapToInt(Integer::intValue)
//                                .sum();
//        int sum3 = SampleData.salesOfBakeryA.stream()
//                        .reduce(0, Integer::sum);

        int sum = Stream.of(SampleData.salesOfBakeryA, SampleData.salesOfBakeryB, SampleData.salesOfBakeryC)
                        .flatMap(List::stream)
                                .reduce(0, Integer::sum);

        System.out.println("# 전체 매출액: " + sum);
    }
}

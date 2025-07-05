package base.stream.coffeelist;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<OrderCoffee> result = SampleData.orderCoffees.stream()
                .sorted(Comparator.comparing(OrderCoffee::getCreatedAt).reversed())
                .collect(Collectors.toList());
        result.forEach(System.out::println);
    }
}

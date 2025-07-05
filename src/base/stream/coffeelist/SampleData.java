package base.stream.coffeelist;

import java.util.List;

class SampleData {
    public static final List<OrderCoffee> orderCoffees = List.of(
            new OrderCoffee(1L, 1L, "23-1-25", 1L,
                    1, "아메리카노", "Americano", 2500, "AMR"),
            new OrderCoffee(1L, 1L, "23-1-25", 2L,
                    2, "바닐라", "V", 2500, "VNL"),
            new OrderCoffee(2L, 2L, "23-1-26", 1L,
                    1, "아메리카노", "Americano", 2500, "AMR"),
            new OrderCoffee(3L, 3L, "23-1-27", 1L,
                    1, "아메리카노", "Americano", 2500, "AMR"),
            new OrderCoffee(3L, 3L, "23-1-28", 3L,
                    2, "카라멜", "C", 5000, "CRM")
    );
}

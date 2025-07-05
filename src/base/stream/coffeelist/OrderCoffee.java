package base.stream.coffeelist;

public class OrderCoffee {
    private long orderId;
    private long memberId;
    private String createdAt;
    private long coffeeId;
    private int quantity;
    private String korName;
    private String engName;
    private int price;
    private String coffeeCode;

    public OrderCoffee(long orderId, long memberId, String createdAt,
                       long coffeeId, int quantity, String korName,
                       String engName, int price, String coffeeCode) {
        this.orderId = orderId;
        this.memberId = memberId;
        this.createdAt = createdAt;
        this.coffeeId = coffeeId;
        this.quantity = quantity;
        this.korName = korName;
        this.engName = engName;
        this.price = price;
        this.coffeeCode = coffeeCode;
    }

    public long getOrderId() {
        return orderId;
    }

    public long getMemberId() {
        return memberId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public long getCoffeeId() {
        return coffeeId;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getKorName() {
        return korName;
    }

    public String getEngName() {
        return engName;
    }

    public int getPrice() {
        return price;
    }

    public String getCoffeeCode() {
        return coffeeCode;
    }

    @Override
    public String toString() {
        return "OrderCoffee{" +
                "orderId=" + orderId +
                ", memberId=" + memberId +
                ", createdAt='" + createdAt + '\'' +
                ", coffeeId=" + coffeeId +
                ", quantity=" + quantity +
                ", korName='" + korName + '\'' +
                ", engName='" + engName + '\'' +
                ", price=" + price +
                ", coffeeCode='" + coffeeCode + '\'' +
                '}';
    }
}

package base.stream.distinctcarbrand;

public class Car {
    private final CarBrand carBrand;
    private final CarType carType;
    private final String name;
    private final int price;
    private final boolean isNew;

    Car(CarBrand carBrand, CarType carType, String name, int price, boolean isNew) {
        this.carBrand = carBrand;
        this.carType = carType;
        this.name = name;
        this.price = price;
        this.isNew = isNew;
    }

    public enum CarBrand {
        BMW,
        Benz,
        Volkswagen,
        Ford,
        Jeep
    }

    public enum CarType {
        SEDAN,
        SUV,
        PICKUPTRUCK
    }

    public CarBrand getCarBrand() {
        return carBrand;
    }

    public CarType getCarType() {
        return carType;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public boolean isNew() {
        return isNew;
    }
}

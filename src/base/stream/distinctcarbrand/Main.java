package base.stream.distinctcarbrand;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static List<Car> cars = List.of(
            new Car(Car.CarBrand.Volkswagen, Car.CarType.SEDAN, "티구안", 23_000_000, true),
            new Car(Car.CarBrand.BMW, Car.CarType.SUV, "미니", 33_000_000, true),
            new Car(Car.CarBrand.Benz, Car.CarType.SUV, "G바겐", 50_000_000, true),
            new Car(Car.CarBrand.Benz, Car.CarType.SEDAN, "E-Class", 28_000_000, true),
            new Car(Car.CarBrand.Ford, Car.CarType.SUV, "익스플로러", 18_000_000, true),
            new Car(Car.CarBrand.Jeep, Car.CarType.SUV, "랭글러", 23_000_000, true),
            new Car(Car.CarBrand.Volkswagen, Car.CarType.SUV, "투아렉", 40_000_000, true),
            new Car(Car.CarBrand.Volkswagen, Car.CarType.SUV, "골프", 43_000_000, true),
            new Car(Car.CarBrand.Jeep, Car.CarType.SEDAN, "체로키", 35_000_000, true),
            new Car(Car.CarBrand.Jeep, Car.CarType.PICKUPTRUCK, "글래디에이터", 45_000_000, true)
    );

    public static void main(String[] args) {
        cars.stream()
                .collect(Collectors.toMap(  // map을 이용하면 키값으로 중복을 제거 가능
                        Car::getCarBrand,
                        Car::getName,
                        (a, b) -> a))        // -> a는 기존 값을 유지, -> b는 신규 값으로 대체 하는 의미이다.
                .forEach((carBrand, name) -> System.out.println(carBrand + ", " + name));
    }
}
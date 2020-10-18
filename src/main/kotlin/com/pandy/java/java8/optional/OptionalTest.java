package com.pandy.java.java8.optional;

import java.util.Optional;

public class OptionalTest {

    //声明一个空得Optional
    Optional<Car> opt = Optional.empty();


    Car car = new Car();
    //一句一个非空值创建Optional
    Optional<Car> optCar = Optional.of(car);

    //可以接受null得Optional
    Optional<Car> optCar2 = Optional.ofNullable(car);

    public String getCarInsuranceName(Person person){
        return person.getCar().getInsurance().getName();
    }

//    public String getCarInsuranceName(Optional<Person> person) {
//        return person.flatMap(Person::getCar)
//                .flatMap(Car::getInsurance)
//                .map(Insurance::getName)
//                .orElse("Unknown");
//    }

    public static void main(String[] args) {
        Insurance insurance = new Insurance();
        String name = null;
        if (insurance != null) {
            name = insurance.getName();
        }

        Optional<Insurance> optionalInsurance = Optional.ofNullable(insurance);
        Optional<String> name2 = optionalInsurance.map(Insurance::getName);
    }
}

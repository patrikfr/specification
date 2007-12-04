package com.granular8.specification.sample.testutil;

import com.granular8.specification.sample.domain.Car;
import com.granular8.specification.sample.domain.Color;
import com.granular8.specification.sample.domain.Person;
import com.granular8.specification.sample.domain.Address;
import static com.granular8.specification.sample.domain.Region.SOUTH;
import static com.granular8.specification.sample.domain.Region.SOUTH_EAST;
import static com.granular8.specification.sample.domain.Region.NORTH_EAST;
import com.domainlanguage.time.CalendarDate;

public class CarTestFactory {
  public static Car createCar5(CalendarDate manufacturingDate) {
    Car car5 = new Car();
    car5.setColor(Color.RED);
    car5.setConvertible(false);
    car5.setManufacturingDate(manufacturingDate);
    Person car5Owner = new Person();
    Address car5OwnerAddress = new Address();
    car5OwnerAddress.setRegion(SOUTH);
    car5Owner.setHomeAddress(car5OwnerAddress);
    car5.setOwner(car5Owner);
    return car5;
  }

  public static Car createCar4(CalendarDate manufacturingDate) {
    Car car4 = new Car();
    car4.setColor(Color.RED);
    car4.setConvertible(false);
    car4.setManufacturingDate(manufacturingDate);
    Person car4Owner = new Person();
    Address car4OwnerAddress = new Address();
    car4OwnerAddress.setRegion(SOUTH_EAST);
    car4Owner.setHomeAddress(car4OwnerAddress);
    car4.setOwner(car4Owner);
    return car4;
  }

  public static Car createCar3(CalendarDate manufacturingDate) {
    Car car3 = new Car();
    car3.setColor(Color.RED);
    car3.setConvertible(true);
    car3.setManufacturingDate(manufacturingDate);
    Person car3Owner = new Person();
    Address car3OwnerAddress = new Address();
    car3OwnerAddress.setRegion(NORTH_EAST);
    car3Owner.setHomeAddress(car3OwnerAddress);
    car3.setOwner(car3Owner);
    return car3;
  }

  public static Car createCar2(CalendarDate manufacturingDate) {
    Car car2 = new Car();
    car2.setColor(Color.GREEN);
    car2.setConvertible(true);
    car2.setManufacturingDate(manufacturingDate);
    Person car2Owner = new Person();
    Address car2OwnerAddress = new Address();
    car2OwnerAddress.setRegion(SOUTH);
    car2Owner.setHomeAddress(car2OwnerAddress);
    car2.setOwner(car2Owner);
    return car2;
  }

  public static Car createCar1(CalendarDate manufacturingDate) {
    Car car1 = new Car();
    car1.setColor(Color.RED);
    car1.setConvertible(false);
    car1.setManufacturingDate(manufacturingDate);
    Person car1Owner = new Person();
    Address car1OwnerAddress = new Address();
    car1OwnerAddress.setRegion(NORTH_EAST);
    car1Owner.setHomeAddress(car1OwnerAddress);
    car1.setOwner(car1Owner);
    return car1;
  }
}

package com.granular8.specification.nospec;

import com.domainlanguage.time.CalendarDate;
import com.domainlanguage.time.Duration;
import com.domainlanguage.timeutil.Clock;
import com.granular8.specification.domain.*;
import junit.framework.TestCase;

import java.util.*;

public class CarServiceImplTest extends TestCase {

  public void testFindCandidateCars() throws Exception {
    CarServiceImpl carServiceImpl = new CarServiceImpl();
    carServiceImpl.setRepository(new CarRepositoryStub());
    carServiceImpl.setAuthorizedRegions(getAuthorizedRegions());

    Collection<Car> candicateCars = carServiceImpl.findCandidateCars();
    assertEquals(2, candicateCars);


  }

  private Set<Region> getAuthorizedRegions() {
    Set<Region> regions = new HashSet<Region>();
    regions.add(Region.SOUTH_WEST);
    regions.add(Region.SOUTH_EAST);
    regions.add(Region.SOUTH);

    return regions;
  }


  class CarRepositoryStub implements CarRepository {

    public Collection<Car> findAllCarsInStock() {

      final CalendarDate today = Clock.now().calendarDate(TimeZone.getTimeZone("GMT"));

      List<Car> cars = new ArrayList<Car>();

      //Not vaild, wrong region
      Car car1 = getCar1(today);

      //Not valid, not red
      Car car2 = getCar2(today);

      //Valid, red + convertible
      Car car3 = getCar3(today);

      //Valid, red, from the right region and only two years old
      Car car4 = getCar4(today);

      //Invalid, too old
      Car car5 = createCar5(today);

      cars.add(car1);
      cars.add(car2);
      cars.add(car3);
      cars.add(car4);
      cars.add(car5);

      return cars;
    }

    private Car createCar5(CalendarDate today) {
      Car car5 = new Car();
      car5.setColor(Color.RED);
      car5.setConvertible(false);
      car5.setManufacturingDate(today.plus(Duration.years(-4)));
      Person car5Owner = new Person();
      Address car5OwnerAddress = new Address();
      car5OwnerAddress.setRegion(Region.SOUTH);
      car5Owner.setHomeAddress(car5OwnerAddress);
      car5.setOwner(car5Owner);
      return car5;
    }

    private Car getCar4(CalendarDate today) {
      Car car4 = new Car();
      car4.setColor(Color.RED);
      car4.setConvertible(false);
      car4.setManufacturingDate(today.plus(Duration.years(-2)));
      Person car4Owner = new Person();
      Address car4OwnerAddress = new Address();
      car4OwnerAddress.setRegion(Region.SOUTH_EAST);
      car4Owner.setHomeAddress(car4OwnerAddress);
      car4.setOwner(car4Owner);
      return car4;
    }

    private Car getCar3(CalendarDate today) {
      Car car3 = new Car();
      car3.setColor(Color.RED);
      car3.setConvertible(true);
      car3.setManufacturingDate(today.plus(Duration.years(-2)));
      Person car3Owner = new Person();
      Address car3OwnerAddress = new Address();
      car3OwnerAddress.setRegion(Region.NORTH_EAST);
      car3Owner.setHomeAddress(car3OwnerAddress);
      car3.setOwner(car3Owner);
      return car3;
    }

    private Car getCar2(CalendarDate today) {
      Car car2 = new Car();
      car2.setColor(Color.GREEN);
      car2.setConvertible(true);
      car2.setManufacturingDate(today.plus(Duration.years(-2)));
      Person car2Owner = new Person();
      Address car2OwnerAddress = new Address();
      car2OwnerAddress.setRegion(Region.SOUTH);
      car2Owner.setHomeAddress(car2OwnerAddress);
      car2.setOwner(car2Owner);
      return car2;
    }

    private Car getCar1(CalendarDate today) {
      Car car1 = new Car();
      car1.setColor(Color.RED);
      car1.setConvertible(false);
      car1.setManufacturingDate(today.plus(Duration.years(-2)));
      Person car1Owner = new Person();
      Address car1OwnerAddress = new Address();
      car1OwnerAddress.setRegion(Region.NORTH_EAST);
      car1Owner.setHomeAddress(car1OwnerAddress);
      car1.setOwner(car1Owner);
      return car1;
    }
  }
}
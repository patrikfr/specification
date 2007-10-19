package com.granular8.specification.sample.spec;

import static com.granular8.specification.sample.domain.Region.SOUTH_EAST;
import static com.granular8.specification.sample.domain.Region.SOUTH;
import static com.granular8.specification.sample.domain.Region.NORTH_EAST;
import com.domainlanguage.time.CalendarDate;
import com.domainlanguage.time.Duration;
import com.domainlanguage.timeutil.Clock;
import com.granular8.specification.sample.domain.*;
import com.granular8.specification.sample.nospec.*;
import junit.framework.TestCase;

import java.util.*;

public class CarServiceImplTest extends TestCase {

  //Scenario test for finding candidate cars using the CarService and specification implementation.

  /*
  Imagine you run a used car dealership. Your particular niche is selling
  cars of the color red. But they must also be fairly new and reliable.
  So besides being red, you want the current owner to live in certain
  geographical regions, regions that provide good living conditions for
  cars (e.g. no winterish kind of places), and you want the cars to be
  less than five years old. But there is one exception, if it's a convertible,
  the only restriction that applies is that it still must be red.
   */

  public void testFindCandidateCars() throws Exception {
    CarServiceImpl carServiceImpl = new CarServiceImpl();
    carServiceImpl.setRepository(new CarRepositoryStub());

    Collection<Car> candicateCars = carServiceImpl.findCandidateCars();
    assertEquals(2, candicateCars.size());
  }

  class CarRepositoryStub implements CarRepository {

    public Collection<Car> findAllCarsInStock() {

      final CalendarDate today = Clock.now().calendarDate(TimeZone.getTimeZone("GMT"));
      final CalendarDate mfgDate = Duration.years(2).subtractedFrom(today);

      List<Car> cars = new ArrayList<Car>();

      //Not vaild, wrong region
      Car car1 = getCar1(mfgDate);

      //Not valid, not red
      Car car2 = getCar2(mfgDate);

      //Valid, red + convertible
      Car car3 = getCar3(mfgDate);

      //Valid, red, from the right region and only two years old
      Car car4 = getCar4(mfgDate);

      //Invalid, too old
      Car car5 = createCar5(Duration.years(6).subtractedFrom(today));

      cars.add(car1);
      cars.add(car2);
      cars.add(car3);
      cars.add(car4);
      cars.add(car5);

      return cars;
    }

    private Car createCar5(CalendarDate manufacturingDate) {
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

    private Car getCar4(CalendarDate manufacturingDate) {
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

    private Car getCar3(CalendarDate manufacturingDate) {
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

    private Car getCar2(CalendarDate manufacturingDate) {
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

    private Car getCar1(CalendarDate manufacturingDate) {
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
}
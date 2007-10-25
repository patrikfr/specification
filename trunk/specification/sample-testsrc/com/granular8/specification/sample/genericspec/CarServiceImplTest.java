package com.granular8.specification.sample.genericspec;

import com.domainlanguage.time.CalendarDate;
import com.domainlanguage.time.Duration;
import com.domainlanguage.timeutil.Clock;
import com.granular8.specification.sample.domain.*;
import static com.granular8.specification.sample.domain.Region.SOUTH_EAST;
import static com.granular8.specification.sample.domain.Region.SOUTH;
import static com.granular8.specification.sample.testutil.CarTestFactory.createCar1;
import static com.granular8.specification.sample.testutil.CarTestFactory.createCar2;
import static com.granular8.specification.sample.testutil.CarTestFactory.createCar3;
import static com.granular8.specification.sample.testutil.CarTestFactory.createCar4;
import static com.granular8.specification.sample.testutil.CarTestFactory.createCar5;
import com.granular8.specification.genericspec.Specification;
import junit.framework.TestCase;

import java.util.*;

public class CarServiceImplTest extends TestCase {

  //Scenario test for finding candidate cars using the CarService.

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

  public void testFindCandidateCarsSpec() throws Exception {
    CarServiceImpl carServiceImpl = new CarServiceImpl();
    carServiceImpl.setRepository(new CarRepositoryStub());

    CalendarDate today = Clock.now().calendarDate(TimeZone.getTimeZone("GMT"));

    final Specification<Car> colorRed = new CarColorSpecification(Color.RED);
    final Specification<Car> convertible = new ConvertibleCarSpecification();
    final Specification<Car> approvedState = new CarOwnerRegionSpecification(getAuthorizedRegions());
    final Specification<Car> approvedAge = new CarAgeSpecification(today, 5);

    final Specification<Car> candidateCarSpecification =
       colorRed.and(approvedState.and(approvedAge).or(convertible));

    Collection<Car> candicateCars = carServiceImpl.findCandidateCars(candidateCarSpecification);
    assertEquals(2, candicateCars.size());
  }

  //TODO: Move to generic test stub
  class CarRepositoryStub implements CarRepository {

    public Collection<Car> findAllCarsInStock() {

      final CalendarDate today = Clock.now().calendarDate(TimeZone.getTimeZone("GMT"));
      final CalendarDate mfgDate = Duration.years(2).subtractedFrom(today);

      List<Car> cars = new ArrayList<Car>();

      //Not vaild, wrong region
      Car car1 = createCar1(mfgDate);

      //Not valid, not red
      Car car2 = createCar2(mfgDate);

      //Valid, red + convertible
      Car car3 = createCar3(mfgDate);

      //Valid, red, from the right region and only two years old
      Car car4 = createCar4(mfgDate);

      //Invalid, too old
      Car car5 = createCar5(Duration.years(6).subtractedFrom(today));
      cars.add(car1);
      cars.add(car2);
      cars.add(car3);
      cars.add(car4);
      cars.add(car5);

      return cars;
    }
  }

  //TODO: Move to test stub
  private Set<Region> getAuthorizedRegions() {
    Set<Region> regions = new HashSet<Region>();
    regions.add(Region.SOUTH_WEST);
    regions.add(SOUTH_EAST);
    regions.add(SOUTH);

    return regions;
  }
}
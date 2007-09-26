package com.granular8.specification.genericspec;

import com.granular8.specification.sample.domain.*;
import com.granular8.specification.nospec.CarRepository;
import junit.framework.TestCase;

import java.util.*;

public class CarServiceImplTest extends TestCase {

  public void testFindCandidateCars() throws Exception {
    CarServiceImpl carServiceImpl = new CarServiceImpl();
    carServiceImpl.setRepository(new CarRepositoryStub());
    carServiceImpl.setAuthorizedStates(getAuthorizedStates());

    Collection<Car> candicateCars = carServiceImpl.findCandidateCars();
    assertEquals(1, candicateCars);


    fail("Test is not implemented");
  }

  private Set<Region> getAuthorizedStates() {
    Set<Region> regions = new HashSet<Region>();
    regions.add(Region.SOUTH_WEST);
    regions.add(Region.SOUTH_EAST);
    regions.add(Region.SOUTH);

    return regions;
  }


  class CarRepositoryStub implements CarRepository {

    public Collection<Car> findAllCarsInStock() {

      List<Car> cars = new ArrayList<Car>();

      Car car1 = new Car();
      car1.setColor(Color.RED);
      car1.setConvertible(false);
      Person car1Owner = new Person();
      Address car1OwnerAddress = new Address();
      car1OwnerAddress.setRegion(Region.NORTH_EAST);
      car1Owner.setHomeAddress(car1OwnerAddress);
      car1.setOwner(car1Owner);

      Car car2 = new Car();
      car2.setColor(Color.GREEN);
      car2.setConvertible(true);
      Person car2Owner = new Person();
      Address car2OwnerAddress = new Address();
      car2OwnerAddress.setRegion(Region.SOUTH);
      car2Owner.setHomeAddress(car2OwnerAddress);
      car2.setOwner(car2Owner);

      Car car3 = new Car();
      car3.setColor(Color.RED);
      car3.setConvertible(true);
      Person car3Owner = new Person();
      Address car3OwnerAddress = new Address();
      car3OwnerAddress.setRegion(Region.NORTH_EAST);
      car3Owner.setHomeAddress(car3OwnerAddress);
      car3.setOwner(car3Owner);

      cars.add(car1);
      cars.add(car2);
      cars.add(car3);

      return cars;
    }
  }
}
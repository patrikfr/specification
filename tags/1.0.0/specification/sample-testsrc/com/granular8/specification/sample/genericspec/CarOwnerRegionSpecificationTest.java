package com.granular8.specification.sample.genericspec;

import com.granular8.specification.sample.domain.Address;
import com.granular8.specification.sample.domain.Car;
import com.granular8.specification.sample.domain.Person;
import com.granular8.specification.sample.domain.Region;
import static com.granular8.specification.sample.domain.Region.*;
import junit.framework.TestCase;

import java.util.HashSet;
import java.util.Set;

public class CarOwnerRegionSpecificationTest extends TestCase {


  public void testFindCandidateCars() throws Exception {

    Set<Region> approvedRegions = new HashSet<Region>();
    approvedRegions.add(NORTH_EAST);
    approvedRegions.add(NORTH_WEST);
    CarOwnerRegionSpecification spec = new CarOwnerRegionSpecification(approvedRegions);

    Car car = new Car();
    Person owner = new Person();
    Address homeAddress = new Address();
    homeAddress.setRegion(NORTH_WEST);
    owner.setHomeAddress(homeAddress);
    car.setOwner(owner);
    assertTrue(spec.isSatisfiedBy(car));

    homeAddress.setRegion(SOUTH);
    assertFalse(spec.isSatisfiedBy(car));
  }
}
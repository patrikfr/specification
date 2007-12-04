package com.granular8.specification.sample.genericspec;

import com.granular8.specification.sample.domain.Car;
import com.granular8.specification.sample.spec.ConvertibleCarSpecification;
import junit.framework.TestCase;

public class ConvertibleCarSpecificationTest extends TestCase {


  public void testFindCandidateCars() throws Exception {

    ConvertibleCarSpecification spec = new ConvertibleCarSpecification();

    Car car = new Car();
    car.setConvertible(true);
    assertTrue(spec.isSatisfiedBy(car));

    car.setConvertible(false);
    assertFalse(spec.isSatisfiedBy(car));
  }
}
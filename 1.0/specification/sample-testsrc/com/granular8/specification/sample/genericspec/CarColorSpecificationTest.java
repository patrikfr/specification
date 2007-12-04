package com.granular8.specification.sample.genericspec;

import com.granular8.specification.sample.domain.Car;
import com.granular8.specification.sample.domain.Color;
import static com.granular8.specification.sample.domain.Color.RED;
import junit.framework.TestCase;

public class CarColorSpecificationTest extends TestCase {


  public void testFindCandidateCars() throws Exception {

    CarColorSpecification spec = new CarColorSpecification(RED);

    Car car = new Car();
    car.setColor(RED);
    assertTrue(spec.isSatisfiedBy(car));

    car.setColor(Color.GREEN);
    assertFalse(spec.isSatisfiedBy(car));
  }
}
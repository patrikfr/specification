package com.granular8.specification.sample.spec;

import com.granular8.specification.sample.domain.Car;
import com.granular8.specification.sample.domain.Color;
import static com.granular8.specification.sample.domain.Color.RED;
import com.granular8.specification.sample.domain.Person;
import junit.framework.TestCase;

public class CarColorSpecificationTest extends TestCase {


  public void testFindCandidateCars() throws Exception {

    CarColorSpecification spec = new CarColorSpecification(RED);

    Car car = new Car();
    car.setColor(RED);
    assertTrue(spec.isSatisfiedBy(car));

    car.setColor(Color.GREEN);
    assertFalse(spec.isSatisfiedBy(car));

    Person person = new Person();
    try {
      spec.isSatisfiedBy(person);
      fail("Should throw ClassCastException");
    } catch (ClassCastException cce) {
      //expected
    }
  }
}
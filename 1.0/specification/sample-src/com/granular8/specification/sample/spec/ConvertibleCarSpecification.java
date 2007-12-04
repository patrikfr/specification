package com.granular8.specification.sample.spec;

import com.granular8.specification.spec.AbstractSpecification;
import com.granular8.specification.sample.domain.Car;

/**
 * Specification to tell if a car is a convertible.
 */
public class ConvertibleCarSpecification extends AbstractSpecification {

 /**
   * {@inheritDoc}
   */
  public boolean isSatisfiedBy(Object o) {
    if (o instanceof Car) {
      Car car = (Car) o;
      return car.isConvertible();
    } else {
      throw new ClassCastException("I only deal with cars, you gave me a: " +
         o.getClass().getCanonicalName());
    }
  }
}

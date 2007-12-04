package com.granular8.specification.sample.genericspec;

import com.granular8.specification.genericspec.AbstractSpecification;
import com.granular8.specification.sample.domain.Car;

/**
 * Specification to tell if a car is a convertible.
 */
public class ConvertibleCarSpecification extends AbstractSpecification<Car> {

  /**
   * {@inheritDoc}
   */
  public boolean isSatisfiedBy(Car car) {
    return car.isConvertible();
  }
}

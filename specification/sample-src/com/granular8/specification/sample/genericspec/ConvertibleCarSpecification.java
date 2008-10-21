package com.granular8.specification.sample.genericspec;

import com.granular8.specification.genericspec.Specification;
import com.granular8.specification.sample.domain.Car;

/**
 * Specification to tell if a car is a convertible.
 */
public class ConvertibleCarSpecification implements Specification<Car> {

  /**
   * {@inheritDoc}
   */
  public boolean isSatisfiedBy(Car car) {
    return car.isConvertible();
  }
}

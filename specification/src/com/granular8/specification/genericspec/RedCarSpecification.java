package com.granular8.specification.genericspec;

import com.granular8.specification.sample.domain.Car;
import com.granular8.specification.sample.domain.Color;

/**
 * Specification to tell if a car is red.
 */
public class RedCarSpecification extends AbstractSpecification<Car> {

  /**
   * Checks if a car color is {@code RED}
   * {@inheritDoc}
   *
   * @param car Car to check.
   * @return {@code true} if the {@code car} is a red car.
   */
  public boolean isSatisfiedBy(final Car car) {
      return car.color() == Color.RED;
  }
}

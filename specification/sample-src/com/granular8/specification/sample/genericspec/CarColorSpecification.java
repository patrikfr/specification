package com.granular8.specification.sample.genericspec;

import com.granular8.specification.genericspec.Specification;
import com.granular8.specification.sample.domain.Car;
import com.granular8.specification.sample.domain.Color;

/**
 * Specification to tell if a car is of specified color.
 */
public class CarColorSpecification implements Specification<Car> {

  private Color color;

  /**
   * Set color.
   * The car's color must be the same as the set color for the specification to be satisfied.
   *
   * @param color Car color
   */
  public CarColorSpecification(Color color) {
    this.color = color;
  }

  /**
   * {@inheritDoc}
   */
  public boolean isSatisfiedBy(final Car car) {
    return car.color() == color;
  }
}

package com.granular8.specification.sample.genericspec;

import com.granular8.specification.genericspec.AbstractSpecification;
import com.granular8.specification.sample.domain.Car;
import com.granular8.specification.sample.domain.Color;

/**
 * Specification to tell if a car is red.
 */
public class CarColorSpecification extends AbstractSpecification<Car> {

  private Color color;

  public CarColorSpecification(Color color) {
    this.color = color;
  }

  public boolean isSatisfiedBy(final Car car) {
    return car.color() == color;
  }
}

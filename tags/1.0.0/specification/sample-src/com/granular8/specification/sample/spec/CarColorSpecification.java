package com.granular8.specification.sample.spec;

import com.granular8.specification.sample.domain.Car;
import com.granular8.specification.sample.domain.Color;
import com.granular8.specification.spec.AbstractSpecification;

/**
 * Specification to tell if a car is of specified color.
 */
public class CarColorSpecification extends AbstractSpecification {
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
  public boolean isSatisfiedBy(Object o) {
    if (o instanceof Car) {
      Car car = (Car) o;
      return car.color() == color;
    } else {
      throw new ClassCastException("I only deal with cars, you gave me: " +
         o.getClass().getCanonicalName());
    }
  }
}

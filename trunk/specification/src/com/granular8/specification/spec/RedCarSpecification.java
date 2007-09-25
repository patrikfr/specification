package com.granular8.specification.spec;

import com.granular8.specification.domain.Car;
import static com.granular8.specification.domain.Color.RED;

/**
 * Specification to tell if a car is red.
 */
public class RedCarSpecification extends AbstractSpecification {

  /**
   * Checks if a car color is {@code RED}
   * {@inheritDoc}
   *
   * @param o Car to check. Note that only objects of type {@link Car} are supported.
   * @return {@code true} if the {@code o} is a red car.
   */
  public boolean isSatisfiedBy(final Object o) {
    if (o instanceof Car) {
      Car car = (Car) o;
      return car.color() == RED;
    } else {
      throw new UnsupportedOperationException("I only deal with cars, you gave me an: " +
          o.getClass().getCanonicalName());
    }
  }
}

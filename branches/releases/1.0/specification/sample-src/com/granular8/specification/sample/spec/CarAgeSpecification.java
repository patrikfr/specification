package com.granular8.specification.sample.spec;

import com.domainlanguage.time.CalendarDate;
import com.domainlanguage.time.Duration;
import com.granular8.specification.sample.domain.Car;
import com.granular8.specification.spec.AbstractSpecification;

/**
 * Specification to tell if a car younger than the specified maximum age.
 */
public class CarAgeSpecification extends AbstractSpecification {

  final CalendarDate today;
  final Duration maxAgeInYears;

  /**
   * Set max car age in years.
   * The car must be less than the specified max for the specification to be satisfied.
   *
   * @param maxAgeInYears Max age in years.
   * @param today         The date used as today's date when doing age comparison.
   */
  public CarAgeSpecification(CalendarDate today, int maxAgeInYears) {
    this.today = today;
    this.maxAgeInYears = Duration.years(maxAgeInYears);
  }

  /**
   * {@inheritDoc}
   */
  public boolean isSatisfiedBy(Object o) {
    if (o instanceof Car) {
      Car car = (Car) o;
      return maxAgeInYears.startingFrom(car.manufacturingDate()).includes(today);
    } else {
      throw new ClassCastException("I only deal with cars, you gave me: " +
         o.getClass().getCanonicalName());
    }
  }
}

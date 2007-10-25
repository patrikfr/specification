package com.granular8.specification.sample.genericspec;

import com.domainlanguage.time.CalendarDate;
import com.domainlanguage.time.Duration;
import com.granular8.specification.genericspec.AbstractSpecification;
import com.granular8.specification.sample.domain.Car;

/**
 * Specification to tell if a car younger than the specified maximum age.
 */
public class CarAgeSpecification extends AbstractSpecification<Car> {

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
  public boolean isSatisfiedBy(Car car) {
    return maxAgeInYears.startingFrom(car.manufacturingDate()).includes(today);
  }
}

package com.granular8.specification.sample.genericspec;

import com.granular8.specification.sample.domain.Car;
import com.granular8.specification.genericspec.AbstractSpecification;
import com.domainlanguage.time.CalendarDate;
import com.domainlanguage.time.Duration;
import com.domainlanguage.timeutil.Clock;

import java.util.TimeZone;

/**
 * Specification to tell if a car younger than the specified maximum age.
 */
public class CarAgeSpecification extends AbstractSpecification<Car> {

  final CalendarDate today = Clock.now().calendarDate(TimeZone.getTimeZone("GMT"));
  final Duration maxAgeInYears;

  /**
   * Set max car age in years.
   * The car must be less than the specified max for the specification to be satisfied.
   *
   * @param maxAgeInYears Max age in years.
   */
  public CarAgeSpecification(int maxAgeInYears) {
    this.maxAgeInYears = Duration.years(maxAgeInYears);
  }

  /**
   * {@inheritDoc}
   */
  public boolean isSatisfiedBy(Car car) {
    return maxAgeInYears.startingFrom(car.manufacturingDate()).includes(today);
  }
}

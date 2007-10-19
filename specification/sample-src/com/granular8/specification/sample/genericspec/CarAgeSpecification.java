package com.granular8.specification.sample.genericspec;

import com.granular8.specification.sample.domain.Car;
import com.granular8.specification.genericspec.AbstractSpecification;
import com.domainlanguage.time.CalendarDate;
import com.domainlanguage.time.Duration;
import com.domainlanguage.timeutil.Clock;

import java.util.TimeZone;

public class CarAgeSpecification extends AbstractSpecification<Car> {

  final CalendarDate today = Clock.now().calendarDate(TimeZone.getTimeZone("GMT"));
  final Duration maxAge;

  public CarAgeSpecification(int maxYearsAge) {
    maxAge = Duration.years(maxYearsAge);
  }

  public boolean isSatisfiedBy(Car car) {
    return maxAge.startingFrom(car.manufacturingDate()).includes(today);
  }
}

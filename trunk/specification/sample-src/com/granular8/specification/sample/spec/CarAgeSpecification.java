package com.granular8.specification.sample.spec;

import com.granular8.specification.spec.AbstractSpecification;
import com.granular8.specification.sample.domain.Car;
import com.domainlanguage.time.CalendarDate;
import com.domainlanguage.time.Duration;
import com.domainlanguage.timeutil.Clock;

import java.util.TimeZone;

public class CarAgeSpecification extends AbstractSpecification {

  final CalendarDate today = Clock.now().calendarDate(TimeZone.getTimeZone("GMT"));
  final Duration maxAge;

  public CarAgeSpecification(int maxYearsAge) {
    maxAge = Duration.years(maxYearsAge);
  }

  public boolean isSatisfiedBy(Object o) {
    if (o instanceof Car) {
      Car car = (Car) o;
      return maxAge.startingFrom(car.manufacturingDate()).includes(today);
    } else {
      throw new ClassCastException("I only deal with cars, you gave me: " +
         o.getClass().getCanonicalName());
    }
  }
}

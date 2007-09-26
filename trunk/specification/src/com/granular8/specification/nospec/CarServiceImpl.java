package com.granular8.specification.nospec;

import com.domainlanguage.time.CalendarDate;
import com.domainlanguage.time.Duration;
import com.domainlanguage.timeutil.Clock;
import com.granular8.specification.sample.domain.Car;
import com.granular8.specification.sample.domain.Color;
import com.granular8.specification.sample.domain.Region;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TimeZone;


public class CarServiceImpl {

  private CarRepository repository;
  private Set<Region> authorizedRegions;


  public void setRepository(final CarRepository repository) {
    this.repository = repository;
  }


  public void setAuthorizedRegions(final Set<Region> authorizedRegions) {
    this.authorizedRegions = authorizedRegions;
  }

  public Collection<Car> findCandidateCars() {

    final CalendarDate today = Clock.now().calendarDate(TimeZone.getTimeZone("GMT"));

    final Duration maxAge = Duration.years(3);

    final Collection<Car> cars = repository.findAllCarsInStock();
    final Collection<Car> keepers = new HashSet<Car>();

    for (Car car : cars) {
      if (car.color() == Color.RED &&
          (car.isConvertible() ||
              authorizedRegions.contains(car.owner().homeAddress().region()) ||
              (car.manufacturingDate().through(today).length().compareTo(maxAge) < 0)))
        keepers.add(car);

    }
    return keepers;
  }
}

package com.granular8.specification.sample.nospec;

import com.domainlanguage.time.CalendarDate;
import com.domainlanguage.time.Duration;
import com.domainlanguage.timeutil.Clock;
import com.granular8.specification.sample.domain.Car;
import com.granular8.specification.sample.domain.Color;
import com.granular8.specification.sample.domain.Region;
import static com.granular8.specification.sample.domain.Region.SOUTH_EAST;
import static com.granular8.specification.sample.domain.Region.SOUTH;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TimeZone;


public class CarServiceImpl {

  private CarRepository repository;

  public void setRepository(final CarRepository repository) {
    this.repository = repository;
  }

  public Collection<Car> findCandidateCars() {

    final CalendarDate today = Clock.now().calendarDate(TimeZone.getTimeZone("GMT"));

    final Duration maxAge = Duration.years(5);

    final Collection<Car> cars = repository.findAllCarsInStock();
    final Collection<Car> keepers = new HashSet<Car>();

    Set<Region> authorizedRegions = getAuthorizedRegions();

    for (Car car : cars) {
      if (car.color() == Color.RED &&
         (car.isConvertible() ||
            authorizedRegions.contains(car.owner().homeAddress().region()) &&
               maxAge.startingFrom(car.manufacturingDate()).includes(today)
         )
         )
        keepers.add(car);

    }
    return keepers;
  }

  private Set<Region> getAuthorizedRegions() {
    Set<Region> regions = new HashSet<Region>();
    regions.add(Region.SOUTH_WEST);
    regions.add(SOUTH_EAST);
    regions.add(SOUTH);

    return regions;
  }
}



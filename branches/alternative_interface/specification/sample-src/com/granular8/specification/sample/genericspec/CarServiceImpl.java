package com.granular8.specification.sample.genericspec;

import com.domainlanguage.time.CalendarDate;
import com.domainlanguage.timeutil.Clock;
import com.granular8.specification.genericspec.Specification;
import com.granular8.specification.sample.domain.Car;
import com.granular8.specification.sample.domain.Color;
import com.granular8.specification.sample.domain.Region;
import static com.granular8.specification.sample.domain.Region.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TimeZone;

/**
 * Default implementation of the {@link CarService} interface.
 */
public class CarServiceImpl implements CarService {

  private CarRepository repository;

  /**
   * {@inheritDoc}
   */
  public void setRepository(final CarRepository repository) {
    this.repository = repository;
  }


  /**
   * {@inheritDoc}
   */
  public Collection<Car> findCandidateCars() {

    final Collection<Car> cars = repository.findAllCarsInStock();
    final Collection<Car> keepers = new HashSet<Car>();

    CalendarDate today = Clock.now().calendarDate(TimeZone.getTimeZone("GMT"));

    final Specification<Car> approvedAge = new CarAgeSpecification(today, 5);
    final Specification<Car> colorRed = new CarColorSpecification(Color.RED);
    final Specification<Car> convertible = new ConvertibleCarSpecification();
    final Specification<Car> approvedRegion = new CarOwnerRegionSpecification(getAuthorizedRegions());

    final Specification<Car> candidateCarSpecification =
       colorRed.and(approvedRegion.and(approvedAge).or(convertible));

    for (final Car car : cars) {
      if (candidateCarSpecification.isSatisfiedBy(car))
        keepers.add(car);
    }
    return keepers;
  }

  private Set<Region> getAuthorizedRegions() {
    Set<Region> regions = new HashSet<Region>();
    regions.add(SOUTH_WEST);
    regions.add(SOUTH_EAST);
    regions.add(SOUTH);

    return regions;
  }

  /**
   * Check the national used car repository and find cars satistfying the given specification.
   *
   * @param specification Car specification.
   * @return Candidate cars.
   */
  public Collection<Car> findCandidateCars(Specification<Car> specification) {

    final Collection<Car> keepers = new HashSet<Car>();
    final Collection<Car> cars = repository.findAllCarsInStock();

    for (final Car car : cars) {
      if (specification.isSatisfiedBy(car))
        keepers.add(car);
    }
    return keepers;
  }

}

package com.granular8.specification.sample.genericspec;

import com.granular8.specification.sample.nospec.CarRepository;
import com.granular8.specification.sample.domain.Region;
import com.granular8.specification.sample.domain.Car;
import com.granular8.specification.genericspec.Specification;

import java.util.Set;
import java.util.Collection;
import java.util.HashSet;

/**
 * Default implementation of the {@link CarService} interface.
 */
public class CarServiceImpl implements CarService {

  private CarRepository repository;
  private Set<Region> authorizedRegions;

  /**
   * {@inheritDoc}
   */
  public void setRepository(final CarRepository repository) {
    this.repository = repository;
  }

  /**
   * {@inheritDoc}
   */
  public void setAuthorizedStates(final Set<Region> authorizedRegions) {
    this.authorizedRegions = authorizedRegions;
  }


  /**
   * Check the national used car repository and find cars that might be of interest for the business.
   *
   * @return Candidate cars.
   */
  public Collection<Car> findCandidateCars() {

    final Collection<Car> cars = repository.findAllCarsInStock();
    final Collection<Car> keepers = new HashSet<Car>();

    final Specification<Car> colorRed = new RedCarSpecification();
    final Specification<Car> convertible = new ConvertibleCarSpecification();
    final Specification<Car> approvedState = new CarOwnerRegionSpecification(authorizedRegions);
    final Specification<Car> approvedAge = new CarAgeSpecification();

    final Specification<Car> candidateCarSpecification =
        colorRed.and(approvedState.or(approvedAge).or(convertible));

    for (final Car car : cars) {
      if (candidateCarSpecification.isSatisfiedBy(car))
        keepers.add(car);
    }
    return keepers;
  }

}

package com.granular8.specification.spec;

import com.granular8.specification.sample.domain.Car;
import com.granular8.specification.nospec.CarRepository;
import com.granular8.specification.sample.domain.Region;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CarServiceImpl {

  private CarRepository repository;
  private Set<Region> authorizedRegions;

  public void setRepository(final CarRepository repository) {
    this.repository = repository;
  }


  public void setAuthorizedStates(final Set<Region> authorizedRegions) {
    this.authorizedRegions = authorizedRegions;
  }

  public Collection<Car> findCandidateCars() {

    final Collection<Car> cars = repository.findAllCarsInStock();
    final Collection<Car> keepers = new HashSet<Car>();

    final Specification colorRed = new RedCarSpecification();
    final Specification convertible = new ConvertibleCarSpecification();
    final Specification approvedState = new CarOwnerRegionSpecification(authorizedRegions);
    final Specification approvedAge = new CarAgeSpecification();

    final Specification candidateCarSpecification = colorRed.and(approvedState.or(approvedAge).or(convertible));


    for (Car car : cars) {
      if (candidateCarSpecification.isSatisfiedBy(car))
        keepers.add(car);

    }
    return keepers;


  }

}

package com.granular8.specification.sample.spec;

import com.granular8.specification.sample.domain.Car;
import static com.granular8.specification.sample.domain.Color.RED;
import com.granular8.specification.sample.domain.Region;
import static com.granular8.specification.sample.domain.Region.SOUTH_EAST;
import static com.granular8.specification.sample.domain.Region.SOUTH;
import com.granular8.specification.sample.nospec.CarRepository;
import com.granular8.specification.spec.Specification;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CarServiceImpl {

  private CarRepository repository;


  public void setRepository(final CarRepository repository) {
    this.repository = repository;
  }

  public Collection<Car> findCandidateCars() {

    final Collection<Car> cars = repository.findAllCarsInStock();
    final Collection<Car> keepers = new HashSet<Car>();

    final Specification colorRed = new CarColorSpecification(RED);
    final Specification convertible = new ConvertibleCarSpecification();
    final Specification approvedState = new CarOwnerRegionSpecification(getAuthorizedRegions());
    final Specification approvedAge = new CarAgeSpecification(5);

    final Specification candidateCarSpecification = colorRed.and(approvedState.and(approvedAge).or(convertible));


    for (Car car : cars) {
      if (candidateCarSpecification.isSatisfiedBy(car))
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

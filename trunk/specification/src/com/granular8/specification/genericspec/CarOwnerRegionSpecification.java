package com.granular8.specification.genericspec;

import com.granular8.specification.sample.domain.Car;
import com.granular8.specification.sample.domain.Region;

import java.util.Set;

public class CarOwnerRegionSpecification extends AbstractSpecification<Car> {
  private Set<Region> authorizedRegions;

  public CarOwnerRegionSpecification(final Set<Region> authorizedRegions) {
    this.authorizedRegions = authorizedRegions;
  }

  public boolean isSatisfiedBy(Car car) {
    return (authorizedRegions.contains(car.owner().homeAddress().region()));
  }
}

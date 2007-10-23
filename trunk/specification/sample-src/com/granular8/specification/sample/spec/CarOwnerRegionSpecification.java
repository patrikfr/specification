package com.granular8.specification.sample.spec;

import com.granular8.specification.sample.domain.Region;
import com.granular8.specification.sample.domain.Car;
import com.granular8.specification.spec.AbstractSpecification;

import java.util.Set;

/**
 * Specification to tell if a car's owner's home address is in the specifed set of
 * authorized regions.
 */
public class CarOwnerRegionSpecification extends AbstractSpecification {
  private Set<Region> authorizedRegions;

  /**
   * Set authorized regions.
   * The car's owner's home address must be in one of the supplied regions for the
   * specification to be satisfied.
   *
   * @param authorizedRegions Set of regions.
   */
  public CarOwnerRegionSpecification(Set<Region> authorizedRegions) {
    this.authorizedRegions = authorizedRegions;
  }

  /**
   * {@inheritDoc}
   */
  public boolean isSatisfiedBy(Object o) {
    if (o instanceof Car) {
      Car car = (Car) o;
      return authorizedRegions.contains(car.owner().homeAddress().region());
    } else {
      throw new ClassCastException("I only deal with cars, you gave me: " +
         o.getClass().getCanonicalName());
    }
  }
}

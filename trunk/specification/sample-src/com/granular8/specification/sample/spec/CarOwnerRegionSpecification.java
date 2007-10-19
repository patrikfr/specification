package com.granular8.specification.sample.spec;

import com.granular8.specification.sample.domain.Region;
import com.granular8.specification.spec.AbstractSpecification;

import java.util.Set;

public class CarOwnerRegionSpecification extends AbstractSpecification {
  public CarOwnerRegionSpecification(final Set<Region> authorizedRegions) {

  }

  public boolean isSatisfiedBy(Object o) {
    throw new UnsupportedOperationException();
  }
}

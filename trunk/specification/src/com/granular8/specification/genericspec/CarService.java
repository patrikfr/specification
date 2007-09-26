package com.granular8.specification.genericspec;

import com.granular8.specification.nospec.CarRepository;
import com.granular8.specification.sample.domain.Region;
import com.granular8.specification.sample.domain.Car;

import java.util.Set;
import java.util.Collection;

public interface CarService {
  void setRepository(CarRepository repository);

  void setAuthorizedStates(Set<Region> authorizedRegions);

  Collection<Car> findCandidateCars();
}

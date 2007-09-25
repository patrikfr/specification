package com.granular8.specification.genericspec;

import com.granular8.specification.nospec.CarRepository;
import com.granular8.specification.domain.Region;
import com.granular8.specification.domain.Car;

import java.util.Set;
import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: patrik
 * Date: Jan 31, 2007
 * Time: 8:06:10 AM
 * To change this template use File | Settings | File Templates.
 */
public interface CarService {
  void setRepository(CarRepository repository);

  void setAuthorizedStates(Set<Region> authorizedRegions);

  Collection<Car> findCandidateCars();
}

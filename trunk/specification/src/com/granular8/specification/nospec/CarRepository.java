package com.granular8.specification.nospec;

import com.granular8.specification.domain.Car;

import java.util.Collection;

public interface CarRepository {
  public Collection<Car> findAllCarsInStock();
}

package com.granular8.specification.sample.nospec;

import com.granular8.specification.sample.domain.Car;

import java.util.Collection;

/**
 * Car repository.
 */
public interface CarRepository {

  /**
   * Return all cars in the repository.
   * @return All cars in the repository.
   */
  public Collection<Car> findAllCarsInStock();
}

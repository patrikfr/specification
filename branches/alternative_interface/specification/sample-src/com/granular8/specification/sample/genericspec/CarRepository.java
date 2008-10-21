package com.granular8.specification.sample.genericspec;

import com.granular8.specification.sample.domain.Car;

import java.util.Collection;

/**
 * Repository for cars.
 */
public interface CarRepository {

  /**
   * Return all cars in the repository.
   *
   * @return All cars in the repository.
   */
  public Collection<Car> findAllCarsInStock();
}
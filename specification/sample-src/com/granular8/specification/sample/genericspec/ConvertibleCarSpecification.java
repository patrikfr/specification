package com.granular8.specification.sample.genericspec;

import com.granular8.specification.genericspec.AbstractSpecification;
import com.granular8.specification.sample.domain.Car;

public class ConvertibleCarSpecification extends AbstractSpecification<Car> {

  public boolean isSatisfiedBy(Car car) {
    return car.isConvertible();
  }
}

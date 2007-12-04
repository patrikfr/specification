package com.granular8.specification.genericspec;

public class AlwaysTrueSpec extends AbstractSpecification<Object> {
  public boolean isSatisfiedBy(Object o) {
    return true;
  }
}

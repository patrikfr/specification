package com.granular8.specification.genericspec;

public class AlwaysFalseSpec extends AbstractSpecification<Object> {
  public boolean isSatisfiedBy(Object o) {
    return false;
  }
}
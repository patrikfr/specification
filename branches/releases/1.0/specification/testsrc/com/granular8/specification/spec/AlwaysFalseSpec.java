package com.granular8.specification.spec;

public class AlwaysFalseSpec extends AbstractSpecification {
  public boolean isSatisfiedBy(Object o) {
    return false;
  }
}
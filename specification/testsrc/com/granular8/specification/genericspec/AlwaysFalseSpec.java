package com.granular8.specification.genericspec;

public class AlwaysFalseSpec implements Specification<Object> {
  public boolean isSatisfiedBy(Object o) {
    return false;
  }
}
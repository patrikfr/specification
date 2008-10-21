package com.granular8.specification.genericspec;

public class AlwaysTrueSpec implements Specification<Object> {
  public boolean isSatisfiedBy(Object o) {
    return true;
  }
}

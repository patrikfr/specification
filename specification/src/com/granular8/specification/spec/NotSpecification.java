package com.granular8.specification.spec;

public class NotSpecification extends AbstractSpecification {

  private Specification spec1;

  public NotSpecification(final Specification spec1) {
    this.spec1 = spec1;
  }

  public boolean isSatisfiedBy(final Object o) {
    return !spec1.isSatisfiedBy(o);
  }
}

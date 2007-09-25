package com.granular8.specification.spec;

public class AndSpecification extends AbstractSpecification {

  private Specification spec1;
  private Specification spec2;

  public AndSpecification(final Specification spec1, final Specification spec2) {
    this.spec1 = spec1;
    this.spec2 = spec2;
  }

  public boolean isSatisfiedBy(final Object o) {
    return spec1.isSatisfiedBy(o) && spec2.isSatisfiedBy(o);
  }
}

package com.granular8.specification.genericspec;

/**
 * AND specification, used to create a new specifcation that is the AND of two other specifications.
 */
public class AndSpecification<T> implements Specification<T> {

  private Specification<T> spec1;
  private Specification<T> spec2;
  private Specification<T>[] optionalSpec;

  /**
   * Create a new AND specification based on two other spec.
   *
   * @param spec1        Specification one.
   * @param spec2        Specification two.
   * @param optionalSpec Additional optional specs to evaluate using OR
   */
  public AndSpecification(final Specification<T> spec1, final Specification<T> spec2, final Specification<T>... optionalSpec) {
    this.spec1 = spec1;
    this.spec2 = spec2;
    this.optionalSpec = optionalSpec;
  }

  /**
   * {@inheritDoc}
   */
  public boolean isSatisfiedBy(final T t) {
    boolean isSatisfied = spec1.isSatisfiedBy(t) && spec2.isSatisfiedBy(t);
    if (!isSatisfied) {
      return false;
    }
    for (Specification<T> specification : optionalSpec) {
      if (!specification.isSatisfiedBy(t)) {
        return false;
      }
    }
    return true;
  }
}

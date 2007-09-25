package com.granular8.specification.spec;

/**
 * Abstract base implementation of composite {@link Specification} with default implementations for {@code and},
 * {@code or} and {@code not}
 */
public abstract class AbstractSpecification implements Specification {


  /**
   * {@inheritDoc}
   */
  public abstract boolean isSatisfiedBy(Object o);


  public Specification and(final Specification specification) {
    return new AndSpecification(this, specification);
  }

  public Specification or(final Specification specification) {
    return new OrSpecification(this, specification);
  }

  public Specification not(final Specification specification) {
    return new NotSpecification(specification);
  }
}

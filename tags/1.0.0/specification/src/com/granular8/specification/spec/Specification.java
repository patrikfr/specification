package com.granular8.specification.spec;

/**
 * Specificaiton interface.
 * <p/>
 * Use {@link AbstractSpecification} as base for creating specifications, and
 * only the method {@link #isSatisfiedBy(Object)} must be implemented.
 */
public interface Specification {

  /**
   * Check if {@code t} is satisfied by the specification.
   *
   * @param o Object to test.
   * @return {@code true} if {@code t} satisfies the specification.
   * @throws ClassCastException Thrown if o can not be cast to expected type.
   */
  boolean isSatisfiedBy(Object o);

  /**
   * Create a new specification that is the AND operation of {@code this} specification and another specification.
   *
   * @param specification Specification to AND.
   * @return A new specification.
   */
  Specification and(Specification specification);

  /**
   * Create a new specification that is the OR operation of {@code this} specification and another specification.
   *
   * @param specification Specification to OR.
   * @return A new specification.
   */
  Specification or(Specification specification);

  /**
   * Create a new specification that is the NOT operation of {@code this} specification.
   *
   * @param specification Specification to NOT.
   * @return A new specification.
   */
  Specification not(Specification specification);
}

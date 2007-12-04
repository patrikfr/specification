package com.granular8.specification.spec;

import junit.framework.TestCase;

public class AndSpecificationTest extends TestCase {

  public void testAndIsSatisifedBy() throws Exception {
    AlwaysTrueSpec trueSpec = new AlwaysTrueSpec();
    AlwaysFalseSpec falseSpec = new AlwaysFalseSpec();

    AndSpecification andSpecification = new AndSpecification(trueSpec, trueSpec);
    assertTrue(andSpecification.isSatisfiedBy(new Object()));

    andSpecification = new AndSpecification(falseSpec, trueSpec);
    assertFalse(andSpecification.isSatisfiedBy(new Object()));

    andSpecification = new AndSpecification(trueSpec, falseSpec);
    assertFalse(andSpecification.isSatisfiedBy(new Object()));

    andSpecification = new AndSpecification(falseSpec, falseSpec);
    assertFalse(andSpecification.isSatisfiedBy(new Object()));

  }
}
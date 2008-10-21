package com.granular8.specification.spec;

import junit.framework.TestCase;

public class OrSpecificationTest extends TestCase {

  public void testAndIsSatisifedBy() throws Exception {
    AlwaysTrueSpec trueSpec = new AlwaysTrueSpec();
    AlwaysFalseSpec falseSpec = new AlwaysFalseSpec();

    OrSpecification orSpecification = new OrSpecification(trueSpec, trueSpec);
    assertTrue(orSpecification.isSatisfiedBy(new Object()));

    orSpecification = new OrSpecification(falseSpec, trueSpec);
    assertTrue(orSpecification.isSatisfiedBy(new Object()));

    orSpecification = new OrSpecification(trueSpec, falseSpec);
    assertTrue(orSpecification.isSatisfiedBy(new Object()));

    orSpecification = new OrSpecification(falseSpec, falseSpec);
    assertFalse(orSpecification.isSatisfiedBy(new Object()));

  }
}
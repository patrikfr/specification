package com.granular8.specification.genericspec;

import junit.framework.TestCase;

public class OrSpecificationTest extends TestCase {

  public void testOrIsSatisifedBy() throws Exception {
    AlwaysTrueSpec trueSpec = new AlwaysTrueSpec();
    AlwaysFalseSpec falseSpec = new AlwaysFalseSpec();

    OrSpecification<Object> orSpecification = new OrSpecification<Object>(trueSpec, trueSpec);
    assertTrue(orSpecification.isSatisfiedBy(new Object()));

    orSpecification = new OrSpecification<Object>(trueSpec, trueSpec, trueSpec);
    assertTrue(orSpecification.isSatisfiedBy(new Object()));

    orSpecification = new OrSpecification<Object>(falseSpec, trueSpec);
    assertTrue(orSpecification.isSatisfiedBy(new Object()));

    orSpecification = new OrSpecification<Object>(falseSpec, trueSpec, trueSpec);
    assertTrue(orSpecification.isSatisfiedBy(new Object()));

    orSpecification = new OrSpecification<Object>(falseSpec, trueSpec, falseSpec);
    assertTrue(orSpecification.isSatisfiedBy(new Object()));

    orSpecification = new OrSpecification<Object>(falseSpec, falseSpec, trueSpec);
    assertTrue(orSpecification.isSatisfiedBy(new Object()));

    orSpecification = new OrSpecification<Object>(trueSpec, falseSpec);
    assertTrue(orSpecification.isSatisfiedBy(new Object()));

    orSpecification = new OrSpecification<Object>(falseSpec, falseSpec);
    assertFalse(orSpecification.isSatisfiedBy(new Object()));

    orSpecification = new OrSpecification<Object>(falseSpec, falseSpec, falseSpec);
    assertFalse(orSpecification.isSatisfiedBy(new Object()));

  }
}
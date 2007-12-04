package com.granular8.specification.spec;

import junit.framework.TestCase;

public class NotSpecificationTest extends TestCase {

  public void testAndIsSatisifedBy() throws Exception {
    AlwaysTrueSpec trueSpec = new AlwaysTrueSpec();
    AlwaysFalseSpec falseSpec = new AlwaysFalseSpec();

    NotSpecification notSpecification = new NotSpecification(trueSpec);
    assertFalse(notSpecification.isSatisfiedBy(new Object()));

    notSpecification = new NotSpecification(falseSpec);
    assertTrue(notSpecification.isSatisfiedBy(new Object()));

  }
}
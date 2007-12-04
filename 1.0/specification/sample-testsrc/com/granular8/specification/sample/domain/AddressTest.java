package com.granular8.specification.sample.domain;

import junit.framework.TestCase;

public class AddressTest extends TestCase {

  public void testRegion() throws Exception {
    Address address = new Address();
    address.setRegion(Region.NORTH_EAST);
    assertSame(Region.NORTH_EAST, address.region());
  }
}
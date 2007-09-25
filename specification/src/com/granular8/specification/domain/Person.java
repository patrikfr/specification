package com.granular8.specification.domain;

public class Person {

  private Address homeAddress;


  public Address homeAddress() {
    return homeAddress;
  }

  public void setHomeAddress(Address homeAddress) {
    this.homeAddress = homeAddress;
  }
}

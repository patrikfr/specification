package com.granular8.specification.sample.domain;

public class Person {

  private Address homeAddress;


  public Address homeAddress() {
    return homeAddress;
  }

  public void setHomeAddress(Address homeAddress) {
    this.homeAddress = homeAddress;
  }


  public String toString() {
    return "Person{" +
       "homeAddress=" + homeAddress +
       '}';
  }
}

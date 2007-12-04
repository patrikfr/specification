package com.granular8.specification.sample.domain;

import com.domainlanguage.time.CalendarDate;


public class Car {

  private Color color;
  private boolean convertible;
  private Person owner;
  private CalendarDate manufacturingDate;


  public Color color() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public boolean isConvertible() {
    return convertible;
  }

  public void setConvertible(boolean convertible) {
    this.convertible = convertible;
  }

  public Person owner() {
    return owner;
  }

  public void setOwner(Person owner) {
    this.owner = owner;
  }

  public CalendarDate manufacturingDate() {
    return manufacturingDate;
  }

  public void setManufacturingDate(CalendarDate manufacturingDate) {
    this.manufacturingDate = manufacturingDate;
  }


  public String toString() {
    return "Car{" +
       "color=" + color +
       ", convertible=" + convertible +
       ", owner=" + owner +
       ", manufacturingDate=" + manufacturingDate +
       '}';
  }
}

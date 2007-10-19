package com.granular8.specification.sample.genericspec;

import com.domainlanguage.time.CalendarDate;
import com.domainlanguage.time.Duration;
import com.domainlanguage.timeutil.Clock;
import com.granular8.specification.sample.domain.Car;
import junit.framework.TestCase;

import java.util.TimeZone;

public class CarAgeSpecificationTest extends TestCase {


  public void testFindCandidateCars() throws Exception {

    CarAgeSpecification spec = new CarAgeSpecification(5);

    CalendarDate today = Clock.now().calendarDate(TimeZone.getTimeZone("GMT"));
    CalendarDate mfgDate = Duration.years(2).subtractedFrom(today);

    Car car = new Car();
    car.setManufacturingDate(mfgDate);
    assertTrue(spec.isSatisfiedBy(car));

    mfgDate = Duration.years(6).subtractedFrom(today);
    car.setManufacturingDate(mfgDate);
    assertFalse(spec.isSatisfiedBy(car));
  }
}
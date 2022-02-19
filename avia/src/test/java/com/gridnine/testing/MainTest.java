package com.gridnine.testing;

import com.gridnine.testing.factory.FlightFactory;
import com.gridnine.testing.filter.FlightFilter;
import com.gridnine.testing.models.Flight;
import com.gridnine.testing.models.FlightBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

public class MainTest {
    List<Flight> flights = FlightBuilder.createFlights();

    @Test
    void flightsCountAfterDepartureBeforePresentTimeFilterShouldBeOneLess() {
        FlightFilter flightFilter = FlightFactory.createFlightFilterByType("depBeforePT");
        int actual = (int) flights.stream().filter(flightFilter::checkFlight).count();
        int expected = flights.size() - 1;
        Assertions.assertEquals(actual, expected);
    }

    @Test
    void flightsCountAfterArrivalBeforeDepartureFilterShouldBeOneLess() {
        FlightFilter flightFilter = FlightFactory.createFlightFilterByType("depBeforePT");
        int actual = (int) flights.stream().filter(flightFilter::checkFlight).count();
        int expected = flights.size() - 1;
        Assertions.assertEquals(actual, expected);
    }

    @Test
    void flightsCountAfterMoreThanTwoHoursExpectationFilterShouldBeFiveLess() {
        FlightFilter flightFilter = FlightFactory.createFlightFilterByType("moreTwoHours");
        int actual = (int) flights.stream().filter(flightFilter::checkFlight).count();
        int expected = flights.size() - 5;
        Assertions.assertEquals(actual, expected);
    }
}

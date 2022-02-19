package com.gridnine.testing.factory;

import com.gridnine.testing.filter.FlightFilter;
import com.gridnine.testing.models.Flight;
import com.gridnine.testing.models.FlightBuilder;

import java.util.List;
import java.util.stream.Collectors;

public class FilterByType {

    public static List<Flight> flightFilter(String... types) { //метод для фильтрации полетов, можно использовать сразу несколько фильтров
        List<Flight> flights = FlightBuilder.createFlights();
        for (String type : types) {
            FlightFilter flightFilter = FlightFactory.createFlightFilterByType(type);
            flights = flights.stream().filter(flightFilter::checkFlight).collect(Collectors.toList());
        }
        return flights;
    }
}

package com.gridnine.testing.factory;


import com.gridnine.testing.filter.ArrivalBeforeDeparture;
import com.gridnine.testing.filter.DepartureBeforePresentTime;
import com.gridnine.testing.filter.FlightFilter;
import com.gridnine.testing.filter.MoreThanTwoHoursExpectation;

public class FlightFactory {

    public static FlightFilter createFlightFilterByType(String type) { //использовал паттерн Factory
        switch (type) {
            case ("arrBeforeDep"):
                return new ArrivalBeforeDeparture();
            case ("depBeforePT"):
                return new DepartureBeforePresentTime();
            case ("moreTwoHours"):
                return new MoreThanTwoHoursExpectation();
            default:
                return null;
        }
    }
}

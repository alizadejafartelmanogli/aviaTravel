package com.gridnine.testing.filter;

import com.gridnine.testing.models.Flight;

public interface FlightFilter {
    boolean checkFlight(Flight flight);
}

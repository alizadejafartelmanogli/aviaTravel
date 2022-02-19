package com.gridnine.testing.filter;

import com.gridnine.testing.models.Flight;
import com.gridnine.testing.models.Segment;
import java.time.LocalDateTime;

public class DepartureBeforePresentTime implements FlightFilter {
    @Override
    public boolean checkFlight(Flight flight) {
        for (Segment segment : flight.getSegments()) {
            if (segment.getDepartureDate().isBefore(LocalDateTime.now())) //проверяеи была ли дата убытия раньше настоящего времени
                return false;
        }
        return true;
    }
}

package com.gridnine.testing.filter;

import com.gridnine.testing.models.Flight;
import com.gridnine.testing.models.Segment;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class MoreThanTwoHoursExpectation implements FlightFilter {

    @Override
    public boolean checkFlight(Flight flight) {
        if (flight.getSegments().size() > 1) {
            List<Segment> segments = flight.getSegments();
            int expectation = 0;
            int count = 0;
            for (int i = 0; i < segments.size() - 1; i++) {
                LocalDateTime arrival = segments.get(i).getArrivalDate();
                LocalDateTime nextDeparture = segments.get(i + 1).getDepartureDate();
                expectation += arrival.until(nextDeparture, ChronoUnit.MINUTES);
                count++;
                if (count == segments.size() - 1) return expectation / 60 <= 2;
            }
        }
        return false;
    }
}

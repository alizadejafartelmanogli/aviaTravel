package com.gridnine.testing.filter;

import com.gridnine.testing.models.Flight;
import com.gridnine.testing.models.Segment;

import java.time.LocalDateTime;
import java.util.List;

public class ArrivalBeforeDeparture implements FlightFilter {

    @Override
    public boolean checkFlight(Flight flight) {
        if (flight.getSegments().size() == 1) {  //проверяем если полет из одного сегмента
            Segment segment = flight.getSegments().get(0);
            LocalDateTime arrival = segment.getArrivalDate();
            LocalDateTime departure = segment.getDepartureDate();
            if (arrival.isBefore(departure)) {
                return false;
            }
        } else {
            List<Segment> segments = flight.getSegments(); //проверяем если полет из многих сегментов
            for (int i = 0; i < segments.size() - 1; i++) {
                LocalDateTime arrival = segments.get(i).getArrivalDate();
                LocalDateTime departure = segments.get(i).getDepartureDate();
                LocalDateTime nextSegment = segments.get(i + 1).getDepartureDate();
                if (departure.isAfter(arrival) || arrival.isAfter(nextSegment))//если убытие после прибытия  или прибытие после убытия следующего сегмента
                    return false;
            }
        }
        return true;
    }
}

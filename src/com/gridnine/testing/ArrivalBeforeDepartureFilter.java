package com.gridnine.testing;

import java.util.List;
import java.util.stream.Collectors;
//Фильтр по правилу: Сегменты с датой прилёта раньше даты вылета
public class ArrivalBeforeDepartureFilter implements FlightFilter{
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> !segment.getArrivalDate().isBefore(segment.getDepartureDate())))
                .collect(Collectors.toList());
    }
}

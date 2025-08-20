package com.gridnine.testing;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

//Фильтр по правилу: Перелеты, где общее время, проведённое на земле, превышает два часа
public class GroundTimeExceedsFilter implements FlightFilter{
    private final long maxGroundHours;

    public GroundTimeExceedsFilter(long maxGroundHours) {
        this.maxGroundHours = maxGroundHours;
    }
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> {
                    List<Segment> segs = flight.getSegments();
                    long totalGroundHours = 0;
                    for (int i = 0; i < segs.size() - 1; i++) {
                        totalGroundHours += Duration.between(segs.get(i).getArrivalDate(),
                                segs.get(i + 1).getDepartureDate()).toHours();
                    }
                    return totalGroundHours <= maxGroundHours;
                }).collect(Collectors.toUnmodifiableList());
    }

}

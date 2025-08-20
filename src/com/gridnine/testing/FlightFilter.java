package com.gridnine.testing;

import java.util.List;
//Интерфейс фильтра для добавления правил
public interface FlightFilter {
    List<Flight> filter(List<Flight> flights);
}

package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Создали список
        List<Flight> flights = FlightBuilder.createFlights();
        System.out.println("Исходный список перелётов:");
        flights.forEach(System.out::println);


        //Фильтруем. Надеюсь я понял задание правильно и нужно именно ИСКЛЮЧИТЬ вылеты, соответствующие указанным правилам
        System.out.println("\nИсключаем из списка вылеты, где: вылет до текущего времени:");
        flights.stream()
                .filter(f -> new DepartureBeforeNowFilter().filter(List.of(f)).size() > 0)
                .forEach(System.out::println);

        System.out.println("\nИсключаем из списка вылеты, где: прилёт раньше вылета:");
        flights.stream()
                .filter(f -> new ArrivalBeforeDepartureFilter().filter(List.of(f)).size() > 0)
                .forEach(System.out::println);

        System.out.println("\nИсключаем из списка вылеты, где: время на земле более 2 часов:");
        flights.stream()
                .filter(f -> new GroundTimeExceedsFilter(2).filter(List.of(f)).size() > 0)
                .forEach(System.out::println);
    }
}
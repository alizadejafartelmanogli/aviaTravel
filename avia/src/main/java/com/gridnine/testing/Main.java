package com.gridnine.testing;

import com.gridnine.testing.factory.FilterByType;


public class Main {
    public static void main(String[] args) {
        //depBeforePT - Исключает вылеты до текущего момента времени
        //arrBeforeDep - Исключает сегменты с датой прилёта раньше даты вылета
        //moreTwoHours - Исключает перелеты, где общее время, проведённое на земле превышает два часа
        //также можно использовать несколько фильтров, указав их в аргументах метода flightFilter через запятую
        System.out.println("1.Исключены вылеты до текущего момента времени");
        System.out.println(FilterByType.flightFilter("depBeforePT"));

        System.out.println("2.Исключены сегменты с датой прилёта раньше даты вылета");
        System.out.println(FilterByType.flightFilter("arrBeforeDep"));

        System.out.println("3.Исключены перелеты, где общее время, проведённое на земле превышает два часа");
        System.out.println(FilterByType.flightFilter("moreTwoHours"));
    }
}
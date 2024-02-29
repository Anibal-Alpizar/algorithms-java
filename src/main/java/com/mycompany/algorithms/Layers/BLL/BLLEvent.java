/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.algorithms.Layers.BLL;

import com.mycompany.algorithms.Layers.DAL.DALEvent;
import com.mycompany.algorithms.Layers.Entities.Event;
import java.util.LinkedList;

/**
 *
 * @author anibal
 */
public class BLLEvent {

    public static boolean saveEvent(Event event) {
        return DALEvent.saveEvent(event);
    }

    public static LinkedList<Event> obtenerEventos() {
        return DALEvent.obtenerEventos();
    }

    public static LinkedList<Event> obtenerEventosPorFecha(int year, int month) {
        return DALEvent.obtenerEventosPorFecha(year, month);
    }

    public static boolean updateEvent(Event event) {
        return DALEvent.updateEvent(event);
    }

    public static LinkedList<Event> obtenerEventosEntreHoras(String firstHour, String secondHour) {
        if (!isValidHourFormat(firstHour) || !isValidHourFormat(secondHour)) {
            return new LinkedList<>();
        }

        int firstMinute = convertToMinutes(firstHour);
        int secondMinute = convertToMinutes(secondHour);

        LinkedList<Event> allEvents = DALEvent.obtenerEventos();

        LinkedList<Event> eventsInRange = new LinkedList<>();
        buscarEventosRecursivo(allEvents, firstMinute, secondMinute, 0, eventsInRange);

        return eventsInRange;
    }

    private static boolean isValidHourFormat(String hour) {
        return hour.matches("\\d{2}:\\d{2}");
    }

    private static int convertToMinutes(String hour) {
        String[] parts = hour.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }

    private static void buscarEventosRecursivo(LinkedList<Event> allEvents, int firstMinute, int secondMinute, int currentIndex, LinkedList<Event> eventsInRange) {
        if (currentIndex >= allEvents.size()) {
            return;
        }

        Event currentEvent = allEvents.get(currentIndex);
        int eventMinute = convertToMinutes(currentEvent.getHour());

        if (eventMinute >= firstMinute && eventMinute <= secondMinute) {
            eventsInRange.add(currentEvent);
        }

        buscarEventosRecursivo(allEvents, firstMinute, secondMinute, currentIndex + 1, eventsInRange);
    }
}

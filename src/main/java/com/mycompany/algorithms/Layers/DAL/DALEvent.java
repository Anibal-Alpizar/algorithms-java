/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.algorithms.Layers.DAL;

import com.mycompany.algorithms.Layers.Entities.Event;
import java.util.LinkedList;

/**
 *
 * @author anibal
 */
public class DALEvent {

    private static LinkedList<Event> eventos = new LinkedList<>();

    public static boolean saveEvent(Event event) {
        return eventos.add(event);
    }

    public static LinkedList<Event> obtenerEventos() {
        return new LinkedList<>(eventos);
    }

    public static LinkedList<Event> obtenerEventosPorFecha(int year, int month) {
        LinkedList<Event> eventosPorFecha = new LinkedList<>();
        for (Event evento : eventos) {
            if (evento.getYear() == year && evento.getMonth() == month) {
                eventosPorFecha.add(evento);
            }
        }
        return eventosPorFecha;
    }

    public static boolean updateEvent(Event updatedEvent) {

        for (int i = 0; i < eventos.size(); i++) {
            Event existingEvent = eventos.get(i);
            if (existingEvent.getId() == updatedEvent.getId()) {
                // Actualizar los campos del evento existente con los nuevos datos
                eventos.set(i, updatedEvent);
                return true; // Actualización exitosa
            }
        }

        return false;
    }

}

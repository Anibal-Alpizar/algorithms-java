/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.algorithms.Layers.Entities;

/**
 *
 * @author anibal
 */
public class Event {

    private static int contadorId = 1;

    private int id;
    private int year;
    private int month;
    private int day;
    private String teamA;
    private String teamB;
    private String sport;
    private String competitionName;
    private String competitionCountry;
    private String hour;

    public Event(int year, int month, int day, String teamA, String teamB, String sport, String competitionName, String competitionCountry, String hour) {
        this.id = contadorId++;
        this.year = year;
        this.month = month;
        this.day = day;
        this.teamA = teamA;
        this.teamB = teamB;
        this.sport = sport;
        this.competitionName = competitionName;
        this.competitionCountry = competitionCountry;
        this.hour = hour;
    }

    public Event(int id, int year, int month, int day, String teamA, String teamB, String sport, String competitionName, String competitionCountry, String hour) {
        this.id = id;
        this.year = year;
        this.month = month;
        this.day = day;
        this.teamA = teamA;
        this.teamB = teamB;
        this.sport = sport;
        this.competitionName = competitionName;
        this.competitionCountry = competitionCountry;
        this.hour = hour;
    }

    public static int getContadorId() {
        return contadorId;
    }

    public static void setContadorId(int contadorId) {
        Event.contadorId = contadorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getTeamA() {
        return teamA;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    public String getCompetitionCountry() {
        return competitionCountry;
    }

    public void setCompetitionCountry(String competitionCountry) {
        this.competitionCountry = competitionCountry;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    @Override
    public String toString() {
        return "Evento{"
                + "id=" + id
                + ", year=" + year
                + ", month=" + month
                + ", day=" + day
                + ", teamA='" + teamA + '\''
                + ", teamB='" + teamB + '\''
                + ", sport='" + sport + '\''
                + ", competitionName='" + competitionName + '\''
                + ", competitionCountry='" + competitionCountry + '\''
                + ", hour='" + hour + '\''
                + '}';
    }
}

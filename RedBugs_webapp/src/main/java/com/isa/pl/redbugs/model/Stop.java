package com.isa.pl.redbugs.model;

import com.isa.pl.redbugs.service.pathfinding.GraphNode;

import java.util.Objects;

public class Stop implements GraphNode {
    private String stopId;
    private String stopName;
    private Schedule schedule;
    private double latitude;
    private double longitude;

    public Stop(String stopId, String stopName, Schedule schedule, double latitude, double longitude) {
        this.stopId = stopId;
        this.stopName = stopName;
        this.schedule = schedule;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Stop() {

    }

    @Override
    public String getStopId() {
        return stopId;
    }

    public String getStopName() {
        return stopName;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setStopId(String stopId) {
        this.stopId = stopId;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stop station = (Stop) o;

        if (Double.compare(station.latitude, latitude) != 0) return false;
        if (Double.compare(station.longitude, longitude) != 0) return false;
        if (!Objects.equals(stopId, station.stopId)) return false;
        if (!Objects.equals(stopName, station.stopName)) return false;
        return Objects.equals(schedule, station.schedule);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = stopId != null ? stopId.hashCode() : 0;
        result = 31 * result + (stopName != null ? stopName.hashCode() : 0);
        result = 31 * result + (schedule != null ? schedule.hashCode() : 0);
        temp = Double.doubleToLongBits(latitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Station{" +
                "id='" + stopId + '\'' +
                ", name='" + stopName + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}

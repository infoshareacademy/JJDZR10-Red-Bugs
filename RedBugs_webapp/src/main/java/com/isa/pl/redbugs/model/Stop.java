package com.isa.pl.redbugs.model;

import com.isa.pl.redbugs.service.ReadService;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class Stop {
    private long stopId;
    private String stopName;
    private Schedule schedule;

    public Stop(long stopId, String stopName) {
        this.stopId = stopId;
        this.stopName = stopName;
    }

    public Stop() {
    }

    public Stop findStopById(long id) throws IOException {
        ReadService rs = new ReadService();
        List<Stop> allStops = rs.readJson("Stops.json", Stop[].class);
        for (int i = 0; i < allStops.size(); i++) {
            if (allStops.get(i).getStopId() == id) {
                Stop foundStop = allStops.get(i);
                return foundStop;
            }
        }
        throw new RuntimeException("No stop found");
    }

    public long getStopId() {
        return stopId;
    }

    public void setStopId(long stopId) {
        this.stopId = stopId;
    }

    public String getStopName() {
        return stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return "Stop number: " + stopId +
                ", stopName: " + stopName ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stop stop = (Stop) o;

        if (stopId != stop.stopId) return false;
        if (!Objects.equals(stopName, stop.stopName)) return false;
        return Objects.equals(schedule, stop.schedule);
    }

    @Override
    public int hashCode() {
        int result = (int) (stopId ^ (stopId >>> 32));
        result = 31 * result + (stopName != null ? stopName.hashCode() : 0);
        result = 31 * result + (schedule != null ? schedule.hashCode() : 0);
        return result;
    }
}

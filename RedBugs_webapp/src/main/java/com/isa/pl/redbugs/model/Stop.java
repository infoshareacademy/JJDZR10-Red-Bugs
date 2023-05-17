package com.isa.pl.redbugs.model;

import com.isa.pl.redbugs.service.pathfinding.GraphNode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Getter
@Setter

public class Stop implements GraphNode {
    @Id
    private String stopId;
    private String stopName;
    private double latitude;
    private double longitude;


    @Override
    public String toString() {
        return "Station{" +
                "id='" + stopId + '\'' +
                ", name='" + stopName + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stop stop)) return false;
        return Double.compare(stop.latitude, latitude) == 0 && Double.compare(stop.longitude, longitude) == 0 && Objects.equals(stopId, stop.stopId) && Objects.equals(stopName, stop.stopName);
    }
    @Override
    public int hashCode() {
        return Objects.hash(stopId, stopName, latitude, longitude);
    }
}


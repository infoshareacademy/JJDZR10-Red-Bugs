package com.isa.pl.redbugs.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity
@NoArgsConstructor
@Getter
@Setter

public class Route {
    @Positive
    private long routeId;
    @Positive
    private long vehicleNumber;
    @NotEmpty
    private String routeName;
    @ElementCollection
    private List<String> stops;
    @Id
    @GeneratedValue
    private Long id;

    public Route(long routeId, long numberVehicle, String nameRoute, List<String> stops) {
        this.routeId = routeId;
        this.vehicleNumber = numberVehicle;
        this.routeName = nameRoute;
        this.stops = stops;
    }

    private static List<Stop> stopList = new ArrayList<>();


    @Override
    public String toString() {
        return "Route{" +
                "routeId=" + routeId +
                ", vehicleNumber=" + vehicleNumber +
                ", routeName='" + routeName + '\'' +
                ", stops=" + stops +
                ", id=" + id +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Route route)) return false;
        return routeId == route.routeId && vehicleNumber == route.vehicleNumber && Objects.equals(routeName, route.routeName) && Objects.equals(stops, route.stops) && Objects.equals(id, route.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(routeId, vehicleNumber, routeName, stops, id);
    }
}


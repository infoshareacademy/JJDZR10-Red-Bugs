package com.isa.pl.redbugs.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String[] stops;
    @Id
    @GeneratedValue
    private Long id;

    public Route(long routeId, long numberVehicle, String nameRoute, String[] stops) {
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
                ", numberVehicle=" + vehicleNumber +
                ", nameRoute='" + routeName + '\'' +
                ", stops=" + Arrays.toString(stops) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Route route = (Route) o;

        if (routeId != route.routeId) return false;
        if (vehicleNumber != route.vehicleNumber) return false;
        if (!Objects.equals(routeName, route.routeName)) return false;
        return Arrays.equals(stops, route.stops);
    }

    @Override
    public int hashCode() {
        int result = (int) (routeId ^ (routeId >>> 32));
        result = 31 * result + (int) (vehicleNumber ^ (vehicleNumber >>> 32));
        result = 31 * result + (routeName != null ? routeName.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(stops);
        return result;
    }


}


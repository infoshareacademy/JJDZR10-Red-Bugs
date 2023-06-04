package com.isa.pl.redbugs.model;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NoArgsConstructor
@Data
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Positive
    @Column(name = "routeId", nullable = false)
    private String routeId;
    @Positive
    @Column(name = "vehicleNumber", nullable = false)
    private long vehicleNumber;
    @NotEmpty
    @Column(name = "routeName", nullable = false)
    private String routeName;
    @ElementCollection
    @Column(nullable = false)
    private List<String> stops;

    public Route(String routeId, long numberVehicle, String nameRoute, List<String> stops) {
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
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Route route)) return false;
        return routeId.equals(route.routeId) && vehicleNumber == route.vehicleNumber && Objects.equals(routeName, route.routeName) && Objects.equals(stops, route.stops);
    }
    @Override
    public int hashCode() {
        return Objects.hash(routeId, vehicleNumber, routeName, stops);
    }
}


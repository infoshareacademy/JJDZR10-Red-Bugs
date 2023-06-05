package com.isa.pl.redbugs.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Route {
    @Id
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

    private static List<Stop> stopList = new ArrayList<>();

}


package com.isa.pl.redbugs.model;

import com.isa.pl.redbugs.service.pathfinding.GraphNode;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
public class Stop implements GraphNode {
    @Id
    private String stopId;
    private String stopName;
    private double latitude;
    private double longitude;


    //    public String getStopName() {
//        return stopName;
//    }
//
//    public void setStopName(String stopName) {
//        this.stopName = stopName;
//    }

}


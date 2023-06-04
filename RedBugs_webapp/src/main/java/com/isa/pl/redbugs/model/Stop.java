package com.isa.pl.redbugs.model;
import com.isa.pl.redbugs.service.pathfinding.GraphNode;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Stop implements GraphNode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String stopId;
    private String stopName;
    private double latitude;
    private double longitude;


}


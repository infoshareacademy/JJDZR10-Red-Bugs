package com.isa.pl.redbugs.repository;

import com.isa.pl.redbugs.model.Stop;
import com.isa.pl.redbugs.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {
}

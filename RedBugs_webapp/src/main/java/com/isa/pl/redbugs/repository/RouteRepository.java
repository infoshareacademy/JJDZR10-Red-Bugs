package com.isa.pl.redbugs.repository;

import com.isa.pl.redbugs.model.Route;
import com.isa.pl.redbugs.model.Stop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, String> {
}

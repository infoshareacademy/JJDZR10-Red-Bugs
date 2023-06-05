package com.isa.pl.redbugs;

import com.isa.pl.redbugs.model.Route;
import com.isa.pl.redbugs.model.Stop;
import com.isa.pl.redbugs.service.InitDataService;
import com.isa.pl.redbugs.service.PathFindingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws Exception {

		ConfigurableApplicationContext cxt = SpringApplication.run(Application.class, args);
		InitDataService initService = cxt.getBean(InitDataService.class);

		List<Stop> stopsList = initService.getStops();
		List<Route> routesList = initService.getRoutes();
		Set<Stop> stops = new HashSet<>(stopsList);
		Set<Route> routes = new HashSet<>(routesList);

		PathFindingService pathFindingService = new PathFindingService();
		pathFindingService.calculateShortestRoute(stops, routes, "1314", "14693");

	}
}

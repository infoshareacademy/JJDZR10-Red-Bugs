package com.isa.pl.redbugs;

import com.isa.pl.redbugs.service.InitDataService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext cxt = SpringApplication.run(Application.class, args);
		InitDataService initService = cxt.getBean(InitDataService.class);

//		List<Stop> stopsList = initService.getStop();
//		List<Route> routesList = InitDataService.routesDataList();
//		Set<Stop> stops = new HashSet<>(stopsList);
//		Set<Route> routes = new HashSet<>(routesList);
//
//		PathFindingService pathFindingService = new PathFindingService();
//		pathFindingService.calculateShortestRoute(stops, routes, "1314", "14693");

	}
}

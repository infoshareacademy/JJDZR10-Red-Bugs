package com.isa.pl.redbugs;

import com.isa.pl.redbugs.model.Route;
import com.isa.pl.redbugs.model.Stop;
import com.isa.pl.redbugs.service.InitDataService;
import com.isa.pl.redbugs.service.PathFindingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);

		List<Stop> stopsList = InitDataService.stopsDataList();
		List<Route> routesList = InitDataService.routesDataList();
		Set<Stop> stops = new HashSet<>(stopsList);
		Set<Route> routes = new HashSet<>(routesList);

		PathFindingService pathFindingService = new PathFindingService();
		pathFindingService.calculateShortestRoute(stops, routes, "1314", "14693");

	}
//	@Bean
//	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//		return  args -> {
//
//			String[] beanNames = ctx.getBeanDefinitionNames();
//			Arrays.sort(beanNames);
//			for (String beanName : beanNames) {
//				System.out.println(beanName);
//			}
//		};
//	}
//
}

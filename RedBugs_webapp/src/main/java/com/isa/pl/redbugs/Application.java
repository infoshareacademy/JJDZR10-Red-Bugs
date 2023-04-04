package com.isa.pl.redbugs;

import com.isa.pl.redbugs.model.Schedule;
import com.isa.pl.redbugs.service.*;
import com.isa.pl.redbugs.service.pathfinding.DistanceScorer;
import com.isa.pl.redbugs.service.pathfinding.Graph;
import com.isa.pl.redbugs.service.pathfinding.RouteFinder;
import com.isa.pl.redbugs.model.Stop;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.isa.pl.redbugs.service.InitDataService.stopsDataList;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws Exception {

		SpringApplication.run(Application.class, args);

		InitDataService initDataService = new InitDataService();
		initDataService.writeInitializedDataToJson();


		Graph<Stop> stationGraph = setUp();
		RouteFinder<Stop> routeFinder = new RouteFinder<>(stationGraph, new DistanceScorer(), new DistanceScorer());

		List<Stop> route = routeFinder.findRoute(stationGraph.getNode("1028"), stationGraph.getNode("14693"));
		route.stream().map(Stop::getStopName).collect(Collectors.toList()).forEach(station -> System.out.println(station));
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return  args -> {
			System.out.println("Lets inspect!!!!");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}
		};
	}

	public static Graph<Stop> setUp() throws Exception {
		Set<Stop> stops = InitDataService.stopsDataList().stream().collect(Collectors.toSet());
		Map<String, Set<String>> connections = new HashMap<>();

		connections.put("1013", Stream.of("1028").collect(Collectors.toSet()));
		connections.put("1028", Stream.of("1013", "14693", "1248").collect(Collectors.toSet()));
		connections.put("14693", Stream.of("1028", "1200").collect(Collectors.toSet()));

		return new Graph<>(stops, connections);
	}

}

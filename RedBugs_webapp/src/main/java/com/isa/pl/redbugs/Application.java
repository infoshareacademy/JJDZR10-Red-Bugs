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

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws Exception {

		SpringApplication.run(Application.class, args);

		InitDataService initDataService = new InitDataService();
		initDataService.writeInitializedDataToJson();

		Graph<Stop> stationGraph = setUp();
		RouteFinder<Stop> routeFinder = new RouteFinder<>(stationGraph, new DistanceScorer(), new DistanceScorer());

		List<Stop> route = routeFinder.findRoute(stationGraph.getNode("1"), stationGraph.getNode("1"));
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
		Set<Stop> stops = new HashSet<>();
		Map<String, Set<String>> connections = new HashMap<>();

		stops.add(new Stop("1", "Acton Town", new Schedule(), 51.5028, -0.2801));


		connections.put("1", Stream.of("52","73","73","233","264").collect(Collectors.toSet()));
		connections.put("2", Stream.of("156","262","156").collect(Collectors.toSet()));
		connections.put("3", Stream.of("262","294","156","294").collect(Collectors.toSet()));
		connections.put("4", Stream.of("70","200").collect(Collectors.toSet()));
		connections.put("5", Stream.of("193","251").collect(Collectors.toSet()));


		return new Graph<>(stops, connections);
	}

}

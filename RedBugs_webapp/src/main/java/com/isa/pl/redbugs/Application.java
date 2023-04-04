package com.isa.pl.redbugs;

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

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws Exception {

		SpringApplication.run(Application.class, args);

		InitDataService initDataService = new InitDataService();
		initDataService.writeInitializedDataToJson();

		PathFindingService pathFindingService = new PathFindingService();
		pathFindingService.calculateShortestRoute("1028", "14693");
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
}

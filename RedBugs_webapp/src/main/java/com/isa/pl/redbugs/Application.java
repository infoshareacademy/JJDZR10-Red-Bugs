package com.isa.pl.redbugs;

import com.isa.pl.redbugs.model.Route;
import com.isa.pl.redbugs.model.Stop;
import com.isa.pl.redbugs.model.Vehicle;
import com.isa.pl.redbugs.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.util.Arrays;

@SpringBootApplication
public class Application {
//a
	public static void main(String[] args) throws IOException {

		SpringApplication.run(Application.class, args);

		writeInitializedDataToJson();

//		VehicleService vehicleService = new VehicleService();
//		vehicleService.deleteVehicle(11);
//		System.out.println(vehicleService.findAllVehicles());

	}

	public static void writeInitializedDataToJson() throws IOException {
		WriteService ws = new WriteService();
		ws.writeToJson(InitDataService.stopsDataList(),"Stops.json");
		ws.writeToJson(InitDataService.vehiclesDataList(),"Vehicles.json");
		ws.writeToJson(InitDataService.routesDataList(),"Routes.json");
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

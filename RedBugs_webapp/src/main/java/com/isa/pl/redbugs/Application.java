package com.isa.pl.redbugs;

import com.isa.pl.redbugs.service.InitDataService;
import com.isa.pl.redbugs.service.ReadService;
import com.isa.pl.redbugs.service.VehicleService;
import com.isa.pl.redbugs.service.WriteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application {
//a
	public static void main(String[] args) throws IOException {

		SpringApplication.run(Application.class, args);

		WriteService writeService = new WriteService();
		writeService.writeInitializedDataToJson();

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

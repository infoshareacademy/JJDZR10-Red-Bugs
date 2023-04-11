package com.isa.pl.redbugs;
import com.isa.pl.redbugs.model.Route;
import com.isa.pl.redbugs.model.Stop;
import com.isa.pl.redbugs.model.Vehicle;
import com.isa.pl.redbugs.service.InitDataService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@SpringBootApplication
public class Application {
    //a
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Controller
    public class InitDataServiceController {

        private InitDataServiceController initDataServiceController;

        @GetMapping("/templates/data.html")
        public String getInitDataServices(Model model) {
            List<Stop> stops = InitDataService.stopsDataList();
            model.addAttribute("stops", stops);

            List<Vehicle> vehicles = InitDataService.vehiclesDataList();
            model.addAttribute("vehicles", vehicles);

            List<Route> routes = InitDataService.routesDataList();
            model.addAttribute("routes", routes);
            model.addAttribute("stops", stops);
            return "data";
        }
    }
}


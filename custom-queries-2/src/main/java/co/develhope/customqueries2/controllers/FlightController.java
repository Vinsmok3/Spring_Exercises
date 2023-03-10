package co.develhope.customqueries2.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import co.develhope.customqueries2.entities.Flight;
import co.develhope.customqueries2.entities.FlightStatus;
import co.develhope.customqueries2.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightController {

    @Autowired
    private FlightRepository flightRepository;

    @GetMapping("/flights")
    public List<Flight> getFlights(@RequestParam(name = "page", defaultValue = "0") int page,
                                   @RequestParam(name = "size", defaultValue = "10") int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("fromAirport").ascending());
        return flightRepository.findAll(pageRequest).getContent();
    }

    @GetMapping("/flights/ontime")
    public List<Flight> getOnTimeFlights() {
        return flightRepository.findByStatus(FlightStatus.ONTIME);
    }

    @GetMapping("/flights/custom")
    public List<Flight> getCustomFlights(@RequestParam(name = "p1") FlightStatus p1,
                                         @RequestParam(name = "p2") FlightStatus p2) {
        return flightRepository.findByStatusIn(p1, p2);
    }

    @GetMapping("/flights/provision")
    public void provisionFlights(@RequestParam(name = "n", defaultValue = "100") int n) {
        Random random = new Random();
        LocalDateTime now = LocalDateTime.now();
        for (int i = 0; i < n; i++) {
            Flight flight = new Flight();
            flight.setFromAirport(Integer.toString(random.nextInt(100000)));
            flight.setToAirport(Integer.toString(random.nextInt(100000)));
            LocalDateTime scheduledDeparture = now.plusHours(random.nextInt(24)).plusMinutes(random.nextInt(60));
            flight.setScheduledDeparture(scheduledDeparture);
            LocalDateTime scheduledArrival = scheduledDeparture.plusHours(random.nextInt(24)).plusMinutes(random.nextInt(60));
            flight.setScheduledArrival(scheduledArrival);
            flight.setStatus(FlightStatus.values()[random.nextInt(FlightStatus.values().length)]);
            flightRepository.save(flight);
        }
    }


}

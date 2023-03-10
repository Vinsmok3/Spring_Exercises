package co.develhope.customqueries2.repositories;

import co.develhope.customqueries2.entities.Flight;
import co.develhope.customqueries2.entities.FlightStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByStatus(FlightStatus status);

    List<Flight> findByStatusIn(FlightStatus... status);
}

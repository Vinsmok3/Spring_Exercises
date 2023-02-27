package co.develhope.mockdb.repositories;

import co.develhope.mockdb.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
public interface StudentRepository extends JpaRepository<Student, Long> {
}

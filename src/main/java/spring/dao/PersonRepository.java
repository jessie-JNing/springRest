package spring.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import spring.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
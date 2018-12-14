package gr.di.uoa.kk.databasesystems.repository;

import gr.di.uoa.kk.databasesystems.entities.Incident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncidentRepository extends JpaRepository<Incident, Long>{
    List<Incident> getByZipCode(String zipCode);
    List<Incident> getByStreetAddress(String address);
    List<Incident> getByZipCodeAndStreetAddress(String zipcode, String address);

}

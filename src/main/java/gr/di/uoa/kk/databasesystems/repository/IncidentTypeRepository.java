package gr.di.uoa.kk.databasesystems.repository;

import gr.di.uoa.kk.databasesystems.entities.IncidentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncidentTypeRepository extends JpaRepository<IncidentType, Long> {
    List<IncidentType> getBySrvtName(String name);

    List<IncidentType> findAll();
}

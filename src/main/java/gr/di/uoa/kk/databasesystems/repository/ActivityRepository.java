package gr.di.uoa.kk.databasesystems.repository;

import gr.di.uoa.kk.databasesystems.entities.Activity;
import gr.di.uoa.kk.databasesystems.entities.Incident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
}

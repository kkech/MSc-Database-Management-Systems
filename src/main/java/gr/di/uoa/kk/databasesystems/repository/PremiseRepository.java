package gr.di.uoa.kk.databasesystems.repository;

import gr.di.uoa.kk.databasesystems.entities.Premise;
import gr.di.uoa.kk.databasesystems.entities.Queries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PremiseRepository extends JpaRepository<Premise,Long> {
}

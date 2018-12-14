package gr.di.uoa.kk.databasesystems.repository;

import gr.di.uoa.kk.databasesystems.entities.Other;
import gr.di.uoa.kk.databasesystems.entities.Premise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtherRepository extends JpaRepository<Other,Long> {
}

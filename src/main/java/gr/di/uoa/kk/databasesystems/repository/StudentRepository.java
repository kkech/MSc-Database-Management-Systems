package gr.di.uoa.kk.databasesystems.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gr.di.uoa.kk.databasesystems.entities.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

}

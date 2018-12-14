package gr.di.uoa.kk.databasesystems.service;

import gr.di.uoa.kk.databasesystems.entities.Premise;
import gr.di.uoa.kk.databasesystems.entities.Student;
import gr.di.uoa.kk.databasesystems.repository.PremiseRepository;
import gr.di.uoa.kk.databasesystems.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PremiseService {

    @Autowired
    PremiseRepository premiseRepository;

    public Premise addPremise(Premise premise) {
        premiseRepository.save(premise);
        return premise;
    }
}

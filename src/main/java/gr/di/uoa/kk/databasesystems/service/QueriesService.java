package gr.di.uoa.kk.databasesystems.service;

import gr.di.uoa.kk.databasesystems.entities.Queries;
import gr.di.uoa.kk.databasesystems.entities.Student;
import gr.di.uoa.kk.databasesystems.repository.IncidentRepository;
import gr.di.uoa.kk.databasesystems.repository.QueriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueriesService {

    @Autowired
    QueriesRepository queriesRepository;

    public Queries addQueryHistory(Queries queries) {
        queriesRepository.save(queries);
        return queries;
    }

}

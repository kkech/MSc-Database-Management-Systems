package gr.di.uoa.kk.databasesystems.service;

import gr.di.uoa.kk.databasesystems.entities.Incident;
import gr.di.uoa.kk.databasesystems.entities.IncidentType;
import gr.di.uoa.kk.databasesystems.entities.Student;
import gr.di.uoa.kk.databasesystems.repository.IncidentRepository;
import gr.di.uoa.kk.databasesystems.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidentService {

    @Autowired
    IncidentRepository incidentRepository;

    public List<Incident> findIncidentByZipOrStreetAddress(String zip, String streetAddress){
        if(streetAddress.isEmpty())
            return incidentRepository.getByZipCode(zip);
        else if(zip.isEmpty())
            return incidentRepository.getByStreetAddress(streetAddress);
        else
            return incidentRepository.getByZipCodeAndStreetAddress(zip,streetAddress);
    }

    public Incident addIncident(Incident incident) {
        incidentRepository.save(incident);
        return incident;
    }
}

package gr.di.uoa.kk.databasesystems.service;


import gr.di.uoa.kk.databasesystems.entities.IncidentType;
import gr.di.uoa.kk.databasesystems.entities.Student;
import gr.di.uoa.kk.databasesystems.repository.IncidentRepository;
import gr.di.uoa.kk.databasesystems.repository.IncidentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IncidentTypeService {

    @Autowired
    IncidentTypeRepository incidentTypeRepository;

    public IncidentType getIncidentTypeIdByName(String name){
        List<IncidentType> incidentTypeList = incidentTypeRepository.getBySrvtName(name);
        if(incidentTypeList != null && (!incidentTypeList.isEmpty()))
            return incidentTypeList.get(0);
        else
            return null;
    }

    public List<IncidentType> findAllIncidentTypeNames(){
        return incidentTypeRepository.findAll();
    }

}

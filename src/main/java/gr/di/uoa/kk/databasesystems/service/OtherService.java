package gr.di.uoa.kk.databasesystems.service;

import gr.di.uoa.kk.databasesystems.entities.Other;
import gr.di.uoa.kk.databasesystems.entities.Student;
import gr.di.uoa.kk.databasesystems.repository.OtherRepository;
import gr.di.uoa.kk.databasesystems.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OtherService {
    @Autowired
    OtherRepository otherRepository;

    public Other addOther(Other other) {
        otherRepository.save(other);
        return other;
    }
}

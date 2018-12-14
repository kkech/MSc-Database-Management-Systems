package gr.di.uoa.kk.databasesystems.service;

import gr.di.uoa.kk.databasesystems.entities.Activity;
import gr.di.uoa.kk.databasesystems.entities.Student;
import gr.di.uoa.kk.databasesystems.repository.ActivityRepository;
import gr.di.uoa.kk.databasesystems.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {

    @Autowired
    ActivityRepository activityRepository;

    public Activity addActivity(Activity activity) {
        activityRepository.save(activity);
        return activity;
    }
}

package gr.di.uoa.kk.databasesystems.service;


import gr.di.uoa.kk.databasesystems.entities.Student;
import gr.di.uoa.kk.databasesystems.entities.VehicleData;
import gr.di.uoa.kk.databasesystems.repository.StudentRepository;
import gr.di.uoa.kk.databasesystems.repository.VehicleDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleDataService {

    @Autowired
    VehicleDataRepository vehicleDataRepository;

    public VehicleData addVehicle(VehicleData vehicleData) {
        vehicleDataRepository.save(vehicleData);
        return vehicleData;
    }
}

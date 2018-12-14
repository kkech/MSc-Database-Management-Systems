package gr.di.uoa.kk.databasesystems.repository;

import gr.di.uoa.kk.databasesystems.entities.Incident;

import java.util.List;

public interface IncidentRepositoryCustom {
    public List<Incident> getByZip(String zip, String address);
    public List<Incident> getByAddress(String address);
    public List<Incident> findAndGetByZipAndAddress(String zip, String address);

}

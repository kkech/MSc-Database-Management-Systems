package gr.di.uoa.kk.databasesystems.repository;

import gr.di.uoa.kk.databasesystems.entities.Incident;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class IncidentRepositoryCustomImpl  implements IncidentRepositoryCustom{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Incident> getByZip(String zip, String address) {
        return null;
    }

    @Override
    public List<Incident> getByAddress(String address) {
        return null;
    }

    @Override
    public List<Incident> findAndGetByZipAndAddress(String zip, String address) {
        return null;
    }
//
//    @Override
//    public List<Incident> getByZipAndOrStreetAddress(String zip, String address) {
//        Query query = entityManager.createNativeQuery("SELECT em.* FROM spring_data_jpa_example.employee as em " +
//                "WHERE em.firstname LIKE ?", Incident.class);
//        return query.getResultList();
//    }
}

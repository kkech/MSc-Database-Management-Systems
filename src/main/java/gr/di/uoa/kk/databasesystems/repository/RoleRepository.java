package gr.di.uoa.kk.databasesystems.repository;


import gr.di.uoa.kk.databasesystems.entities.Role;
import gr.di.uoa.kk.databasesystems.entities.enums.RoleNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleNameEnum roleNameEnum);
}

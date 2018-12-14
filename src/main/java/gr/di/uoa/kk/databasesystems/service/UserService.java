package gr.di.uoa.kk.databasesystems.service;

import gr.di.uoa.kk.databasesystems.entities.Queries;
import gr.di.uoa.kk.databasesystems.entities.User;
import gr.di.uoa.kk.databasesystems.repository.QueriesRepository;
import gr.di.uoa.kk.databasesystems.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User findUserByName(String name) {
        User user = userRepository.findByUsername(name).get();
        return user;
    }
}

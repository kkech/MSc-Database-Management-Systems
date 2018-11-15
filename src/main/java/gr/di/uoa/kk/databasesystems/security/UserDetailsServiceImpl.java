package gr.di.uoa.kk.databasesystems.security;

import gr.di.uoa.kk.databasesystems.entities.User;
import gr.di.uoa.kk.databasesystems.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> {
                            logger.error("User Not Found with -> username or email : " + username);
                            return new UsernameNotFoundException("User Not Found with -> username or email : " + username);
                        }
                );

        return UserPrinciple.build(user);
    }
}
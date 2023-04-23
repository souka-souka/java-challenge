package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.entities.LoginUser;
import jp.co.axa.apidemo.entities.User;
import jp.co.axa.apidemo.exception.ApiException;
import jp.co.axa.apidemo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public void UserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //get user information by name
        Optional<User> optUser = userRepository.findByUsername(username);

        if(!optUser.isPresent()) {
            throw new ApiException(20001,"Login failed");
        }

        //TODO Query permission information based on user Add to LoginUser

        //Encapsulated into a UserDetails object and returned
        return new LoginUser(optUser.get());
    }
}
package com.charitychampion.charitychampion.security.services;

import com.charitychampion.charitychampion.security.entities.User;
import com.charitychampion.charitychampion.security.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoService implements UserDetailsService {

    @Autowired
    private IUserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userDetail = repository.findByUsername(username);
        // Converting userDetail to UserDetails
        return userDetail.map(User::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
    }
}

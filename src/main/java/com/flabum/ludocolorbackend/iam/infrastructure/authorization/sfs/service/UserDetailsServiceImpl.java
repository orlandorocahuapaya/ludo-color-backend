package com.flabum.ludocolorbackend.iam.infrastructure.authorization.sfs.service;

import com.flabum.ludocolorbackend.iam.infrastructure.authorization.sfs.model.UserDetailsImpl;
import com.flabum.ludocolorbackend.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/*
* Con esta clase se recupera el usuario de la base de datos
* */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        var user = userRepository.findByName(name)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + name));
        return UserDetailsImpl.build(user);
    }
}

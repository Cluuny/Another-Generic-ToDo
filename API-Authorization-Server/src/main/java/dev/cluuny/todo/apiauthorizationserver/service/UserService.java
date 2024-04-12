package dev.cluuny.todo.apiauthorizationserver.service;

import dev.cluuny.todo.apiauthorizationserver.model.SecurityUser;
import dev.cluuny.todo.apiauthorizationserver.model.UserEntity;
import dev.cluuny.todo.apiauthorizationserver.persistence.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final IUserRepository userRepository;

    //In this case the parameter username is in fact the email of the user who wants to Log in.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> user = userRepository.findUserByEmail(username);
        System.out.println(user);
        return user.map(SecurityUser::new).orElseThrow();
    }
}

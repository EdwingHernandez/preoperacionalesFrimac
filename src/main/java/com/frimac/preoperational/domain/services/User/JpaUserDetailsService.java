package com.frimac.preoperational.domain.services.User;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.frimac.preoperational.persistence.entities.User;
import com.frimac.preoperational.persistence.repositories.UserRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> userOptional = userRepository.findById(username);

        if(userOptional.isEmpty()){
            throw new UsernameNotFoundException(String.format("username %s no existe en el sistema", username));
        }
        User user = userOptional.orElseThrow();

        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().getName());
        List<GrantedAuthority> authorities = List.of(authority);


        return new org.springframework.security.core.userdetails.User(String.valueOf(user.getUsername()),
        user.getPassword(),
        user.isEnable(),
        true,
        true,
        true,
        authorities);
    }

}


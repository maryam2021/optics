package optics.com.authentication;

import optics.com.domain.register.Register;
import optics.com.service.registerservice.RegisterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    RegisterServiceImpl registerService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Register user = registerService.findByUsername(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                new ArrayList<>());
    }

}

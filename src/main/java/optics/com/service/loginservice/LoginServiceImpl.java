package optics.com.service.loginservice;

import optics.com.authentication.JwtTokenUtil;
import optics.com.authentication.JwtUserDetailsService;
import optics.com.domain.register.Register;
import optics.com.model.loginmodel.AuthenticationResponse;
import optics.com.model.loginmodel.LoginModel;
import optics.com.repository.registerrepository.RegiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {


    @Autowired
    private RegiterRepository regiterRepository;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailsService userDetailsService;
    Iterable<Register> dbUser;

    public AuthenticationResponse authenticate(LoginModel loginModel) throws Exception {
        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginModel.getEmail());
        final String token = jwtTokenUtil.generateToken(userDetails);
        dbUser = regiterRepository.findAll();
        for (Register user : dbUser) {
            if (loginModel.getEmail().equals(user.getEmail()) && loginModel.getPassword().equals(user.getPassword()) && user.isEnabled()) {
                return new AuthenticationResponse(loginModel.getEmail(), true, token);
            }
        }
        throw new Exception("invalid credentials");

    }


}






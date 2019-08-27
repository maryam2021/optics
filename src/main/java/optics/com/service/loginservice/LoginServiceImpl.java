package optics.com.service.loginservice;

import optics.com.model.loginmodel.AuthenticationReponseModel;
import optics.com.model.loginmodel.LoginModel;
import optics.com.model.registermodel.RegisterModel;
import optics.com.repository.registerrepository.RegiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl  implements  LoginService {


    @Autowired
    private RegiterRepository regiterRepository;
    List<RegisterModel> dbUser;

    public AuthenticationReponseModel authenticate(LoginModel loginModel) throws Exception {
        dbUser = (List<RegisterModel>) regiterRepository.findAll();
        for (RegisterModel user : dbUser) {
            if (loginModel.getUserName().contains(user.getUserName()) && loginModel.getPassword().contains(user.getPassword())) {
                return new AuthenticationReponseModel(loginModel.getUserName(), true);
            }
        }
            throw new Exception("invalid credentials");

        }

}






package optics.com.service.registerservice;


import optics.com.model.registermodel.RegisterModel;
import optics.com.repository.registerrepository.RegiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegiterRepository regiterRepository;
    List<RegisterModel> dbUser;
    ;


    @Override
    public void register(RegisterModel registerModel) throws Exception {
        if (regiterRepository.count() != 0) {
            dbUser = (List<RegisterModel>) regiterRepository.findAll();
            for (RegisterModel result : dbUser) {
                if ((result.getUserName().contains(registerModel.getUserName()))) {
                    throw new Exception("already exists");
                }
            }
            regiterRepository.save(registerModel);

        } else {
            regiterRepository.save(registerModel);
        }


    }
}


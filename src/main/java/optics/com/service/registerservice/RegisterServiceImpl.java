package optics.com.service.registerservice;


import optics.com.domain.register.Register;
import optics.com.model.registermodel.RegisterModel;
import optics.com.repository.registerrepository.RegiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegiterRepository regiterRepository;
    Iterable<Register> dbUser;
    ;


    @Override
    public void register(Register register) throws Exception {
        if (regiterRepository.count() != 0) {
            dbUser = regiterRepository.findAll();
            for (Register result : dbUser) {
                if ((result.getUserName().contains(register.getUserName()))) {
                    throw new Exception("already exists");
                }
            }
            regiterRepository.save(register);

        } else {
            regiterRepository.save(register);
        }


    }
}


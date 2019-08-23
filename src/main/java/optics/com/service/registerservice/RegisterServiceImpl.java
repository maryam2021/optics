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

    @Override
    public void register(RegisterModel registerModel) throws Exception {
        for (RegisterModel duplicateusers : getDbUserName()) {
            if (registerModel.getUserName().equals(duplicateusers.getUserName())) {
                throw new Exception("already exists");
            } else {
                regiterRepository.save(registerModel);
            }

        }
    }

    private Iterable<RegisterModel> getDbUserName() {
      return regiterRepository.findAll();
    }
}

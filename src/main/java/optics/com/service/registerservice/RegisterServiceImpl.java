package optics.com.service.registerservice;


import optics.com.model.registermodel.RegisterModel;
import optics.com.repository.registerrepository.RegiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegiterRepository regiterRepository;

    @Override
    public void register(RegisterModel registerModel) {
        regiterRepository.save(registerModel);


    }
}

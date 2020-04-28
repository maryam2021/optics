package optics.com.handler.changepassword;

import optics.com.model.ChangePasswordResponseModel;
import optics.com.model.changepasswordmodel.ChangePasswordModel;
import optics.com.service.changepassword.ChangePasswordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChangePasswordHandler {
    @Autowired
    ChangePasswordServiceImpl forgotPasswordService;

    public ChangePasswordResponseModel changePassword(ChangePasswordModel changePasswordModel) {
       return forgotPasswordService.changePassword(changePasswordModel);
    }
}

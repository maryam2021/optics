package optics.com.changepassword;

import optics.com.handler.changepassword.ChangePasswordHandler;
import optics.com.model.ChangePasswordResponseModel;
import optics.com.model.changepasswordmodel.ChangePasswordModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChangePasswordController {

    @Autowired
    private ChangePasswordHandler changePasswordHandler;

    @PostMapping(value = "/forgot-password")
    public ChangePasswordResponseModel changePassword(@RequestBody  ChangePasswordModel changePasswordModel) {
        return changePasswordHandler.changePassword(changePasswordModel);
    }
}

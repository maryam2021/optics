package optics.com.service.changepassword;

import optics.com.model.ChangePasswordResponseModel;
import optics.com.model.changepasswordmodel.ChangePasswordModel;

public interface ChangePasswordService {
    ChangePasswordResponseModel changePassword(ChangePasswordModel changePasswordModel);
}

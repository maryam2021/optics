package optics.com.model.registermodel;


import lombok.*;
import optics.com.domain.register.Register;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterModel {

    private String id;
    private String userName;
    private String password;
    private String confirmPassword;
    private String phoneNumber;

    public Register toRegister(RegisterModel registerModel){
        String id = registerModel.getId();
        String userName = registerModel.getUserName();
         String password = registerModel.getPassword();
         String confirmPassword = registerModel.getConfirmPassword();
         String phoneNumber = registerModel.getPhoneNumber();
        return new Register(id,userName,password,confirmPassword,phoneNumber);
    }
}

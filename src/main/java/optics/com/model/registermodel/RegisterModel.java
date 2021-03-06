package optics.com.model.registermodel;


import lombok.*;
import optics.com.domain.register.Register;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

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
    private String email;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new Date();

    public Register toRegister(RegisterModel registerModel){
        String id = registerModel.getId();
        String userName = registerModel.getUserName();
         String password = registerModel.getPassword();
         String confirmPassword = registerModel.getConfirmPassword();
         String email = registerModel.getEmail();
        Date date = registerModel.getDate();
        return new Register(id,userName,password,confirmPassword,email,false,date);
    }
}

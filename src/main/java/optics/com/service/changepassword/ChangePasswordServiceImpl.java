package optics.com.service.changepassword;

import optics.com.domain.register.Register;
import optics.com.model.ChangePasswordResponseModel;
import optics.com.model.changepasswordmodel.ChangePasswordModel;
import optics.com.repository.registerrepository.RegiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChangePasswordServiceImpl implements ChangePasswordService {
    @Autowired
    RegiterRepository regiterRepository;
    @Autowired
    private JavaMailSender javaMailSender;
//    @Autowired
//    private CustomerContext customerContext;

    @Override
    public ChangePasswordResponseModel changePassword(ChangePasswordModel changePasswordModel) {
//
        return null;

    }

    public boolean isPasswordSame(ChangePasswordModel changePasswordModel, Optional<Register>  loggedInEmployee) {
       // return passwordEncoder.matches(changePasswordModel.getOldPassword(), loggedInEmployee.getPassword());
        return true;
    }




    private void sendEmail(Optional<Register> loggedInCustomer) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
       // mailMessage.setTo(loggedInCustomer.get().getAddress());
        mailMessage.setSubject("Complete Registration!");
        mailMessage.setFrom("hanakhan838@gmail.com");
        mailMessage.setText("To confirm your account, please click here : "
                + "http://localhost:8080/confirm-account/" + loggedInCustomer);
        javaMailSender.send(mailMessage);
    }
}

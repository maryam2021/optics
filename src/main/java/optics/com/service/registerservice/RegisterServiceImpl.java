package optics.com.service.registerservice;


import optics.com.domain.register.ConfirmationToken;
import optics.com.domain.register.Register;
import optics.com.repository.registerrepository.RegiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegiterRepository regiterRepository;
    @Autowired
    private JavaMailSender javaMailSender;

    private ConfirmationToken confirmationToken;


    Iterable<Register> dbUser;
    ;


    @Override
    public void register(Register register) throws Exception {
        if (regiterRepository.count() != 0) {
            dbUser = regiterRepository.findAll();
            for (Register result : dbUser) {
                if ((result.getUserName().toLowerCase().equals(register.getUserName().toLowerCase()))) {
                    throw new Exception("already exists");
                }
            }
            regiterRepository.save(register);
            sendEmail(createEmail(register.getEmail()));

        } else {
            regiterRepository.save(register);
            sendEmail(createEmail(register.getEmail()));

        }


    }


    @Async
    public void sendEmail(SimpleMailMessage email) {
        javaMailSender.send(email);
    }

    private SimpleMailMessage createEmail(String email) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email);
        mailMessage.setSubject("Complete Registration!");
        mailMessage.setFrom("hanakhan838@gmail.com");
        mailMessage.setText("To confirm your account, please click here : "
                + "http://localhost:8082/confirm-account?token=" + confirmationToken.getConfirmationToken());
//        javaMailSender.send(mailMessage);
        return mailMessage;
    }

}


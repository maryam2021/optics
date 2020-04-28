package optics.com.service.registerservice;


import optics.com.domain.register.ConfirmationToken;
import optics.com.domain.register.Register;
import optics.com.repository.confirmationtokenrepository.ConfirmationTokenRepository;
import optics.com.repository.registerrepository.RegiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {


    Iterable<Register> dbUser;
    Iterable<ConfirmationToken> token;
    private ConfirmationToken confirmationToken;

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;
    @Autowired
    private RegiterRepository regiterRepository;
    @Autowired
    private JavaMailSender javaMailSender;

    public void register(Register register) throws Exception {
        confirmationToken = new ConfirmationToken(register);
        if (regiterRepository.count() != 0) {
            if (checkDuplicateUserName(register.getUserName())) {
                throw new Exception("Already exist username");
            }
            if(checkDuplicateUserEmail(register.getEmail()))
            {
                throw new Exception("Already exist email!");
            }
            regiterRepository.save(register);
            confirmationTokenRepository.save(confirmationToken);
            //   sendEmail(register.getEmail(), confirmationToken.getConfirmationToken());
        } else {
            regiterRepository.save(register);
            confirmationTokenRepository.save(confirmationToken);
            //  sendEmail(register.getEmail(), confirmationToken.getConfirmationToken());

        }
    }

    @Override
    public void confirmUserAccount(String confirmationToken) throws Exception{
        token = confirmationTokenRepository.findAll();
        for (ConfirmationToken istokenExist : token) {
            if (istokenExist != null)
                if (istokenExist.getConfirmationToken().equals(confirmationToken)) {
                    dbUser = regiterRepository.findAll();
                    for (Register registeredUser : dbUser) {
                        if (istokenExist.getRegister().getId().equals(registeredUser.getId())) {
                            registeredUser.setEnabled(true);
                            regiterRepository.save(registeredUser);
                            regiterRepository.deleteConfirmationToken(confirmationToken);
                            throw new Exception("accountVerified");
                        }
                    }
                }
        }

        throw new Exception("message,The link is invalid or broken!");
    }

    @Override
    public Register findByUsername(String email) {
        dbUser = regiterRepository.findAll();
        for (Register register : dbUser) {
            if (register.getEmail().equals(email)) {
                return register;
            }
        }
        return null;
    }


    private Boolean checkDuplicateUserEmail(String email) {
        return regiterRepository.existsByEmail(email);
    }

    private Boolean checkDuplicateUserName(String userName) throws Exception {
        return regiterRepository.existsByUserName(userName);
    }


    private void sendEmail(String email, String confirmationToken) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email);
        mailMessage.setSubject("Complete Registration!");
        mailMessage.setFrom("hanakhan838@gmail.com");
        mailMessage.setText("To confirm your account, please click here : "
                + "http://localhost:8080/confirm-account/" + confirmationToken);
        javaMailSender.send(mailMessage);
    }


}


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


    private ConfirmationToken confirmationToken;

    public RegisterServiceImpl() {
        this.confirmationToken = new ConfirmationToken();
    }

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;
    @Autowired
    private RegiterRepository regiterRepository;
    @Autowired
    private JavaMailSender javaMailSender;


    Iterable<Register> dbUser;
    Iterable<ConfirmationToken> token;

    public void register(Register register) throws Exception {
        if (regiterRepository.count() != 0) {
            if (checkDuplicateUserName(register.getUserName()) || checkDuplicateUserEmail(register.getEmail())) {
                throw new Exception("Already Exist username and email!");
            }
            regiterRepository.save(register);
            confirmationTokenRepository.save(new ConfirmationToken(register));
            sendEmail(register.getEmail());
        } else {
            regiterRepository.save(register);
            confirmationTokenRepository.save(new ConfirmationToken(register));
            sendEmail(register.getEmail());

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
                            System.out.println("accountVerified");
                        }
                    }
                }
        }

        throw new Exception("message,The link is invalid or broken!");
    }


    private boolean checkDuplicateUserEmail(String email) {
        boolean isUserEmailExist = false;
        dbUser = regiterRepository.findAll();
        for (Register register : dbUser) {
            if (register.getEmail().equals(email)) {
                isUserEmailExist = true;
            }
        }
        return isUserEmailExist;
    }

    private boolean checkDuplicateUserName(String userName) throws Exception {
        boolean isUserNameExist = false;
        dbUser = regiterRepository.findAll();
        for (Register register : dbUser) {
            if (register.getUserName().toLowerCase().equals(userName.toLowerCase())) {
                isUserNameExist = true;
            }
            break;
        }
        return isUserNameExist;
    }


    private void sendEmail(String email) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email);
        mailMessage.setSubject("Complete Registration!");
        mailMessage.setFrom("hanakhan838@gmail.com");
        mailMessage.setText("To confirm your account, please click here : "
                + "http://localhost:8082/confirm-account?token=" + confirmationToken.getConfirmationToken());
        javaMailSender.send(mailMessage);
    }


}


package optics.com.controller.registercontroller;

import optics.com.domain.register.ConfirmationToken;
import optics.com.handler.registerhandler.RegisterHandler;
import optics.com.model.registermodel.RegisterModel;
import optics.com.repository.confirmationtokenrepository.ConfirmationTokenRepository;
import optics.com.responses.RegisterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController {
    @Autowired
    private RegisterHandler registerHandler;



    @PostMapping(value = "/register")
    public ResponseEntity register(@RequestBody RegisterModel registerModel) throws Exception {
        registerHandler.register(registerModel);
        return ResponseEntity.ok(new RegisterResponse("User registered successfully"));
    }
    @GetMapping(value="/confirm-account/{token}")
    public void confirmUserAccount(@PathVariable("token")String confirmationToken) throws Exception {
        registerHandler.confirmUserAccount(confirmationToken);
    }
}

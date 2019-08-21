package optics.com.model.registermodel;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "register")
public class RegisterModel {
    @Id
    private UUID id = UUID.randomUUID();
    private String userName;
    private String password;
    private String confirmPassword;
    private String phoneNumber;
}

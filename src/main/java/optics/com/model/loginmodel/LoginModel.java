package optics.com.model.loginmodel;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LoginModel {
    private String userName;
    private String password;
}

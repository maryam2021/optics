package optics.com.model.loginmodel;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthenticationReponseModel {
   private String username;
   private boolean authenticate;
}

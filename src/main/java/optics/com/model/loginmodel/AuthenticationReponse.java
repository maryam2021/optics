package optics.com.model.loginmodel;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthenticationReponse {
   private String username;
   private boolean authenticate;
   private String token;
}

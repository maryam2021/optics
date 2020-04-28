package optics.com.model.loginmodel;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthenticationResponse {
   private String username;
   private boolean authenticate;
   private String token;
}

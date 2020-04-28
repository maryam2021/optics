package optics.com.model.changepasswordmodel;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ChangePasswordModel {
    private String oldPassword;
    private String newPassword;
}

package optics.com.model;

import lombok.*;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ChangePasswordResponseModel {
    private HttpStatus httpStatus;
    private String errorMessage;
}

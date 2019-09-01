package optics.com.domain.register;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "register")

public class Register {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private String userName;
    private String password;
    private String confirmPassword;
    private String email;
    private boolean isEnabled;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

}

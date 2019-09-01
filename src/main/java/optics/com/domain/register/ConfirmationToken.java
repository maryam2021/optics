package optics.com.domain.register;

import lombok.*;
import org.apache.tomcat.jni.User;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "confirmation_token")
public class ConfirmationToken {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String tokenId;
    private String confirmationToken;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @OneToOne(targetEntity = Register.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "id")
    private Register register;


    public ConfirmationToken(Register register) {
        this.register = register;
        createdDate = new Date();
        confirmationToken = UUID.randomUUID().toString();
    }
}

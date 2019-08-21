package optics.com.domain.customer;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "customer")
public class Customer {
    @Id
    private UUID id ;
    private String customerName ;
    private String address ;
    private String date ;
    private String phoneNumber ;
    private String prescribedByDoctor ;
    private double leftEyeSpherical ;
    private double leftEyeCylindrical ;
    private double leftEyeAxis ;
    private double leftEyeVision ;
    private double RightEyeSpherical ;
    private double RightEyeCylindrical ;
    private double RightEyeAxis ;
    private double RightEyeVision ;


}

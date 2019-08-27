package optics.com.domain.customer;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private String customerName;
    private String address;
    private String date;
    private String phoneNumber;
    private String prescribedByDoctor;
    private double leftEyeSpherical;
    private double leftEyeCylindrical;
    private double leftEyeAxis;
    private double leftEyeVision;
    private double RightEyeSpherical;
    private double RightEyeCylindrical;
    private double RightEyeAxis;
    private double RightEyeVision;


}

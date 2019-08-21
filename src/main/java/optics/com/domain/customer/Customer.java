package optics.com.domain.customer;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity(name="customer")
public class Customer {
    @Id
    private UUID id;
    private String customerName ;
    private String address ;
    private String date ;
    private String phoneNumber ;
    private String prescribedByDoctor ;
    private double spherical ;
    private double cylindrical ;
    private double axis ;
    private double vision ;
    private double ipd ;
    private double bvd ;
    private double prision ;


}

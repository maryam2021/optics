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
@Entity
@Table(name="customer")
public class Customer {
    @Column(name = "id")
    @Id
    private UUID id;
    @Column(name = "user_name")
    private String userName ;
    @Column(name = "address")
    private String address ;
    @Column(name = "date")
    private Date date ;
    @Column(name = "phone_number")
    private String phoneNumber ;
    @Column(name = "prescribed_By_Doctor")
    private String prescribedByDoctor ;
    @Column(name = "spherical")
    private double spherical ;
    @Column(name = "cylindrical")
    private double cylindrical ;
    @Column(name = "axis")
    private double axis ;
    @Column(name = "vision")
    private double vision ;
    @Column(name = "ipd")
    private double ipd ;
    @Column(name = "bvd")
    private double bvd ;
    @Column(name = "prision")
    private double prision ;


}

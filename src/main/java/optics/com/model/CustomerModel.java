package optics.com.model;



import lombok.*;
import optics.com.domain.customer.Customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "customer")
public class CustomerModel {

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


    public Customer toCustomer(CustomerModel customerModel){
       UUID id = customerModel.getId();
       String userName = customerModel.getUserName();
       String address = customerModel.getAddress();
       Date date =  customerModel.getDate();
       String phoneNumber = customerModel.getPhoneNumber();
       String prescribedByDoctor = customerModel.getPrescribedByDoctor();
        double spherical =  customerModel.getSpherical();
        double cylindirical = customerModel.getCylindrical();
        double prision = customerModel.getPrision();
        double ipd = customerModel.getIpd();
        double bvd = customerModel.getBvd();
        double vision = customerModel.getVision();
        double axis = customerModel.getAxis();
       return new Customer(id,userName,address,date,phoneNumber,prescribedByDoctor,spherical,cylindirical,axis,vision,ipd,bvd,prision);

    }
}

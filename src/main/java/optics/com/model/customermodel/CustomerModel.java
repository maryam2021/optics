package optics.com.model.customermodel;



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
@Entity(name="customer")
public class CustomerModel {

    @Id
    private UUID id= UUID.randomUUID();
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


    public Customer toCustomer(CustomerModel customerModel){
       UUID id = customerModel.getId();
       String customerName = customerModel.getCustomerName();
       String address = customerModel.getAddress();
       String date =  customerModel.getDate();
       String phoneNumber = customerModel.getPhoneNumber();
       String prescribedByDoctor = customerModel.getPrescribedByDoctor();
        double spherical =  customerModel.getSpherical();
        double cylindirical = customerModel.getCylindrical();
        double prision = customerModel.getPrision();
        double ipd = customerModel.getIpd();
        double bvd = customerModel.getBvd();
        double vision = customerModel.getVision();
        double axis = customerModel.getAxis();
       return new Customer(id,customerName,address,date,phoneNumber,prescribedByDoctor,spherical,cylindirical,axis,vision,ipd,bvd,prision);

    }
}

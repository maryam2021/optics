package optics.com.model.customermodel;


import lombok.*;
import optics.com.domain.customer.Customer;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CustomerModel {

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




    public Customer toCustomer(CustomerModel customerModel) {
        String id = customerModel.getId();
        String customerName = customerModel.getCustomerName();
        String address = customerModel.getAddress();
        String date = customerModel.getDate();
        String phoneNumber = customerModel.getPhoneNumber();
        String prescribedByDoctor = customerModel.getPrescribedByDoctor();
        double leftEyeSpherical = customerModel.getLeftEyeSpherical();
        double leftEyeCylindirical = customerModel.getLeftEyeCylindrical();
        double leftEyeVision = customerModel.getLeftEyeVision();
        double leftEyeAxis = customerModel.getLeftEyeAxis();
        double rightEyeSpherical = customerModel.getRightEyeSpherical();
        double rightEyeCylindirical = customerModel.getRightEyeCylindrical();
        double rightEyeVision = customerModel.getRightEyeVision();
        double rightEyeAxis = customerModel.getRightEyeAxis();
        return new Customer(id, customerName, address, date, phoneNumber, prescribedByDoctor, leftEyeSpherical, leftEyeCylindirical,
                leftEyeAxis, leftEyeVision, rightEyeSpherical, rightEyeCylindirical, rightEyeVision, rightEyeAxis,null);
    }
}

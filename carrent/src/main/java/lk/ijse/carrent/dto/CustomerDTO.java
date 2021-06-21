package lk.ijse.carrent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDTO {
    private Long customerID;
    private String firstName;
    private String lastName;
    private String nic;
    private String driveLicenseNumber;
    private String address;
    private String contactNumber;
    private String nicImage;

//    private List<RentDTO> rentOrder;


    public CustomerDTO(String firstName, String lastName, String nic, String driveLicenseNumber, String address, String contactNumber, String nicImage) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nic = nic;
        this.driveLicenseNumber = driveLicenseNumber;
        this.address = address;
        this.contactNumber = contactNumber;
        this.nicImage = nicImage;
    }
}

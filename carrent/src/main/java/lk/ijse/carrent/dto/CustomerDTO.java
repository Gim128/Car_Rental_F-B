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
    @Id
    private String customerID;
    private String firstName;
    private String lastName;
    private String nicNumber;
    private String driveLicenseNumber;
    private String address;
    private String contactNumber;

    private List<RentDTO> rentOrder;
}

package lk.ijse.carrent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RentDTO {
    @Id
    private String rentID;
    private String pickUpDate;
    private String pickOffDate;
    private String status;
    private String reason;
    private double totalFee;
    private String date;

    private CustomerDTO customerDTO;

    private VehicleDTO vehicleDTOe;

    private DriverDTO driverDTO;
}

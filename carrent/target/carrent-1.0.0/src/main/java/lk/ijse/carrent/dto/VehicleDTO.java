package lk.ijse.carrent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VehicleDTO {

    private String vehicleID;
    private String brand;
    private String model;
    private String type;
    private double extraFee;
    private String regNumber;
    private String color;
    private String passNumber;
    private String transmissionType;
    private String fuelType;
    private double dailyRent;
    private double monthlyRent;
    private String dailyKM;
    private String monthlyKM;

    private List<RentDTO> rentOrder;
}

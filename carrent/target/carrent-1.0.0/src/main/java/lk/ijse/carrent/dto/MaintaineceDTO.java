package lk.ijse.carrent.dto;


import lk.ijse.carrent.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MaintaineceDTO {

    private String maintainID;
    private String status;
    private String reason;
    private String date;

    private VehicleDTO vehicle;
}

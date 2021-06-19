package lk.ijse.carrent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ScheduleDTO {

    private String scheduleID;

    private RentDTO rentID;

    private DriverDTO driverID;
}

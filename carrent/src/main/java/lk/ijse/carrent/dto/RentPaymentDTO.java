package lk.ijse.carrent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RentPaymentDTO {

    private String rentID;
    private String date;
    private double fee;
    private String method;
}

package lk.ijse.carrent.dto;

import lk.ijse.carrent.entity.Returns;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class DamageDTO {

    private String damageID;
    private double returnFee;
    private String reason;
    private ReturnsDTO returnsID;

}

package lk.ijse.carrent.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StandardResponce {
    private String code;
    private String massage;
    private Object data;
}

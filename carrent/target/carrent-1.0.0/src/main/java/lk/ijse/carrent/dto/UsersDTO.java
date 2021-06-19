package lk.ijse.carrent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsersDTO {

    private String userID;
    private String userName;
    private String password;
    private String role;
}

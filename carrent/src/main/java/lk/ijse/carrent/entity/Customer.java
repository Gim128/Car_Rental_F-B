package lk.ijse.carrent.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {
    @Id
    private String customerID;
    private String firstName;
    private String lastName;
    private String nicNumber;
    private String driveLicenseNumber;
    private String address;
    private String contactNumber;
    @OneToMany(mappedBy = "customer",cascade = {CascadeType.ALL})
    private List<Rent> rentOrder;

}


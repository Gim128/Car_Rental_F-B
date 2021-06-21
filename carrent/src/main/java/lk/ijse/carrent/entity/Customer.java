package lk.ijse.carrent.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerID;
    private String firstName;
    private String lastName;
    private String nic;
    private String driveLicenseNumber;
    private String address;
    private String contactNumber;
    @Column(length = 1500)
    private String nicImage;
    @OneToMany(mappedBy = "customer",cascade = {CascadeType.ALL})
    private List<Rent> rentOrder;

}


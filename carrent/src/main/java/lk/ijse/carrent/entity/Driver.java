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
public class Driver {
    @Id
    private String driverId;
    private String firstName;
    private String lastName;
    private String address;
    private String contatNumber;
    private String nic;
    @OneToMany(mappedBy = "driver",cascade = {CascadeType.ALL})
    private List<Rent> rentOrder;


}

package lk.ijse.carrent.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Maintainece {
    @Id
    private String maintainID;
    private String status;
    private String reason;
    private String date;
    @ManyToOne()
    @JoinColumn(name = "vehicleID",referencedColumnName = "vehicleID")
    private Vehicle vehicle;
}
package lk.ijse.carrent.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Schedule {
    @Id
    private String scheduleID;
    @OneToOne
    private Rent rentID;
    @OneToOne
    private Driver driverID;
}


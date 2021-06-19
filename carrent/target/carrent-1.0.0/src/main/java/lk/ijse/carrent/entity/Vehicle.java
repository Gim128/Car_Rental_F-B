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

public class Vehicle {
    @Id
    private String vehicleID;
    private String brand;
    private String model;
    private String type;
    private double extraFee;
    private String regNumber;
    private String color;
    private String passNumber;
    private String transmissionType;
    private String fuelType;
    private double dailyRent;
    private double monthlyRent;
    private String dailyKM;
    private String monthlyKM;
    @OneToMany(mappedBy = "vehicle",cascade = {CascadeType.ALL})
    private List<Rent> rentOrder;

}


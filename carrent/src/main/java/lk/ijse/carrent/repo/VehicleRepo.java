package lk.ijse.carrent.repo;


import lk.ijse.carrent.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepo extends JpaRepository<Vehicle,String> {
}

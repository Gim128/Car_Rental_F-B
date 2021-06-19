package lk.ijse.carrent.repo;


import lk.ijse.carrent.entity.RentPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentPaymentRepo extends JpaRepository<RentPayment,String> {
}

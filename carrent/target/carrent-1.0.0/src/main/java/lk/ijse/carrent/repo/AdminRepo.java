package lk.ijse.carrent.repo;


import lk.ijse.carrent.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin,String> {
}

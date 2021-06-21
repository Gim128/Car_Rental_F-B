package lk.ijse.carrent.repo;


import lk.ijse.carrent.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer,Long> {
    @Query(value = "select * from Customer WHERE firstName LIKE %:cName% OR lastName LIKE %:cName%",nativeQuery = true)
    List<Customer> searchCustomersByName(@Param("cName") String name);

    boolean existsCustomerByNic(String nic);
}

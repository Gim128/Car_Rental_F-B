package lk.ijse.carrent.repo;


import lk.ijse.carrent.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsersRepo extends JpaRepository<Users,String> {
    @Query(value = "select * from Users WHERE username=:username AND password=:pass",nativeQuery = true)
    Users searchByUserNameAndPassword(@Param("username") String username, @Param("pass") String password);
}

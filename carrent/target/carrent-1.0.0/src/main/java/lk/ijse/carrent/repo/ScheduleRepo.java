package lk.ijse.carrent.repo;


import lk.ijse.carrent.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepo extends JpaRepository<Schedule,String> {
}

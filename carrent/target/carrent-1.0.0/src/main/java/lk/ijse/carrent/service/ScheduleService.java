package lk.ijse.carrent.service;



import lk.ijse.carrent.dto.ScheduleDTO;

import java.util.ArrayList;

public interface ScheduleService {
    void addSchedule(ScheduleDTO dto);

    void deleteSchedule(String id);

    ScheduleDTO searchSchedule(String id);

    ArrayList<ScheduleDTO> getAllSchedule();

    void updateSchedule(ScheduleDTO dto);
}

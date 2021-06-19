package lk.ijse.carrent.service;



import lk.ijse.carrent.dto.ReturnsDTO;

import java.util.ArrayList;

public interface ReturnsService {
    void addReturn(ReturnsDTO dto);

    void deleteReturn(String id);

    ReturnsDTO searchReturn(String id);

    ArrayList<ReturnsDTO> getAllReturn();

    void updateReturn(ReturnsDTO dto);
}

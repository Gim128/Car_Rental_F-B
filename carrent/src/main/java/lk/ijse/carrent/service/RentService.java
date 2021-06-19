package lk.ijse.carrent.service;



import lk.ijse.carrent.dto.RentDTO;

import java.util.ArrayList;

public interface RentService {
    void addRent(RentDTO dto);

    void deleteRent(String id);

    RentDTO searchRent(String id);

    ArrayList<RentDTO> getAllRent();

    void updateRent(RentDTO dto);
}

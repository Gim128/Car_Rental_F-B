package lk.ijse.carrent.service;



import lk.ijse.carrent.dto.MaintaineceDTO;

import java.util.ArrayList;

public interface MaintaineceService {
    void addMaintainece(MaintaineceDTO dto);

    void deleteMaintainece(String id);

    MaintaineceDTO searchMaintainece(String id);

    ArrayList<MaintaineceDTO> getAllMaintainece();

    void updateMaintainece(MaintaineceDTO dto);
}

package lk.ijse.carrent.service;



import lk.ijse.carrent.dto.VehicleDTO;

import java.util.ArrayList;

public interface VehicleService {
    void addVehicle(VehicleDTO dto);

    void deleteVehicle(String id);

    VehicleDTO searchVehicle(String id);

    ArrayList<VehicleDTO> getAllVehicle();

    void updateVehicle(VehicleDTO dto);
}

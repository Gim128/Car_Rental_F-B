package lk.ijse.carrent.service;



import lk.ijse.carrent.dto.AdminDTO;

import java.util.ArrayList;

public interface AdminService {
    void addAdmin(AdminDTO dto);

    void deleteAdmin(String id);

    AdminDTO searchAdmin(String id);

    ArrayList<AdminDTO> getAllAdmins();

    void updateAdmin(AdminDTO dto);
}

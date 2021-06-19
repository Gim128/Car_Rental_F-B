package lk.ijse.carrent.service.impl;


import lk.ijse.carrent.dto.AdminDTO;
import lk.ijse.carrent.entity.Admin;
import lk.ijse.carrent.exception.ValidateException;
import lk.ijse.carrent.repo.AdminRepo;
import lk.ijse.carrent.service.AdminService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class AdminServiceimpl implements AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addAdmin(AdminDTO dto) {
        if (adminRepo.existsById(dto.getAdminID())) {
            throw new ValidateException("Admin Already Exist");
        }
        adminRepo.save(mapper.map(dto, Admin.class));
    }

    @Override
    public void deleteAdmin(String id) {
        if (!adminRepo.existsById(id)) {
            throw new ValidateException("No Admin for Delete..!");
        }
        adminRepo.deleteById(id);

        adminRepo.deleteById(id);
    }

    @Override
    public AdminDTO searchAdmin(String id) {
        Optional<Admin> admin = adminRepo.findById(id);
        if (admin.isPresent()) {
            return mapper.map(admin.get(), AdminDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<AdminDTO> getAllAdmins() {
        List<Admin> all = adminRepo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<AdminDTO>>() {
        }.getType());
    }

    @Override
    public void updateAdmin(AdminDTO adminDTO) {
        if (adminRepo.existsById(adminDTO.getAdminID())) {
            adminRepo.save(mapper.map(adminDTO, Admin.class));
        }
    }
}

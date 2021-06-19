package lk.ijse.carrent.service.impl;


import lk.ijse.carrent.dto.DriverDTO;
import lk.ijse.carrent.dto.MaintaineceDTO;
import lk.ijse.carrent.dto.VehicleDTO;
import lk.ijse.carrent.entity.Driver;
import lk.ijse.carrent.entity.Maintainece;
import lk.ijse.carrent.exception.ValidateException;
import lk.ijse.carrent.repo.DriverRepo;
import lk.ijse.carrent.repo.MaintaineceRepo;
import lk.ijse.carrent.service.DriverService;
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

public class DriverServiceimpl implements DriverService {

    @Autowired
    private DriverRepo driverRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addDriver(DriverDTO dto) {
        if (driverRepo.existsById(dto.getDriverId())) {
            throw new ValidateException("DriverAlready Exist");
        }driverRepo.save(mapper.map(dto, Driver.class));
    }

    @Override
    public void deleteDriver(String id) {
        if (!driverRepo.existsById(id)) {
            throw new ValidateException("No Driver for Delete..!");
        }
//        maintaineceRepo.deleteById(id);

        driverRepo.deleteById(id);
    }

    @Override
    public DriverDTO searchDriver(String id) {
        Optional<Driver> maintainece = driverRepo.findById(id);
        if (maintainece.isPresent()) {
            return mapper.map(maintainece.get(), DriverDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<DriverDTO> getAllDriver() {
        List<Driver> driver = driverRepo.findAll();
        return mapper.map(driver,new TypeToken<ArrayList<VehicleDTO>>(){}.getType());
    }

    @Override
    public void updateDriver(DriverDTO dto) {
        if (driverRepo.existsById(dto.getDriverId())) {
            driverRepo.save(mapper.map(dto, Driver.class));
        }
    }
}

package lk.ijse.carrent.service.impl;


import lk.ijse.carrent.dto.ReturnsDTO;
import lk.ijse.carrent.dto.VehicleDTO;
import lk.ijse.carrent.entity.Returns;
import lk.ijse.carrent.exception.ValidateException;
import lk.ijse.carrent.repo.ReturnsRepo;
import lk.ijse.carrent.service.ReturnsService;
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

public class ReturnsServiceimpl implements ReturnsService {

    @Autowired
    private ReturnsRepo returnsRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addReturn(ReturnsDTO dto) {
        if (returnsRepo.existsById(dto.getReturnID())) {
            throw new ValidateException("Return Already Exist");
        }
        returnsRepo.save(mapper.map(dto, Returns.class));
    }

    @Override
    public void deleteReturn(String id) {
        if (!returnsRepo.existsById(id)) {
            throw new ValidateException("No Return for Delete..!");
        }
        returnsRepo.deleteById(id);

        returnsRepo.deleteById(id);
    }

    @Override
    public ReturnsDTO searchReturn(String id) {
        Optional<Returns> returns = returnsRepo.findById(id);
        if (returns.isPresent()) {
            return mapper.map(returns.get(), ReturnsDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<ReturnsDTO> getAllReturn() {
        List<Returns> returns = returnsRepo.findAll();
        return mapper.map(returns,new TypeToken<ArrayList<VehicleDTO>>(){}.getType());
    }

    @Override
    public void updateReturn(ReturnsDTO dto) {
        if (returnsRepo.existsById(dto.getReturnID())) {
            returnsRepo.save(mapper.map(dto, Returns.class));
        }
    }
}

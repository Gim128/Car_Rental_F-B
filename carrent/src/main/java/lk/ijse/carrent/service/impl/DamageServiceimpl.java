package lk.ijse.carrent.service.impl;

import lk.ijse.carrent.dto.DamageDTO;
import lk.ijse.carrent.dto.MaintaineceDTO;
import lk.ijse.carrent.dto.VehicleDTO;
import lk.ijse.carrent.entity.Damage;
import lk.ijse.carrent.entity.Maintainece;
import lk.ijse.carrent.exception.ValidateException;
import lk.ijse.carrent.repo.DamageRepo;
import lk.ijse.carrent.repo.MaintaineceRepo;
import lk.ijse.carrent.service.DamageService;
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

public class DamageServiceimpl implements DamageService {

    @Autowired
    private DamageRepo damageRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addDamage(DamageDTO dto) {
        if (damageRepo.existsById(dto.getDamageID())) {
            throw new ValidateException("Maintainece Already Exist");
        }
        damageRepo.save(mapper.map(dto, Damage.class));
    }

    @Override
    public void deleteDamage(String id) {
            if (!damageRepo.existsById(id)) {
                throw new ValidateException("No Damage vehicle for Delete..!");
            }
//        maintaineceRepo.deleteById(id);

            damageRepo.deleteById(id);

    }

    @Override
    public DamageDTO searchDamage(String id) {
            Optional<Damage> damage = damageRepo.findById(id);
            if (damage.isPresent()) {
                return mapper.map(damage.get(), DamageDTO.class);
            }
            return null;
    }

    @Override
    public ArrayList<DamageDTO> getAllDamage() {
            List<Damage> damages = damageRepo.findAll();
            return mapper.map(damages,new TypeToken<ArrayList<VehicleDTO>>(){}.getType());
    }

    @Override
    public void updateDamage(DamageDTO dto) {
        if (damageRepo.existsById(dto.getDamageID())) {
            damageRepo.save(mapper.map(dto, Damage.class));
        }
    }
}

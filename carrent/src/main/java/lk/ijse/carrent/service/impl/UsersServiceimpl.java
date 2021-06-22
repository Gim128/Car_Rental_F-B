package lk.ijse.carrent.service.impl;


import lk.ijse.carrent.dto.UsersDTO;
import lk.ijse.carrent.dto.VehicleDTO;
import lk.ijse.carrent.entity.Users;
import lk.ijse.carrent.exception.ValidateException;
import lk.ijse.carrent.repo.UsersRepo;
import lk.ijse.carrent.service.UsersService;
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

public class UsersServiceimpl implements UsersService {

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private ModelMapper mapper;


    @Override
    public void addUsers(UsersDTO dto) {
        if (usersRepo.existsById(dto.getUserID())) {
            throw new ValidateException("User Already Exist");
        }
        usersRepo.save(mapper.map(dto, Users.class));
    }

    @Override
    public void deleteUsers(String id) {
        if (!usersRepo.existsById(id)) {
            throw new ValidateException("No User for Delete..!");
        }
        usersRepo.deleteById(id);

        usersRepo.deleteById(id);
    }

    @Override
    public UsersDTO searchUsers(String id) {
        Optional<Users> users = usersRepo.findById(id);
        if (users.isPresent()) {
            return mapper.map(users.get(), UsersDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<UsersDTO> getAllUsers() {
        List<Users> users = usersRepo.findAll();
        return mapper.map(users,new TypeToken<ArrayList<VehicleDTO>>(){}.getType());
    }

    @Override
    public void updateUsers(UsersDTO dto) {
        if (usersRepo.existsById(dto.getUserID())) {
            usersRepo.save(mapper.map(dto, Users.class));
        }
    }

    @Override
    public UsersDTO searchByUser(String id, String password) {
        Users op = usersRepo.searchByUserNameAndPassword(id, password);
        if (op==null) {
            System.out.println("Not Found");
        }else{
            return mapper.map(op, UsersDTO.class);
        }
        return null;
    }
}

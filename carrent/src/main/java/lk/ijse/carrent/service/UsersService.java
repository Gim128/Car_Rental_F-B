package lk.ijse.carrent.service;



import lk.ijse.carrent.dto.UsersDTO;

import java.util.ArrayList;

public interface UsersService {
    void addUsers(UsersDTO dto);

    void deleteUsers(String id);

    UsersDTO searchUsers(String id);

    ArrayList<UsersDTO> getAllUsers();

    void updateUsers(UsersDTO dto);

    UsersDTO searchByUser(String id,String password);
}

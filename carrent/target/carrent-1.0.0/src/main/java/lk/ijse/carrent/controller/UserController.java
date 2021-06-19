package lk.ijse.carrent.controller;

import lk.ijse.carrent.dto.DriverDTO;
import lk.ijse.carrent.dto.UsersDTO;
import lk.ijse.carrent.exception.NotFoundException;
import lk.ijse.carrent.service.UsersService;
import lk.ijse.carrent.util.StandardResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("/easycarrent/users")

public class UserController {
    @Autowired
    private UsersService usersService ;

    @GetMapping(path = "search/{id}")
    public ResponseEntity searchUsers(String id){
        UsersDTO usersDTO = usersService.searchUsers(id);
        return new ResponseEntity(new StandardResponce("200", "Done", usersDTO), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveUsers(@RequestBody UsersDTO usersDTO){
        if (usersDTO.getUserID().trim().length() <= 0) {
            throw new NotFoundException("User id cannot be empty");
        }
        usersService.addUsers(usersDTO);
        return new ResponseEntity(new StandardResponce("201", "Done", usersDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateUsers(@RequestBody UsersDTO usersDTO){

        if (usersDTO.getUserID().trim().length() <= 0) {
            throw new NotFoundException("No id provided to update");
        }
        usersService.updateUsers(usersDTO);
        return new ResponseEntity(new StandardResponce("200", "Done", usersDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity DeleteUsers(String id){

        usersService.deleteUsers(id);
        return new ResponseEntity(new StandardResponce("200", "Done", null), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllUsers(@RequestBody DriverDTO driverDTO){
        ArrayList<UsersDTO> allUsers= usersService.getAllUsers();
        return new ResponseEntity(new StandardResponce("200", "Done", allUsers), HttpStatus.OK);
    }

        @GetMapping(path = "searchuser/{name}/{password}")
    public ResponseEntity searchByUser(@PathVariable String name, @PathVariable String password) {
        UsersDTO dto = usersService.searchByUser(name, password);
        return new ResponseEntity(new StandardResponce("200", "Done", dto), HttpStatus.OK);
    }

}

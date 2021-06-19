package lk.ijse.carrent.controller;

import lk.ijse.carrent.dto.DriverDTO;
import lk.ijse.carrent.exception.NotFoundException;
import lk.ijse.carrent.service.DriverService;
import lk.ijse.carrent.util.StandardResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("/easycarrent/driver")
public class DriverController {
    @Autowired
    private DriverService driverService ;

    @GetMapping(path = "search/{id}")
    public ResponseEntity searchDriver(String id){
        DriverDTO driverDTO = driverService.searchDriver(id);
        return new ResponseEntity(new StandardResponce("200", "Done", driverDTO), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveDamage(@RequestBody DriverDTO driverDTO){
        if (driverDTO.getDriverId().trim().length() <= 0) {
            throw new NotFoundException("Damage id cannot be empty");
        }
        driverService.addDriver(driverDTO);
        return new ResponseEntity(new StandardResponce("201", "Done", driverDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateCustomer(@RequestBody DriverDTO driverDTO){

        if (driverDTO.getDriverId().trim().length() <= 0) {
            throw new NotFoundException("No id provided to update");
        }
        driverService.updateDriver(driverDTO);
        return new ResponseEntity(new StandardResponce("200", "Done", driverDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity DeleteDriver(String id){

        driverService.deleteDriver(id);
        return new ResponseEntity(new StandardResponce("200", "Done", null), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllDriver(@RequestBody DriverDTO driverDTO){
        ArrayList<DriverDTO> allDamage = driverService.getAllDriver();
        return new ResponseEntity(new StandardResponce("200", "Done", allDamage), HttpStatus.OK);
    }
}

package lk.ijse.carrent.controller;

import lk.ijse.carrent.dto.VehicleDTO;
import lk.ijse.carrent.exception.NotFoundException;
import lk.ijse.carrent.service.VehicleService;
import lk.ijse.carrent.util.StandardResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("/easycarrent/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService service;

    @GetMapping(path = "search/{id}")
    public ResponseEntity searchVehicle(String id) {
        VehicleDTO dto = service.searchVehicle(id);
        return new ResponseEntity(new StandardResponce("200", "Done", dto), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveVehicle(@RequestBody VehicleDTO dto) {
        if (dto.getVehicleID().trim().length() <= 0) {
            throw new NotFoundException("Rent Vehicle ID cannot be empty");
        }
        service.addVehicle(dto);
        return new ResponseEntity(new StandardResponce("201", "Done", dto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateVehicle(@RequestBody VehicleDTO dto) {
        if (dto.getVehicleID().trim().length() <= 0) {
            throw new NotFoundException("No ID provided to update");
        }
        service.updateVehicle(dto);
        return new ResponseEntity(new StandardResponce("200", "Done", dto), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteVehicle(String id) {
        service.deleteVehicle(id);
        return new ResponseEntity(new StandardResponce("200", "Done", null), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllVehicle() {
        ArrayList<VehicleDTO> all = service.getAllVehicle();
        return new ResponseEntity(new StandardResponce("200", "Done", all), HttpStatus.OK);
    }
}


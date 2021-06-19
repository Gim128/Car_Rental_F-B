package lk.ijse.carrent.controller;

import lk.ijse.carrent.dto.MaintaineceDTO;
import lk.ijse.carrent.exception.NotFoundException;
import lk.ijse.carrent.service.MaintaineceService;
import lk.ijse.carrent.util.StandardResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("/easycarrent/maintainece")

public class MaintaineceController {

    @Autowired
    private MaintaineceService maintaineceService ;

    @GetMapping(path = "search/{id}")
    public ResponseEntity searchMaintainece(String id){
        MaintaineceDTO maintaineceDTO = maintaineceService.searchMaintainece(id);
        return new ResponseEntity(new StandardResponce("200", "Done", maintaineceDTO), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveMaintainece(@RequestBody MaintaineceDTO maintaineceDTO){
        if (maintaineceDTO.getMaintainID().trim().length() <= 0) {
            throw new NotFoundException("Maintainece id cannot be empty");
        }
        maintaineceService.addMaintainece(maintaineceDTO);
        return new ResponseEntity(new StandardResponce("201", "Done", maintaineceService), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateMaintainece(@RequestBody MaintaineceDTO maintaineceDTO){

        if (maintaineceDTO.getMaintainID().trim().length() <= 0) {
            throw new NotFoundException("No id provided to update");
        }
        maintaineceService.updateMaintainece(maintaineceDTO);
        return new ResponseEntity(new StandardResponce("200", "Done", maintaineceDTO), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity DeleteMaintainece(String id){

        maintaineceService.deleteMaintainece(id);
        return new ResponseEntity(new StandardResponce("200", "Done", null), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllMaintainece(@RequestBody MaintaineceDTO maintaineceDTO){
        ArrayList<MaintaineceDTO> allMaintainece = maintaineceService.getAllMaintainece();
        return new ResponseEntity(new StandardResponce("200", "Done", allMaintainece), HttpStatus.OK);
    }

}

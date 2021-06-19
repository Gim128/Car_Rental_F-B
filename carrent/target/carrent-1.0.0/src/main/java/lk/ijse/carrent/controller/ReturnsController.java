package lk.ijse.carrent.controller;

import lk.ijse.carrent.dto.DriverDTO;
import lk.ijse.carrent.dto.ReturnsDTO;
import lk.ijse.carrent.exception.NotFoundException;
import lk.ijse.carrent.service.ReturnsService;
import lk.ijse.carrent.util.StandardResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("/easycarrent/return")

public class ReturnsController {
    @Autowired
    private ReturnsService returnsService ;

    @GetMapping(path = "search/{id}")
    public ResponseEntity searchReturns(String id){
        ReturnsDTO returnsDTO = returnsService.searchReturn(id);
        return new ResponseEntity(new StandardResponce("200", "Done", returnsDTO), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveReturns(@RequestBody ReturnsDTO returnsDTO){
        if (returnsDTO.getReturnID().trim().length() <= 0) {
            throw new NotFoundException("Returns id cannot be empty");
        }
        returnsService.addReturn(returnsDTO);
        return new ResponseEntity(new StandardResponce("201", "Done", returnsDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateReturns(@RequestBody ReturnsDTO returnsDTO){

        if (returnsDTO.getReturnID().trim().length() <= 0) {
            throw new NotFoundException("No id provided to update");
        }
        returnsService.updateReturn(returnsDTO);
        return new ResponseEntity(new StandardResponce("200", "Done", returnsDTO), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity DeleteReturns(String id){

        returnsService.deleteReturn(id);
        return new ResponseEntity(new StandardResponce("200", "Done", null), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllReturns(@RequestBody DriverDTO driverDTO){
        ArrayList<ReturnsDTO> allReturn = returnsService.getAllReturn();
        return new ResponseEntity(new StandardResponce("200", "Done", allReturn), HttpStatus.OK);
    }
}

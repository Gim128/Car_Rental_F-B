package lk.ijse.carrent.controller;

import lk.ijse.carrent.dto.DriverDTO;
import lk.ijse.carrent.dto.RentPaymentDTO;
import lk.ijse.carrent.exception.NotFoundException;
import lk.ijse.carrent.service.RentPaymentService;
import lk.ijse.carrent.util.StandardResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("/easycarrent/rentpayment")

public class RentPaymentController {
    @Autowired
    private RentPaymentService rentPaymentService ;

    @GetMapping(path = "search/{id}")
    public ResponseEntity searchRentPayment(String id){
        RentPaymentDTO rentPaymentDTO = rentPaymentService.searchRentPayment(id);
        return new ResponseEntity(new StandardResponce("200", "Done", rentPaymentDTO), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveRentPayment(@RequestBody RentPaymentDTO rentPaymentDTO){
        if (rentPaymentDTO.getRentID().trim().length() <= 0) {
            throw new NotFoundException("Damage id cannot be empty");
        }
        rentPaymentService.addRentPayment(rentPaymentDTO);
        return new ResponseEntity(new StandardResponce("201", "Done", rentPaymentDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateCustomer(@RequestBody RentPaymentDTO rentPaymentDTO){

        if (rentPaymentDTO.getRentID().trim().length() <= 0) {
            throw new NotFoundException("No id provided to update");
        }
        rentPaymentService.updateRentPayment(rentPaymentDTO);
        return new ResponseEntity(new StandardResponce("200", "Done", rentPaymentDTO), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity DeleteRentpayment(String id){

        rentPaymentService.deleteRentPayment(id);
        return new ResponseEntity(new StandardResponce("200", "Done", null), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllRentPayment(@RequestBody DriverDTO driverDTO){
        ArrayList<RentPaymentDTO> allRentPayment = rentPaymentService.getAllRentPayment();
        return new ResponseEntity(new StandardResponce("200", "Done", allRentPayment), HttpStatus.OK);
    }
}

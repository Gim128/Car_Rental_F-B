package lk.ijse.carrent.service.impl;


import lk.ijse.carrent.dto.AdminDTO;
import lk.ijse.carrent.dto.CustomerDTO;
import lk.ijse.carrent.entity.Admin;
import lk.ijse.carrent.entity.Customer;
import lk.ijse.carrent.exception.ValidateException;
import lk.ijse.carrent.repo.AdminRepo;
import lk.ijse.carrent.repo.CustomerRepo;
import lk.ijse.carrent.service.AdminService;
import lk.ijse.carrent.service.CustomerService;
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

public class CustomerServiceimpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addCustomer(CustomerDTO dto) {
        if (customerRepo.existsById(dto.getCustomerID())) {
            throw new ValidateException("Customer Already Exist");
        }
        customerRepo.save(mapper.map(dto, Customer.class));
    }

    @Override
    public void deleteCustomer(String id) {

        if (!customerRepo.existsById(id)) {
            throw new ValidateException("No Customer for Delete..!");
        }
        customerRepo.deleteById(id);

//        customerRepo.deleteById(id);
    }

    @Override
    public CustomerDTO searchCustomer(String id) {
        Optional<Customer> customer = customerRepo.findById(id);
        if (customer.isPresent()) {
            return mapper.map(customer.get(), CustomerDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() {
        List<Customer> all = customerRepo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<CustomerDTO>>() {
        }.getType());
    }

    @Override
    public void updateCustomer(CustomerDTO dto) {
        if (customerRepo.existsById(dto.getCustomerID())) {
            customerRepo.save(mapper.map(dto, Customer.class));
        }
    }
}

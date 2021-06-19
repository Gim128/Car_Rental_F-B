package lk.ijse.carrent.service;


import lk.ijse.carrent.dto.CustomerDTO;

import java.util.ArrayList;

public interface CustomerService {
    void addCustomer(CustomerDTO dto);

    void deleteCustomer(String id);

    CustomerDTO searchCustomer(String id);

    ArrayList<CustomerDTO> getAllCustomers();

    void updateCustomer(CustomerDTO dto);
}

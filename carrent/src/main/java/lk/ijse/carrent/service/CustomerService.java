package lk.ijse.carrent.service;


import lk.ijse.carrent.dto.CustomerDTO;

import java.util.ArrayList;

public interface CustomerService {
    void addCustomer(CustomerDTO dto);

    void deleteCustomer(Long id);

    CustomerDTO searchCustomer(Long id);

    ArrayList<CustomerDTO> getAllCustomers();

    ArrayList<CustomerDTO> SearchCustomersByName(String name);

    void updateCustomer(CustomerDTO dto);
}

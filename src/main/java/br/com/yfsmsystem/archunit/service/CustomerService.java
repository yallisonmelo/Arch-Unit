package br.com.yfsmsystem.archunit.service;

import br.com.yfsmsystem.archunit.entity.CustomerEntity;
import br.com.yfsmsystem.archunit.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;


    public void createCustomer(CustomerEntity customerEntity) {
        customerRepository.saveCustomer(customerEntity);
    }

    public void updateCustomer(CustomerEntity customerEntity) {
        customerRepository.updateCustomer(customerEntity);
    }

    public void deleteCustomer(Integer id) {
        customerRepository.deleteCustomer(id);
    }

    public CustomerEntity findCustomer(Integer id) {
        return customerRepository.findById(id);
    }
}

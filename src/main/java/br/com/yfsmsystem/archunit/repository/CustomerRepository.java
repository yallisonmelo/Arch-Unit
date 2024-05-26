package br.com.yfsmsystem.archunit.repository;

import br.com.yfsmsystem.archunit.entity.CustomerEntity;
import br.com.yfsmsystem.archunit.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class CustomerRepository {

    private final CustomerService customerService;
    private List<CustomerEntity> customers;

    public void testRulesImport() {
        customerService.findCustomer(1);
    }

    public List<CustomerEntity> findAll() {
        return customers;
    }

    public CustomerEntity findById(Integer id) {
        return customers.stream().filter(x -> Objects.equals(x.getId(), id)).findFirst().orElseThrow(RuntimeException::new);
    }

    public void saveCustomer(CustomerEntity customer) {
        customers.add(customer);
    }

    public void deleteCustomer(Integer id) {
        customers.removeIf(x -> Objects.equals(x.getId(), id));
    }

    public void updateCustomer(CustomerEntity customer) {
        customers.stream().filter(x -> Objects.equals(x.getId(), customer.getId())).findFirst().orElseThrow(RuntimeException::new);
    }
}

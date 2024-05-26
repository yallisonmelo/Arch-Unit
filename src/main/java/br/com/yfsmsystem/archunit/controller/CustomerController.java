package br.com.yfsmsystem.archunit.controller;

import br.com.yfsmsystem.archunit.entity.CustomerEntity;
import br.com.yfsmsystem.archunit.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public CustomerEntity getCustomerById(@PathVariable Integer id) {
        return customerService.findCustomer(id);
    }

    @GetMapping("/delete/{id}")
    public HttpStatus deleteCustomerById(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
        return HttpStatus.NO_CONTENT;
    }

    @GetMapping("/save")
    public HttpStatus saveCustomer(@RequestBody CustomerEntity customerEntity) {
        customerService.createCustomer(customerEntity);
        return HttpStatus.OK;
    }

    @GetMapping("/update")
    public HttpStatus updateCustomer(@RequestBody CustomerEntity customerEntity) {
        customerService.updateCustomer(customerEntity);
        return HttpStatus.OK;
    }
}

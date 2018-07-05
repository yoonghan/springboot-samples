package com.walcron.sample.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.walcron.sample.repository.CustomerRepository;
import com.walcron.sample.model.Customer;

@RestController
public class CustomerRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerRestController.class);

    @Autowired
    private transient CustomerRepository repository;

    @RequestMapping("customer/")
    public List<Customer> findAll() {
        LOGGER.info("testing");
        return repository.findAll();
    }

    @RequestMapping(value = "customer/", method = RequestMethod.POST)
    public void save(@RequestBody Customer customer) {
        repository.save(customer);
    }
}

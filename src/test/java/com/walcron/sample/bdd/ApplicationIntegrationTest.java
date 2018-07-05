package com.walcron.sample.bdd;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.walcron.sample.model.Customer;
import com.walcron.sample.repository.CustomerRepository;


@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
@AutoConfigureMockMvc
public class ApplicationIntegrationTest {

    protected static ResultActions latestResult = null;

    @Autowired(required=false)
    private MockMvc mockMvc;

    @Autowired
    @MockBean
    CustomerRepository customerRepository;

    public void setupCustomer() {
        Customer customer = new Customer();
        customer.firstName = "_firstname";
        customer.id = "0";
        customer.lastName = "_lastname";
        List<Customer> customers = new ArrayList<Customer>(1);
        customers.add(customer);
        Mockito.when(customerRepository.findAll()).thenReturn(customers);
    }

    public void executeGet(String url) throws Exception {
        setupCustomer();
        latestResult = this.mockMvc.perform(get(url)).andDo(print());
    }

    public void executePOST(String url, String input) throws Exception {
        latestResult = this.mockMvc.perform(post(url).content(input).contentType(MediaType.APPLICATION_JSON)).andDo(print());
    }
}

package com.walcron.sample.smoke;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.walcron.sample.controller.CustomerRestController;

/**
 * Smoke test is a lightweight test  to ensure that basic functionality is working. E.g. Controller is not null!
 * @author hayoong
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeCustomerTest {
    @Autowired
    private CustomerRestController controller;

    @Test
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
}

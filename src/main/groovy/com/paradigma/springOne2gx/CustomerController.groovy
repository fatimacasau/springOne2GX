package com.paradigma.springOne2gx

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.servlet.ModelAndView

/**
 * Created by fcasau on 1/28/15.
 */
@Controller
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository

    @RequestMapping("/customer/{id}")
    @ResponseBody
    public Customer findById(@PathVariable Long id) {
        return customerRepository.findOne(id)
    }

    @RequestMapping("/customers")
    def list() {
        new ModelAndView('views/customer/list', [customers: customerRepository.findAll()])
    }
}

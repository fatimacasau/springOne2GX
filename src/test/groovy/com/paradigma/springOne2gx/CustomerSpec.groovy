package com.paradigma.springOne2gx

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by fcasau on 1/29/15.
 */
@ContextConfiguration(loader = SpringApplicationContextLoader,classes = [Application.class])
class CustomerSpec extends Specification {

    @Autowired
    CustomerRepository customerRepository

    @Unroll
    void "add new Customer with params #params? result: #result"(){
        expect: "result when save new object with diferent params"
            try {
                result == (customerRepository.save(new Customer(params)) != null)
            }catch (Exception e){
                result = null
            }
        where: "params are...result is..."
            result || params
            true   || [firstName:'first', lastName:'last']
            false  || [:]
    }

}
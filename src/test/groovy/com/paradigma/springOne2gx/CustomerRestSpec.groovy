package com.paradigma.springOne2gx

import groovyx.net.http.RESTClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.IntegrationTest
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.http.HttpStatus
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import spock.lang.Specification
import spock.lang.Unroll

import static groovyx.net.http.ContentType.JSON

@WebAppConfiguration
@ContextConfiguration(loader = SpringApplicationContextLoader.class,classes = [Application.class])
@IntegrationTest("server.port:8080")
class CustomerRestSpec extends Specification {

    @Unroll
    def "create new customer via REST with different params: #params"(){
        setup: "people uri"
            RESTClient rest = new RESTClient("http://localhost:8080")
            def uri = "/customer"
        expect: "status ok"
            result == rest.post(requestContentType : JSON, path : uri, body : params).status
        where: "different params"
            result                      | params
            HttpStatus.CREATED.value()  | [firstName:"user1",lastName:"surname1"]
            HttpStatus.CREATED.value()  | [firstName:"user2",lastName:"surname2"]
            //HttpStatus.OK.value()       | [firstName:"user3",lastName:"surname3"] // fails!
    }

    def "find a customer via REST"(){
        given: "an existing customer"
            RESTClient rest = new RESTClient("http://localhost:8080")
            def customerId = 1
        and: "people uri"
            def uri = "/customer/${customerId}"
        when:
            def result = rest.get(path: uri)
        then:
            result.status == HttpStatus.OK.value()
    }

}

package com.paradigma.springOne2gx

import groovyx.net.http.RESTClient
import org.springframework.http.HttpStatus
import spock.lang.Specification
import spock.lang.Unroll

class GoogleSpec extends Specification {

    void "test Google Maps API where address is 'Madrid' "() {

        setup: "Google Maps API Host & Uri"
            def rest = new RESTClient("https://maps.googleapis.com")
            def uri = "/maps/api/geocode/json"

        when: "Call the API with address = 'madrid' "
            def result = rest.get(path: uri, query: [address: 'madrid'])

        then: "HttpStatus is OK and return a list of results"
            result
            result.status == HttpStatus.OK.value()
            !result.data.results.isEmpty()
            result.data.status == 'OK'
            result.data.results[0].address_components.any{it.long_name == 'Madrid'}
    }

    @Unroll
    void "test Google Maps API where address is #address"(){
        setup: "Google Maps API Host & Uri"
            def rest = new RESTClient("https://maps.googleapis.com")
            def uri = "/maps/api/geocode/json"
        expect: "result & status when call the REST API"
            def result = rest.get(path: uri, query: [address:address])
            resultsIsEmpty == result.data.results.isEmpty()
            result.data.status == status
        where: "address takes different values with different results & status"
            address | resultsIsEmpty | status
            'Madrid'| false          | 'OK'
            'abdkji'| true           | 'ZERO_RESULTS'

    }


}
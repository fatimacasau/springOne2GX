package com.paradigma.springOne2gx

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ConfigurableApplicationContext

@SpringBootApplication
class Application {

	static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(Application.class)

		// save a couple of customers
		[[firstName:"Rachel Karen", lastName:"Green"],
		 [firstName:"Monica E.", lastName:"Geller"],
		 [firstName:"Phoebe", lastName:"Buffay"],
		 [firstName:"Joey", lastName:"Tribbiani"],
		 [firstName:"Ross", lastName:"Geller"],
		 [firstName:"Chandler Muriel", lastName:"Bing"]].each {
			new Customer(it).save()
		}

		// fetch all customers
		def customers = Customer.list()
		println "Customers: \n-------------------------------"
		customers.each {
			println it
		}

		// fetch an individual customer by ID
		Customer customer = Customer.get(1L)
		println "Customer found with get(1L): $customer \n"

		// fetch customers by last name
		def lastName = "Bing"
		customers = Customer.findByLastName(lastName)
		println "Customer found with findByLastName('$lastName'): \n--------------------------------------------"
		customers.each {println it}
	}
}

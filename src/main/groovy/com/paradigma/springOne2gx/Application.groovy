package com.paradigma.springOne2gx

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ConfigurableApplicationContext

@SpringBootApplication
class Application {

	static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(Application.class)

		CustomerRepository repository = context.getBean(CustomerRepository.class)

		// save a couple of customers
		[[firstName:"Rachel Karen", lastName:"Green"],
		 [firstName:"Monica E.", lastName:"Geller"],
		 [firstName:"Phoebe", lastName:"Buffay"],
		 [firstName:"Joey", lastName:"Tribbiani"],
		 [firstName:"Ross", lastName:"Geller"],
		 [firstName:"Chandler Muriel", lastName:"Bing"]].each {
			repository.save(new Customer(it))
		}

		// fetch all customers
		Iterable<Customer> customers = repository.findAll()
		println "Customers found with findAll(): \n-------------------------------"
		customers.each {
			println it
		}
		// fetch an individual customer by ID
		Customer customer = repository.findOne(1L)
		println "Customer found with findOne(1L): $customer \n"

		// fetch customers by last name
		def lastName = "Bing"
		customers = repository.findByLastName(lastName)
		println "Customer found with findByLastName('$lastName'): \n--------------------------------------------"
		customers.each {println it}
	}
}

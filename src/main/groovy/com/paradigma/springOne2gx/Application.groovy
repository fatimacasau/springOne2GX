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
		[[firstName:"Jack", lastName:"Bauer"],
		 [firstName:"Chloe", lastName:"O'Brian"],
		 [firstName:"Kim", lastName:"Bauer"],
		 [firstName:"David", lastName:"Palmer"],
		 [firstName:"Michelle", lastName:"Dessler"]].each {
			repository.save(new Customer(it))
		}

		// fetch all customers
		Iterable<Customer> customers = repository.findAll()
		println "Customers found with findAll(): \n-------------------------------"
		customers.each {
			println it
		}
		// fetch an individual customer by ID
		Customer customer = repository.findOne(1L);
		println "Customer found with findOne(1L): $customer \n"

		// fetch customers by last name
		List<Customer> bauers = repository.findByLastName("Bauer");
		println "Customer found with findByLastName('Bauer'): \n--------------------------------------------"
		bauers.each {println it}
	}
}

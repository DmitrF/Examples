package ru.javaxblog.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.javaxblog.customer.services.CustomerService;

public class App {

	public static void main(String[] args) throws Exception {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"Spring-Customer.xml");
		CustomerService customer = (CustomerService) appContext
				.getBean("customerService");
		customer.addCustomer();
		customer.addCustomerReturnValue();
		customer.addCustomerAround("javaxblog");
		 customer.addCustomerThrowException();
	}

}

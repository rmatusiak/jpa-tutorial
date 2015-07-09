package com.acme;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acme.order.customer.Customer;
import com.acme.order.customer.CustomerRepository;
import com.acme.order.customer.CustomerType;
import com.acme.order.customer.CustomerTypeRepository;
import com.acme.order.pizza.PizzaOrder;
import com.acme.order.pizza.PizzaOrderService;
import com.acme.order.pizza.PizzaType;
import com.google.common.collect.Lists;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = JpaTutorialApplication.class)
public class JpaTutorialApplicationTests {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private PizzaOrderService orderService;
	
	@Autowired
	private CustomerTypeRepository customerTypeRepository;
	
	
	@Test
	public void contextLoads() {
		
	}
	
	@Test
	public void dataLoads(){
		
		CustomerType type1 = new CustomerType(null, "INDIVIDUAL");
		CustomerType type2 = new CustomerType(null, "INDIVIDUAL");
		customerTypeRepository.save(Lists.newArrayList(type1, type2));
		
		Customer customer1 = new Customer(null,"John  Smith", "john@smith.com", "Lodz, Jaracza 74", type1);
		Customer customer2 = new Customer(null, "Jan Kowalski", "jan@kowalski.pl", "Lodz, Piotrkowska 100", type2);
		customerRepository.save(Lists.newArrayList(customer1, customer2));
		
		
		Long orderId1 = orderService.createOrder(customer1, PizzaType.LARGE);
		Long orderId2 = orderService.createOrder(customer2, PizzaType.SMALL);
	}
	
	
	

}

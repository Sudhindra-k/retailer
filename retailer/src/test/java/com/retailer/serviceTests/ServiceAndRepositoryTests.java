package com.retailer.serviceTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.retailer.dao.BillingRepository;
import com.retailer.dao.CustomerRepository;
import com.retailer.entity.BillingOrder;
import com.retailer.entity.Customer;
import com.retailer.entity.Product;
import com.retailer.service.RetailerService;

//Service and Repository Test Cases
@SpringBootTest
public class ServiceAndRepositoryTests {

	@MockBean
	private CustomerRepository customerRepository;
	
	@MockBean
	private BillingRepository billingRepository;
	
	@MockBean
	private RetailerService service;
	
	Customer customer;
	Product product;
	BillingOrder billingorder;
	Date date;
	
	@BeforeEach
	void init() {
		long millis = System.currentTimeMillis();
		date = new Date(millis);
		customer = new Customer(1,"Dan" , 81212123181L, "dan@dan.com" , "city");
		product = new Product(1,"Product" , "ProductDescription",110f);
		billingorder = new BillingOrder(1, 2, date , customer, product);
	}
	
	@Test
	@DisplayName("Customers-find all")
	public void getcustomers() {
		when(customerRepository.findAll()).thenReturn(Stream.of(customer).collect(Collectors.toList()));
		assertEquals(1, customerRepository.findAll().size());
	}
	
	@Test
	@DisplayName("Customers find by Id")
	public void getcustomerbyId() {
		when(customerRepository.findById(1)).thenReturn(Optional.of(customer));
		assertEquals(customer, customerRepository.findById(1).get());
	}
	
	@Test
	@DisplayName("Orders-find all")
	public void getorders() {
		when(billingRepository.findAll()).thenReturn(Stream.of(billingorder).collect(Collectors.toList()));
		assertEquals(1, billingRepository.findAll().size());
	}
	
	@Test
	@DisplayName("Orders find by Id")
	public void getorderbyId() {
		when(billingRepository.findById(1)).thenReturn(Optional.of(billingorder));
		assertEquals(billingorder, billingRepository.findById(1).get());
	}
	
	@Test
	@DisplayName("Getting Customer by Order")
	public void getcustomerbyorderid() {
		when(billingRepository.findByCustomerId(1)).thenReturn(Stream.of(billingorder).collect(Collectors.toList()));
		assertEquals(1, billingRepository.findByCustomerId(1).size());
	}

	@Test
	@DisplayName("Service-Customers-find all")
	public void getcustomersbyservice() {
		when(service.findAll()).thenReturn(Stream.of(customer).collect(Collectors.toList()));
		assertEquals(1, service.findAll().size());
	}
	
	@Test
	@DisplayName("Service - Getting Customer by Order")
	public void getcustomerbyorderidService() {
		when(service.findByCustomerId(1)).thenReturn(Stream.of(billingorder).collect(Collectors.toList()));
		assertEquals(1, service.findByCustomerId(1).size());
	}
	
	
}


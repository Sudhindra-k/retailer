package com.retailer.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.retailer.entity.BillingOrder;
import com.retailer.entity.Customer;
import com.retailer.service.RetailerService;

//Controller Class
@Controller
public class RetailerController {
	Logger logger = LoggerFactory.getLogger(RetailerController.class);
	private RetailerService service;
	
	public RetailerController(RetailerService service) {
		this.service = service;
	}
	
	//Getting a List of Customers
	@GetMapping("/list")
	public String customers(Model model) {
		logger.debug("Customers Method accessed");
		List<Customer> allcustomers = service.findAll();
		model.addAttribute("customers" ,  allcustomers);
		logger.info("Retrieving All Customers");
		return "customers";
		
	}
	
	//Getting Orders of Customer by ID
	@GetMapping("/order")
	public String findcustomerbyorderid(@RequestParam("id") int id, Model model) {
		logger.info("Finding Orders based on Customer Id");
		List<BillingOrder> billings = service.findByCustomerId(id);
		List<Integer> rewardsListfinal = service.totalRewardsList(id);
		List<Date> date = new ArrayList<>();
		int totalrewards =0;

		billings.forEach(dates ->  date.add(dates.getDateoforder()) );
		Collections.sort(date, Collections.reverseOrder());
		totalrewards = rewardsListfinal.stream().mapToInt(Integer::valueOf).sum();
		
		model.addAttribute("orders", billings);
		model.addAttribute("rewards", rewardsListfinal);
		model.addAttribute("totalrewards", totalrewards);
		model.addAttribute("dates", date);
		
		logger.info("Retrieving All Orders placed by Customer");
		return "orders";
	}
}

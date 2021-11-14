package com.retailer.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.retailer.dao.BillingRepository;
import com.retailer.dao.CustomerRepository;
import com.retailer.entity.BillingOrder;
import com.retailer.entity.Customer;

//Service Class
@Service
public class RetailerService {
	Logger logger = LoggerFactory.getLogger(RetailerService.class);
	private BillingRepository billingRepository;
	private CustomerRepository customerRepository;
	
	public RetailerService(BillingRepository billingRepository, CustomerRepository customerRepository) {
		this.billingRepository = billingRepository;
		this.customerRepository = customerRepository;
	}
	
	//Finding all Customer
	public List<Customer> findAll() {
		logger.debug("Returning Customer List from Service");
		return customerRepository.findAll();
	}
	
	//Finding Customer by ID
	public List<BillingOrder> findByCustomerId(int id){
		logger.debug("Returning Customer from Service");
		return billingRepository.findByCustomerId(id);	
	}
	
	//Returning TotalRewardsList for particular customer
	public List<Integer> totalRewardsList(int id){
		logger.info("In TotalRewardsList in Service");
		List<BillingOrder> billings = billingRepository.findByCustomerId(id);
		List<Float> bill = new ArrayList<>();
		List<Date> date = new ArrayList<>();
		List<Integer> rewardsList = new ArrayList<>();
		List<Integer> quantityList = new ArrayList<>();
		List<Integer> totalpriceList = new ArrayList<>();
		int totalPriceListIndex=0;
		int quantityListValue=0;
		int finalRewards =0;
		
		billings.forEach(billing ->  bill.add(billing.getProduct().getUnitprice()) );
		billings.forEach(billing ->  quantityList.add(billing.getQuantity())  );
		billings.forEach(dates ->  date.add(dates.getDateoforder()) );
		Collections.sort(date, Collections.reverseOrder());
		
		while(quantityListValue < quantityList.size()) {
			totalpriceList.add((int) (quantityList.get(quantityListValue) * bill.get(quantityListValue)));
			quantityListValue++;
		}
		
		while(totalPriceListIndex < totalpriceList.size()) {
			finalRewards=0;
			if( totalpriceList.get(totalPriceListIndex)>50 ) {
				if(totalpriceList.get(totalPriceListIndex)>100) {
					finalRewards = (2*(totalpriceList.get(totalPriceListIndex) - 100))+50;
				}else {
					finalRewards = totalpriceList.get(totalPriceListIndex)-50;
				}
			}
			rewardsList.add(finalRewards);
			totalPriceListIndex++;
		}
		logger.debug("Returning Rewards List from Service");
		return rewardsList; 
	}
}

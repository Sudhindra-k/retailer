package com.retailer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import com.retailer.entity.BillingOrder;

public interface BillingRepository extends JpaRepository<BillingOrder, Integer> {
	
	List<BillingOrder> findByCustomerId(@RequestParam("id") Integer id);

}

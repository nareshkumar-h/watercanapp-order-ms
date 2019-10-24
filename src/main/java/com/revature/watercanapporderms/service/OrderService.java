package com.revature.watercanapporderms.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.watercanapporderms.repository.OrderRepository;
import com.revature.watercanapporderms.exception.ServiceException;
import com.revature.watercanapporderms.model.Order;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;

	@Transactional
	public Order orderStock(Order order) throws ServiceException {
		// int totalCanAfterOrder = 0;
		Order result = null;
		/*
		 * List<Stock> stocks = stockRepository.findAll(); Stock stockDet =
		 * stocks.get(0);
		 */
		order.setOrderCans(order.getOrderCans());
		order.setUserId(order.getUserId());
		int cansAvail = 100;
		if (order.getOrderCans() <= cansAvail) {
	    order.setDate(LocalDateTime.now());
			result = orderRepository.save(order);
		} else {
			throw new ServiceException("Invalid cans...please check available stock and re enter the value");
		}
		/*
		 * totalCanAfterOrder = cansAvail - order.getOrderCans();
		 * stockDet.setCansAvail(totalCanAfterOrder);
		 * stockRepository.save(stockDet);
		 */
		return result;
	}
}

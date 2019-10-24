package com.revature.watercanapporderms.dto;

import java.time.LocalDateTime;


import lombok.Data;

@Data
public class OrderDTO {
	
	private int id;
	private int userId;
	private String userName;
	private Integer orderCans;
	private LocalDateTime date;

}

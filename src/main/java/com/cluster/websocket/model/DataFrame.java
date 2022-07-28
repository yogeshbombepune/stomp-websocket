package com.cluster.websocket.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DataFrame {
	private String stockName;
	private double price;
	private String currency;
}

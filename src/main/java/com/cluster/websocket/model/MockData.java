package com.cluster.websocket.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MockData {

	public static final Map<String, List<String>> CURRENCY_WISE_STOCKS = init();

	public static Map<String, List<String>> init() {
		String[] USD_STOCKS = { "AAPL", "MSFT", "AMZN", "TSLA", "GOOGL", "GOOG", "NVDA", "BRK.B", "META", "UNH" };
		String[] INR_STOCKS = { "SBIN", "BOB", "TCS", "WIPROW", "INFY", "ICICIBANK", "HDFCBANK", "AXIXBANK", "IDBI",
				"PAYTM" };
		String[] SGD_STOCKS = { "DBS", "OCBC BANK", "UOB", "SIGTEL", "WILMAR INTL", "SIA", "SGX", "UOL", "SATS",
				"STARHUB" };

		Map<String, List<String>> currencyWiseStocks = new ConcurrentHashMap<String, List<String>>();
		currencyWiseStocks.put("USD", Arrays.asList(USD_STOCKS));
		currencyWiseStocks.put("INR", Arrays.asList(INR_STOCKS));
		currencyWiseStocks.put("SGD", Arrays.asList(SGD_STOCKS));
		return currencyWiseStocks;
	}

}

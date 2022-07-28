package com.cluster.websocket.service;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.cluster.websocket.model.DataFrame;
import com.cluster.websocket.model.MockData;

@Service
public class DataFeedService {
	Random r = new Random();

	public List<DataFrame> getDataFrame() {
		List<String> inrStocks = MockData.CURRENCY_WISE_STOCKS.get("INR");
		List<String> usdStocks = MockData.CURRENCY_WISE_STOCKS.get("USD");
		List<String> sgdStocks = MockData.CURRENCY_WISE_STOCKS.get("SGD");

		List<DataFrame> inrCollect = IntStream.range(0, inrStocks.size())
				.mapToObj(
						x -> DataFrame.builder().currency("INR").price(100 + (200 - 100) * r.nextDouble()).stockName(inrStocks.get(x)).build())
				.collect(Collectors.toList());
		
		List<DataFrame> usdCollect = IntStream.range(0, usdStocks.size())
				.mapToObj(
						x -> DataFrame.builder().currency("USD").price(500 + (2000 - 500) * r.nextDouble()).stockName(usdStocks.get(x)).build())
				.collect(Collectors.toList());
		
		List<DataFrame> sgdCollect = IntStream.range(0, sgdStocks.size())
				.mapToObj(
						x -> DataFrame.builder().currency("SGD").price(50 + (200 - 50) * r.nextDouble()).stockName(sgdStocks.get(x)).build())
				.collect(Collectors.toList());

		return Stream.of(inrCollect, usdCollect, sgdCollect).flatMap(Collection<DataFrame>::stream)
				.collect(Collectors.toList());
	}

}

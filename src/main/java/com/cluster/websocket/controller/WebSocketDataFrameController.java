package com.cluster.websocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.cluster.websocket.service.DataFeedService;

@Controller
@EnableScheduling
public class WebSocketDataFrameController {
	@Autowired
	private SimpMessagingTemplate messagingTemplate;

	@Autowired
	private DataFeedService dataFeedService;

	// @MessageMapping("/hello-stock-exchange")
	// @SendTo("/topic/feeds")
	@Scheduled(fixedDelay = 1000)
	public void feeds() throws Exception {
		messagingTemplate.convertAndSend("/topic/feeds", dataFeedService.getDataFrame());
	}

}

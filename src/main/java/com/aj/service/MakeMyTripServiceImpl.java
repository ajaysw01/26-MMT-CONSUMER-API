package com.aj.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.aj.request.Passenger;
import com.aj.response.Ticket;

@Service
public class MakeMyTripServiceImpl implements MakeMyTripService {

	private String BOOK_TICKET_URL="http://12.232.253.164:8081/ticket";
	
	private String GET_TICKET_URL ="http:12.232.253.164.8081/ticket/{ticketNum}";
	
	@Override
	public Ticket bookTicket(Passenger passenger) {
		RestTemplate rt = new RestTemplate();//responsible to send http req to the url
		ResponseEntity<Ticket> respEntity =
				rt.postForEntity(BOOK_TICKET_URL, passenger, Ticket.class);//we want to send post req
		//url of req, json object, response type
		Ticket ticket = respEntity.getBody();
		return ticket;
	}

	@Override
	public Ticket getTicketByNumI(Integer ticketNumber) {

		RestTemplate rt = new RestTemplate();
		ResponseEntity<Ticket> respEntity =
					rt.getForEntity(GET_TICKET_URL,Ticket.class,ticketNumber);
		
		Ticket ticket = respEntity.getBody();
		
		return ticket;
	}

}

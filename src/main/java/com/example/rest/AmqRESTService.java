package com.example.rest;

import javax.jms.Connection;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class AmqRESTService {

	public static void sendMessage() throws Exception {
		
		// Shouldn't create a connection/session for every message send, but this should be fine
		// for the PoC
	    ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616");
	
	    Connection connection = cf.createConnection("admin","admin");
	
	    connection.start();
	
	    Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	
	    Queue queue = session.createQueue("test_queue");
	
	    MessageProducer producer = session.createProducer(queue);
	
	    TextMessage message = session.createTextMessage("Hello world");
	
	    producer.send(message);
	    
	}
	
}
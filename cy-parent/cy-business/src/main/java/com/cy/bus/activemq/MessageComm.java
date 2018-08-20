package com.cy.bus.activemq;

import java.io.Serializable;

import javax.jms.JMSException;  
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;  
import javax.jms.TextMessage;  
  
import org.springframework.jms.core.MessageCreator;  
  
public class MessageComm implements MessageCreator {  
      
    private Object message;  
    public MessageComm(Object message){  
        this.message = message;  
    }  
  
    @Override  
    public Message createMessage(Session session) throws JMSException {  
        // TODO Auto-generated method stub  
    	//TextMessage messages = session.createTextMessage(message);
        ObjectMessage messages = session.createObjectMessage((Serializable)message);
        return messages;  
    }  
  
}  
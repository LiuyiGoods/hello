package com.cy.bus.activemq;

import javax.jms.JMSException;  
import javax.jms.Message;  
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;  
  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Component;

import com.cy.dao.UserMapper;
import com.cy.model.User;


/** 
 * 点对点消息队列监听器 
 * @ClassName: QueueReceiver1  
 * @author lq
 * @date 2018年4月30日 下午3:17:46  
 *  
 * @version V1.0 
 */  
@Component  
public class QueueReceiver1 implements MessageListener{  
      
    @Autowired  
    private UserMapper usermapper;  
  
/*    @Override  
    public void onMessage(Message message) {  
        // TODO Auto-generated method stub  
        try {  
            String text = ((TextMessage) message).getText();  
            System.out.println("点对点QueueReceiver1监听器"+text);  
            User user = new User();
            user.setUserName(text);
            usermapper.insert(user);
        } catch (Exception e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
    }  */
    
    @Override  
    public void onMessage(Message message) {
    	if (message instanceof ObjectMessage) {
            ObjectMessage objMessage = (ObjectMessage) message;  
            try {  
                Object obj = objMessage.getObject();  
                User user = (User) obj;
                usermapper.insert(user);
            } catch (JMSException e) {  
                e.printStackTrace();  
            }  
        }
    }
  
      
}  
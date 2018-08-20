package com.cy.bus.activemq;

import javax.jms.JMSException;  
import javax.jms.Message;  
import javax.jms.Session;  
  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.beans.factory.annotation.Qualifier;  
import org.springframework.jms.core.JmsTemplate;  
import org.springframework.jms.core.MessageCreator;  
import org.springframework.stereotype.Component;  
  
/**  
 * 消息生产者  
 * @ClassName: QueueSender1   
 * @author zyj   
 * @date 2016年11月30日 上午11:41:41   
 *   
 * @version V1.0  
 */  
  
@Component  
public class QueueSender1 {  
      
    // 通过Qualifier来注入对应的Bean   
   // @Autowired  
    //@Qualifier("jmsQueueTemplate")  
    private JmsTemplate jmsTemplate;  
      
    /**  
     *  发送消息到指定的队列(目标)   
     * @Title: send   
     * @param queueName 队列名称   
     * @param message 消息内容  
     * @return void  
     * @author zyj  
     * @date 2016年11月30日 上午11:57:43   
     * @throws  
     */  
    public void send(String queueName,Object message){  
        jmsTemplate.send(new MessageComm(message));  
          
    }  
      
}  
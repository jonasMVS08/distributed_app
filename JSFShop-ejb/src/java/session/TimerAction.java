/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import java.util.Date;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;

/**
 *
 * @author karelwinderickx
 */
@Singleton
@Startup
public class TimerAction {

    @Resource
    private TimerService timerService;
    @Resource(mappedName="jms/ShopQueueConnectionFactory")
    private ConnectionFactory connectionFactory;
    @Resource(mappedName="jms/ShopQueue")
    private Destination queue;
    
    @PostConstruct
    private void init() {
        TimerConfig timerConfig = new TimerConfig();
        timerService.createSingleActionTimer(10000, timerConfig); //10 seconds
        System.out.println("Timer Initialized");
    }
    
    @Timeout
    public void action(Timer timer){
        System.out.println("Timer Finished");
        System.out.println("Execution Time: " + new Date());
        System.out.println("______________________________________________");  
        
        Connection connection = null;
        
        try {
            connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(queue);
            
            Message message = session.createTextMessage("hallo, hier ben ik");
            producer.send(message);
            
        } catch (JMSException ex) {
            Logger.getLogger(TimerAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}

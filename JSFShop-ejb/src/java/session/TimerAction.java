/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import java.util.Date;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;

/**
 *
 * @author karelwinderickx
 */
@Singleton
@Startup
public class TimerAction {

    @Resource
    private TimerService timerService;
    
    @PostConstruct
    private void init() {
        TimerConfig timerConfig = new TimerConfig();
        timerService.createSingleActionTimer(10000, timerConfig); //10 seconds
        System.out.println("Timer Initialized");
    }
    
    @Timeout
    public void action(Timer timer) {
        System.out.println("Timer Finished");
        System.out.println("Execution Time: " + new Date());
        System.out.println("______________________________________________");
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}

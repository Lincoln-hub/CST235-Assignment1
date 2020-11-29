package business;

import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

//import org.jboss.logging.Logger;
import java.util.logging.Logger;

@Stateless
public class MyTimerService {
	
	
	@Resource
	TimerService timerService;
	
	private static final Logger logger = Logger.getLogger("business.MyTimerService");
   
    public MyTimerService() 
    {
    }
    
	public void setTimer(long interval)
	{
		// TODO Auto-generated method stub
		timerService.createTimer(interval, "Setting a Program");
		
	}
    
    @Timeout
    public void programmaticTimeout(Timer timer) 
    {
    	logger.info("@Timeout in programmaticTimeout() calls........");
    }
	
	//@SuppressWarnings("unused")
	//@Schedule(second="*/10", minute="*", hour="0-23", dayOfWeek="Mon-Fri",dayOfMonth="*", month="*", year="*", info="MyTimer")
    private void scheduledTimeout(final Timer t) {
        logger.info("@Schedule called at: " + new java.util.Date());
    }


}
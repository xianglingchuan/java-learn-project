package com.myspringmvc.mytimer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;

import org.bouncycastle.util.Times;

public class MyTimer {
	
	public static void main(String[] args) {
		//1、创建一个Timer实例
		Timer timer = new Timer();
		//2、创建一个MyTimerTask实例
		//MyTimerTask myTimerTask = new MyTimerTask("No.1");
		//3、通过timer定时定频率调用myTimerTask的业务逻辑
		//即第一次执行是在当肖时间的两秒之后，之后每隔一秒钟执行一次
		//timer.schedule(myTimerTask,2000L,1000L);
		
		
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("当前时间:"+simpleDateFormat.format(calendar.getTime()));

		//1、在时间等于或超过time的时候执行且仅执行一次task
		//calendar.add(Calendar.SECOND, 5);
		//MyTimerTask myTimerTask = new MyTimerTask("schedul1");
		//timer.schedule(myTimerTask, calendar.getTime());
		
		
		//2、时间等于或超过time时首次执行task,之后每隔period毫秒重复执行一次task
		//MyTimerTask myTimerTask = new MyTimerTask("schedul2");
		//timer.schedule(myTimerTask, calendar.getTime(),3000L);
		
		
		//3、等待delay毫秒后执行且仅执行一次task
		//MyTimerTask myTimerTask = new MyTimerTask("schedul3");
		//timer.schedule(myTimerTask, 10000L);
		
		
		//4、等待delay毫秒后执行且仅执行一次task,之后每隔period毫秒重复执行一次task
		//MyTimerTask myTimerTask = new MyTimerTask("schedul4");
		//timer.schedule(myTimerTask, 10000L, 2000L);
		
		
		//1、时间等于或超过time时首次执行task，之后每隔period毫秒重复执行一次task
		//calendar.add(Calendar.SECOND, 5);
		//MyTimerTask myTimerTask = new MyTimerTask("schedulAtFixedRate1");
		//timer.scheduleAtFixedRate(myTimerTask, calendar.getTime(), 2000L);
		
		//2、等待delay毫秒后首次执行task,之后每隔period毫秒重复执行一次task
		MyTimerTask myTimerTask = new MyTimerTask("schedulAtFixedRate2");
		//timer.scheduleAtFixedRate(myTimerTask, 3000L, 2000L);
		//timer.scheduleAtFixedRate(myTimerTask, 3000L);
		
		//返回此任务最近实际执行的已安排执行的时间
		myTimerTask.setName("schedule");
		timer.schedule(myTimerTask, 3000);
		System.out.println("scheduled time is "+simpleDateFormat.format(myTimerTask.scheduledExecutionTime()));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

package com.myspringmvc.mytimer;

import java.text.SimpleDateFormat;
import java.util.TimerTask;

public class DancingRobot extends TimerTask {

	@Override
	public void run() {
		//获取最后一次任务执行的时间，并将其格式化
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("Scheduled exec time is:"+simpleDateFormat.format(scheduledExecutionTime()));
		System.out.println("Dancing happily!");
		
		
		
		
		
		
		
	}

}

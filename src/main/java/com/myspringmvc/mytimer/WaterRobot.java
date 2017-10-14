package com.myspringmvc.mytimer;

import java.util.Timer;
import java.util.TimerTask;

import org.apache.tomcat.jni.Time;

public class WaterRobot extends TimerTask {

	

	// 最大容量为5L
	private Integer bucketCapacity = 0;

	private Timer timer;

	public WaterRobot(Timer inputTimer) {
		super();
		timer = inputTimer;
	}

	@Override
	public void run() {
		// 灌水直至水满为止
		if (bucketCapacity < 5) {
			System.out.println("Add 1L water into the bucket! Current water is "+bucketCapacity+"L");
			bucketCapacity++;
		} else {
			// 水满之后就停止执行
			System.out.println("The number of canceled task is timer is"+timer.purge());
			
			cancel();
			System.out.println("The waterRobot has been aborted");
			System.out.println("The number of canceled task is timer is"+timer.purge());
			
			System.out.println("Current water is "+bucketCapacity+"L");
			//等待两秒钟，终止timer里面的所有内容
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			timer.cancel();
		}

	}

}

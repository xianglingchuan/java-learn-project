package com.myspringmvc.thread.tickets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class DaemonRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("进入守护线程--" + Thread.currentThread().getName());
		try {
			WriteToFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("退出守护线程--" + Thread.currentThread().getName());

	}

	public void WriteToFile() throws Exception {
		File file = new File("src/main/resources/daemon.txt");
		OutputStream oStream = new FileOutputStream(file, true);
		int count = 0;
		while (count < 999) {
			String str = "hello world " + count;
			oStream.write(new String("\r\n"+str).getBytes());
			System.out.println("守护线程" + Thread.currentThread().getName() + "向文件中写入了:" + str);
			count++;
			Thread.sleep(1000);
		}
		oStream.close();
	}

}

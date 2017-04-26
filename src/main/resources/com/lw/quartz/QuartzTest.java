package com.lw.quartz;

import org.quartz.JobBuilder;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzTest {

	public static void main(String[] args) {
		// 从工厂获取一个Scheduler
		try {
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
			// 开启
			scheduler.start();
			JobBuilder.newJob();
//			scheduler.shutdown();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

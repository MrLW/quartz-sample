package com.lw.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzTest2 {

	public static void main(String[] args) throws Exception {
		// 1、创建工厂
		SchedulerFactory schedFactory = new StdSchedulerFactory();

		// 2、创建调度器
		Scheduler sched = schedFactory.getScheduler();

		// 3、开启
		sched.start();

		// 4、定义一个job
		JobDetail job = JobBuilder.newJob(HelloJob.class).withIdentity("myjob", "group").build();
		
		// 5、创建trigger
		SimpleTrigger trigger = TriggerBuilder.newTrigger()
		.withIdentity("myTrigger","group")
		.startNow()
		.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever())
		.build();
		// 6、调度
		sched.scheduleJob(job, trigger) ;
		
		Thread.sleep(1000);
		
		sched.shutdown();
	}
}

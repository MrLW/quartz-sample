package com.lw.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzTest {

	public static void main(String[] args) throws InterruptedException {

		// ��������
		SchedulerFactory schedulerfactory = new StdSchedulerFactory();
		Scheduler scheduler = null;
		try {
			// ͨ��schedulerFactory��ȡһ��������
			scheduler = schedulerfactory.getScheduler();
			
			// ָ��job�����ƣ�����������ƣ��Լ���job��
			JobDetail job = JobBuilder.newJob(HelloJob.class).withIdentity("JobName", "JobGroupName")
					.usingJobData("name", "quartz").build();
			// ���崥��������
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity("CronTrigger1", "CronTriggerGroup")
					.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3).repeatForever())
					.startNow().build();

			// ����ҵ�ʹ�����ע�ᵽ���������
			scheduler.scheduleJob(job, trigger);

			// ��������
			scheduler.start();

			Thread.sleep(10000);

			// ֹͣ����
			scheduler.shutdown();

		} catch (SchedulerException e) {
			e.printStackTrace();
		}

	}
}

package com.lw.quartz;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob implements Job{

	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobDetail detail = context.getJobDetail(); 
		String name = detail.getJobDataMap().getString("name");
		System.out.println("say hello " + name );
	}

}

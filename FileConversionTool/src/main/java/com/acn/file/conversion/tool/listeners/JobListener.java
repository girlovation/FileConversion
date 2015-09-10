package com.acn.file.conversion.tool.listeners;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.StepExecution;

public class JobListener implements JobExecutionListener{
	
	private static final Logger LOGGER = Logger.getLogger(JobListener.class);

	Long start,end;
	public void afterJob(JobExecution jobExecution) {
		System.out.println("json to CSV job end");
		LOGGER.info("json to CSV job end");
		
		for(StepExecution stepExecution:jobExecution.getStepExecutions())
		{
			System.out.println(stepExecution.getSummary());
			LOGGER.info(stepExecution.getSummary());
			
			end=System.currentTimeMillis();
			
			System.out.println("End time is ="+end);
			LOGGER.info("End time is ="+end);
			System.out.println("Total Time Taken to complete the Job is "+(end-start));
			LOGGER.info("Total Time Taken to complete the Job is "+(end-start));
			
			List<Throwable> exception  = stepExecution.getFailureExceptions();
			for(Throwable th : exception){
				System.out.println("Exception is: "+th.getMessage());
				LOGGER.info("Exception is: "+th.getMessage());
			}
			
		}
		
	}

	public void beforeJob(JobExecution arg0) {
		System.out.println("json to CSV job starts");
		LOGGER.info("json to CSV job starts");
		
		start=System.currentTimeMillis();
		
		System.out.println("Start Time="+start);
		LOGGER.info("Start Time="+start);
	}

}

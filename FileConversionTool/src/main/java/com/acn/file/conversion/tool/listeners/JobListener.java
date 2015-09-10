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
		LOGGER.info("json to CSV job end");
		
		for(StepExecution stepExecution:jobExecution.getStepExecutions())
		{
			LOGGER.info(stepExecution.getSummary());
			
			end=System.currentTimeMillis();
			
			LOGGER.info("End time is ="+end);
			LOGGER.info("Total Time Taken to complete the Job is "+(end-start));
			
			List<Throwable> exception  = stepExecution.getFailureExceptions();
			for(Throwable th : exception){
				LOGGER.info("Exception is: "+th.getMessage());
			}
			
		}
		
	}

	public void beforeJob(JobExecution arg0) {
		LOGGER.info("json to CSV job starts");
		
		start=System.currentTimeMillis();
		
		LOGGER.info("Start Time="+start);
	}

}

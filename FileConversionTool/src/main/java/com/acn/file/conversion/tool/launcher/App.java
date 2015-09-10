package com.acn.file.conversion.tool.launcher;

import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	private static final Logger LOGGER = Logger.getLogger(App.class);

	public static void main(String[] args) {

		String[] springConfig = { "applicationContext.xml" };

		ApplicationContext context = new ClassPathXmlApplicationContext(
				springConfig);

		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		Job job = (Job) context.getBean("jsonToCsvBatchJob");

		try {

			JobExecution execution = jobLauncher.run(job, new JobParameters());
			LOGGER.info("Exit Status : " + execution.getStatus());

		} catch (Exception e) {
			e.printStackTrace();
		}


	}
}
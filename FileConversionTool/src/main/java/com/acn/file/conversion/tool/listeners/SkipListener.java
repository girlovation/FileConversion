package com.acn.file.conversion.tool.listeners;

import org.apache.log4j.Logger;
import org.springframework.batch.core.ItemReadListener;

public class SkipListener implements ItemReadListener<Object> {

	// private static final Logger SKIP_LOGGER=Logger.getLogger
	// (SkipListener.class);
	private static final Logger LOGGER = Logger.getLogger(SkipListener.class);

	public void afterRead(Object arg0) {
		// TODO Auto-generated method stub

	}

	public void beforeRead() {
		// TODO Auto-generated method stub

	}

	public void onReadError(Exception e) {
		// System.err.println(e.getMessage());
		LOGGER.error(e.getMessage());
	}

}

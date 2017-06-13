package com.derf.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This class makes a logger interface for my mod...
 * @author Fred
 *
 */
public class DLogger {
	
	// Logger instance
	private static Logger logger;
	
	/**
	 * This creates the logger instance 
	 */
	public static void create() {
		logger = LogManager.getLogger(DLoader.modid);
	}
	
	/**
	 * This will return the logger instance that I'm using
	 * @return Logger
	 */
	public static Logger getLogger() {
		return logger;
	}
}

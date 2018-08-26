package com.gouge.quartz.util;

/**
 *  定时任务常量
 *  @author Suoron
 *   
 */
public class JobConstants {
	
	public static final Byte IS_ENABLED = 0;
	public final static class PLAN_TYPE{
		public final static Byte ONE_TIME = 1;  		  	     //单次运行
		public final static Byte EXPR= 2;		 				 //按表达式				
	}
	public final static class DATA_TYPE{
		public final static String INT="int";
		public final static String LONG="long";
		public final static String DOUBLE="double";
		public final static String DATE="date";
		public final static String STRING="string";
	}
	
	public final static class STATUS{
		public final static Byte RUNNING = 1;
		public final static Byte STOP = 2;		
		public final static Byte EXCEPTION = 3;
	}
	
	public final static class LOG_STATUS{
		public final static String SUCCESS="success";
		public final static String FAILURE="failure";		
	}
	
	public final static class EXECUTE{
		public final static String METHOD_ID="methodId";
		public final static String TASK_NAME="taskName";
		public final static String METHOD_NAME="methodName";
		public final static String CLASS_NAME="className";
		public final static String PARAMS="params";
		public final static String PARAM_TYPES="paramTypes";
		public final static String JOB_ID="jobId";
	}
}

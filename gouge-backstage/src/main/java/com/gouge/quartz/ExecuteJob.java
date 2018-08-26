package com.gouge.quartz;

import com.gouge.quartz.util.JobConstants;
import com.gouge.quartz.util.SpringHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.UnableToInterruptJobException;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

/**
 *  A common job execute proxy
 *  @author Suoron 
 * 
 */

public class ExecuteJob extends BaseJob {

	private static final Logger logger = LogManager.getLogger(ExecuteJob.class);
	
	protected Object srv = null;
	
	@Override
	public void executeJob(JobExecutionContext context) throws Exception {
		JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
		String taskName = (String) jobDataMap.getString(JobConstants.EXECUTE.TASK_NAME).trim();
		String methodName = (String) jobDataMap.getString(JobConstants.EXECUTE.METHOD_NAME).trim();
		String className = (String) jobDataMap.getString(JobConstants.EXECUTE.CLASS_NAME).trim();
		//List<Object> params = (List<Object>) jobDataMap.get(EXECUTE.PARAMS);				
		//List<Class> paramTypes = (List<Class>) jobDataMap.get(EXECUTE.PARAM_TYPES);
		Map<String,Object> params = (Map<String,Object>) jobDataMap.get(JobConstants.EXECUTE.PARAMS);
		try {			
			if(isClassName(className)){
				Class<?> clazz = Class.forName(className);
				srv = SpringHelper.getBean(clazz);
				if(srv == null) {
					srv = clazz.newInstance();
				}
			}else{
				srv = SpringHelper.getBean(className);
			}
			//Method method = srv.getClass().getMethod(methodName, paramTypes.toArray(new Class[paramTypes.size()]));
			//method.invoke(srv, params.toArray(new Object[params.size()]));
			Method method = srv.getClass().getMethod(methodName, Map.class);			
			method.invoke(srv,params);
			//写日志
		} catch (Exception e) {
			e.printStackTrace();
			String exceptionMsg = "";
			try {
				Field field = e.getClass().getDeclaredField("target");
				field.setAccessible(true);
				Exception target = (Exception) field.get(e);
				logger.error(target.getMessage(), target);
				exceptionMsg = target.getMessage();
				field.setAccessible(false);
				
				//TODO 写错误日志
			} catch (Exception ex) {
			}					
		} finally {
			
		}
	}
	private boolean isClassName(String classStr){
		try{
  	        Class<?> clazz = Class.forName(classStr);
			return true;
		}catch(Exception ex){
		  	return false;
		}		
	}	
	
    public void interrupt() throws UnableToInterruptJobException {
    	System.out.println("Job:---ID:" + this.jobId + "  -- INTERRUPTING --");    	
    	try{
    		_interrupted = true;
    		if(srv != null){
    			Method method = srv.getClass().getMethod("interrupt");
    			if(method != null){
    				method.invoke(srv);
    			}
    		}
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}                      
    }	
}

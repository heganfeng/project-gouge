package com.gouge.quartz.util;

import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateConverter {
	
	//private final static LogUtil LOG = LogUtil.getInstance(DateConverter.class);
	//private Logger LOG = LogManager.getLogger(DateConverter.class);
	
	private final static SimpleDateFormat dateTimeFormatter;
	/** yyyy-MM-dd HH:mm:ss */
	public final static String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

	private final static SimpleDateFormat dateLineFormatter;
	/** yyyy-MM-dd */
	public final static String DATELINE_PATTERN = "yyyy-MM-dd";

	private final static SimpleDateFormat timeLineFormatter;
	public final static String timeLinePattern = "HH-mm";

	public final static String shortDatePattern = "yyMMdd";

	public static String timePattern = "HH:mm";

	static {
		dateTimeFormatter = new SimpleDateFormat(DATETIME_PATTERN);
		dateLineFormatter = new SimpleDateFormat(DATELINE_PATTERN);
		timeLineFormatter = new SimpleDateFormat(timeLinePattern);
	}

	public static final String now() {
		return dateTimeFormatter.format(new Date());
	}

	public static final String nowDateLine() {
		return dateLineFormatter.format(new Date());
	}

	public static final String nowTimeLine() {
		return timeLineFormatter.format(new Date());
	}

	public static final String toString(long time) {
		return dateTimeFormatter.format(new Date(time));
	}

	/**
	 * 日期转成字符串
	 * 
	 * @param aDate
	 * @return
	 * @author 颜超敏
	 */
	public static final String toString(Date aDate) {
		return dateTimeFormatter.format(aDate);
	}

	public static final String toString(Date aDate, String pattern) {
		if (pattern == null || aDate == null) {
			return "";
		}
		SimpleDateFormat df = null;
		String returnValue = "";
		df = new SimpleDateFormat(pattern);
		returnValue = df.format(aDate);

		return (returnValue);
	}

	public static final String toGMT(Date date) {
		try {
			SimpleDateFormat format = new SimpleDateFormat(
					"EEE, dd-MMM-yyyy HH:mm:ss zzz");
			Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
			format.setCalendar(cal);
			return format.format(date);
		} catch (Exception e) {
			//LOG.error(e);
			e.printStackTrace();
		}
		return "";
	}

	public static Date toDate(String strDate) throws ParseException {
		if (StringUtils.isEmpty(strDate)) {
			return null;
		}
		Date date = null;
		try {
			if (strDate.length() > 11) {
				date = dateTimeFormatter.parse(strDate);
			} else {
				date = dateLineFormatter.parse(strDate);
			}
		} catch (ParseException pe) {
			//LOG.error(pe);
			pe.printStackTrace();
			throw new ParseException(pe.getMessage(), pe.getErrorOffset());

		}
		return date;
	}

	public static final Date toDate(String strDate, String pattern)
			throws ParseException {
		if (StringUtils.isEmpty(strDate)) {
			return null;
		}
		SimpleDateFormat df = null;
		Date date = null;
		df = new SimpleDateFormat(pattern);

		try {
			date = df.parse(strDate);
		} catch (ParseException pe) {
			throw new ParseException(pe.getMessage(), pe.getErrorOffset());
		}

		return (date);
	}
	
}

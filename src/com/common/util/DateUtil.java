package com.common.util;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;


public class DateUtil {
	
	public static String getDateByNow(Date now){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(now);
	}
	
 

	
	public static List<String> getMonthList(Date curTime){
		List<String> returnList = new ArrayList<String>();
		Calendar ca = Calendar.getInstance();
	    ca.setTime(curTime);//
		ArrayList<String> yearAndMonthList = new ArrayList<String>();//
		String yearAndMonth = "";
		for (int i = 0; i < 12; i++) {
			if((ca.get(Calendar.MONTH) + 1) < 10){
				yearAndMonth = ca.get(Calendar.YEAR) + "0" + (ca.get(Calendar.MONTH) + 1);
			}else{
				yearAndMonth = ca.get(Calendar.YEAR) + "" + (ca.get(Calendar.MONTH) + 1);
			}
			yearAndMonthList.add(yearAndMonth);
			ca.set(Calendar.MONTH, ca.get(Calendar.MONTH) - 1);
		}

		
		for(int i = 0; i <= (yearAndMonthList.size() - 1); i++){
			returnList.add(yearAndMonthList.get(i));
		}
		
		return returnList;
	}
	
  /**
   * @param str
   * @return Date
   * @throws UtilException
   */
  public static Date parseString(String dateString) {
    //return stringToCalendar(str, fmt).getTime();
    if (dateString == null || "".equals(dateString) ||
        "null".equals(dateString.toLowerCase())) {
      
    }

    try {
      if (dateString.indexOf("-") != -1) {
        dateString = dateString.replaceAll("-", "/");
      }
      else if (dateString.indexOf(".") != -1) {
        dateString = dateString.replace('.', '/');
      }

      String fmt = "yyyy/MM/dd";

      if (dateString.indexOf(":") != -1) {
        fmt = "yyyy/MM/dd HH:mm:ss";
      }

      DateFormat df = new SimpleDateFormat(fmt);
      return df.parse(dateString);

    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * @param dt
   * @param fmt
   * @return String
   * @throws UtilException
   */
  public static String formatDate(Date dt, String fmt)  {
    if (dt == null) {
    	return null;
    }

    try {
      DateFormat df = new SimpleDateFormat(fmt);
      return df.format(dt);
    }
    catch (Exception e) {
      
    }
    return null;
  }

  
  /**
   * ��ȡ��ǰ����ϵͳ������
   * @return Date
   */
  public static java.sql.Date getSqlDate() {
    try {
      return new java.sql.Date( (new java.util.Date()).getTime());
    }
    catch (Exception e) {
      return null;
    }
  }

  public static java.sql.Date getSqlDate(Date date) {
    try {
      return new java.sql.Date(date.getTime());
    }
    catch (Exception e) {
      return null;
    }
  }

  public static java.sql.Date getSqlDate(String dateString) {
    try {
      return new java.sql.Date(parseString(dateString).getTime());
    }
    catch (Exception e) {
      return null;
    }
  }

  /**
   */
  public static String getTime() {
  	String timePattern="HHmmss";
    return new SimpleDateFormat(timePattern).format(Calendar.getInstance().getTime());
  }
  
  /**
   * ��ȡ��ǰ����ϵͳ��ʱ��, ��ʽʾ�� kk:mm:ss
   * @return ��ǰ����ϵͳ��ʱ��
   */
  public static String getTime(String timePattern) {
    return new SimpleDateFormat(timePattern).format(Calendar.getInstance().getTime());
  }
  
  /**
	 * ��õ�ǰ���ڵ��ַ�������ʽʾ�� YYYYMMDD
	 * @return
	 */
	public static String getDate(){
		String datePattern="yyyyMMdd";		
		return new SimpleDateFormat(datePattern).format( Calendar.getInstance().getTime());
	}
	
	
	/**
	 * ��õ�ǰ���ڵ��ַ�������ʽ���� YYYY��MM��DD��
	 * @return
	 */
	public static String getDate(String datePattern){	
		return new SimpleDateFormat(datePattern).format( Calendar.getInstance().getTime());
	}
	
	/**
	 * ��õ�ǰ���ڵ��ַ�������ʽ���� YYYY��MM��DD��
	 * @return
	 */
	public static String getDate(String datePattern,String newDate){	
		return new SimpleDateFormat(datePattern).format(newDate);
	}
	
//Add millisecond
  public static Date addMillisecond(Date dt, int millisecond) {
    return addSecond(dt, (long) millisecond);
  }

  public static Date addMillisecond(Date dt, long millisecond) {
    Date newDate = new Date();
    newDate.setTime(dt.getTime() + millisecond);
    return newDate;
  }

  //add second
  public static Date addSecond(Date dt, int second) {
    return addSecond(dt, (long) second);
  }

  public static Date addSecond(Date dt, float second) {
    return addSecond(dt, (double) second);
  }

  public static Date addSecond(Date dt, long second) {
    return addMillisecond(dt, 1000L * second);
  }

  public static Date addSecond(Date dt, double second) {
    Double millisecond = new Double(1000.0 * second);
    return addMillisecond(dt, millisecond.longValue());
  }

  //add minute
  public static Date addMinute(Date dt, int minute) {
    return addMinute(dt, (long) minute);
  }

  public static Date addMinute(Date dt, float minute) {
    return addMinute(dt, (double) minute);
  }

  public static Date addMinute(Date dt, long minute) {
    return addMillisecond(dt, 1000L * 60L * minute);
  }

  public static Date addMinute(Date dt, double minute) {
    Double millisecond = new Double(1000.0 * 60.0 * minute);
    return addMillisecond(dt, millisecond.longValue());
  }

  //add hour
  public static Date addHour(Date dt, int hour) {
    return addHour(dt, (long) hour);
  }

  public static Date addHour(Date dt, float hour) {
    return addHour(dt, (double) hour);
  }

  public static Date addHour(Date dt, long hour) {
    return addMillisecond(dt, 1000L * 60L * 60L * hour);
  }

  public static Date addHour(Date dt, double hour) {
    Double millisecond = new Double(1000.0 * 60.0 * 60.0 * hour);
    return addMillisecond(dt, millisecond.longValue());
  }

  //add day
  public static Date addDay(Date dt, int day) {
    return addDay(dt, (long) day);
  }

  public static Date addDay(Date dt, float day) {
    return addDay(dt, (double) day);
  }

  public static Date addDay(Date dt, long day) {
    return addMillisecond(dt, 1000L * 60L * 60L * 24L * day);
  }

  public static Date addDay(Date dt, double day) {
    Double millisecond = new Double(1000.0 * 60.0 * 60.0 * 24.0 * day);
    return addMillisecond(dt, millisecond.longValue());
  }


  //add month
  public static Date addMonth(Date dt, int month) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(dt);
    cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + month);
    return cal.getTime();
  }
  

  public static Date addMonth(Date dt, float month) {
    return addMonth(dt, (double) month);
  }

  public static Date addMonth(Date dt, long month) {
    return addMonth(dt, (new Long(month)).intValue());
  }

  public static Date addMonth(Date dt, double month) {
    double floorMonth = Math.floor(month);
    double decimalMonth = month - floorMonth;
    dt = addMonth(dt, (new Double(floorMonth)).intValue());
    Calendar cal = Calendar.getInstance();
    cal.setTime(dt);
    cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);
    Date nextdt = cal.getTime();
    long monthMillisecond = nextdt.getTime() - dt.getTime();
    double millisecond = (double) monthMillisecond * decimalMonth;
    return addMillisecond(dt, (long) millisecond);
  }
  
  //add month by lancy
  public static Date addMonth(String dt, int month) {  	
    Calendar cal = Calendar.getInstance();
    try {
		cal.setTime(parseString(dt));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
 		
	}	
	
    cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + month);
    
    return cal.getTime();
  }
  //add year
  public static Date addYear(Date dt, int year) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(dt);
    cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) + year);
    return cal.getTime();
  }

  public static Date addYear(Date dt, float year) {
    return addYear(dt, (double) year);
  }

  public static Date addYear(Date dt, long year) {
    return addYear(dt, (new Long(year)).intValue());
  }

  public static Date addYear(Date dt, double year) {
    double floorYear = Math.floor(year);
    double decimalYear = year - floorYear;
    dt = addYear(dt, (new Double(floorYear)).intValue());
    Calendar cal = Calendar.getInstance();
    cal.setTime(dt);
    cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) + 1);
    Date nextdt = cal.getTime();
    long yearMillisecond = nextdt.getTime() - dt.getTime();
    double millisecond = (double) yearMillisecond * decimalYear;
    return addSecond(dt, (long) millisecond);
  }

  /**
   * ����ĳ��ĳ��ĳ�� ��һ��֮���ǵڼ���
   * @param year,month,day
   * @return String
   */
  public static String calDay(int year,int month,int day){
	  
	int sum = 0;
	for (int i = 1; i < month; i++) {
		switch (i) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			sum += 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			sum += 30;
			break;
		case 2:			
			if((year%4==0) || ((year%100!=0) && (year%400==0))){
				sum += 29;
			}else{
				sum += 28;
			}
		default:
			break;
		}
	}
	String count = "";
	try {
		int tempSum = sum + day;
		String tempCount = String.valueOf(tempSum);
		if(tempCount.length() == 1){
			count = "00" + tempCount;
		}else if (tempCount.length() == 2){
			count = "0" + tempCount;
		}else if (tempCount.length() == 3){
			count = tempCount;
		}else{
			count = "000";
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	return count;
  }
  
  /**
   * ����ĳ��ĳ��ĳ�� ��һ��֮���ǵڼ���
   * @return String
   */
  public static String calDay(){
	
	  String year = getDate("yyyy");
	  String month = getDate("MM");
	  String day = getDate("dd");
	  
	  int sum = 0;
	  for (int i = 1; i < Integer.parseInt(month); i++) {
		switch (i) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			sum += 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			sum += 30;
			break;
		case 2:			
			if((Integer.parseInt(year)%4==0) || ((Integer.parseInt(year)%100!=0) && (Integer.parseInt(year)%400==0))){
				sum += 29;
			}else{
				sum += 28;
			}
		default:
			break;
		}
	  }
	String count = "";
	try {
		int tempSum = sum + Integer.parseInt(day);;
		String tempCount = String.valueOf(tempSum);
		if(tempCount.length() == 1){
			count = "00" + tempCount;
		}else if (tempCount.length() == 2){
			count = "0" + tempCount;
		}else if (tempCount.length() == 3){
			count = tempCount;
		}else{
			count = "000";
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	return count;
  }
  
  
  /**
	 * ������µ��·ݣ�Ʃ�籾�����£��������1������03����ʾ���·�
	 * @return
	 */
//update by zhuhong 20070323
public static String getBeforeMonth(String currentMonth,int beforeMonth){
	  //String currentMonth = getDate("MM");
	  int cal = beforeMonth % 12;
	  //System.out.println("cal = " + cal);
	  int month = Integer.parseInt(currentMonth)-cal;
	  String returnMonth;
	  if(month<1){
		  returnMonth = String.valueOf(12+month);
	  }else{
		  returnMonth = String.valueOf(Integer.parseInt(currentMonth)-cal);
	  }
	  if (returnMonth.length()<2) return "0" +returnMonth;
	  return returnMonth;
	  
}
public static String getBeforeMonth(int beforeMonth){
      String currentMonth = getDate("MM");
	  int cal = beforeMonth % 12;
	  //System.out.println("cal = " + cal);
	  int month = Integer.parseInt(currentMonth)-cal;
	  String returnMonth;
	  if(month<1){
		  returnMonth = String.valueOf(12+month);
	  }else{
		  returnMonth = String.valueOf(Integer.parseInt(currentMonth)-cal);
	  }
	  if (returnMonth.length()<2) return "0" +returnMonth;
	  return returnMonth;
	
	}
 
  //add by lancy
  /**
   * java.util.Date ת��Ϊjava.sql.Date
   * @return Date
   */
  public static java.sql.Date toSqlDate(java.util.Date d) {
    try {
      return new java.sql.Date( d.getTime());
    } catch (Exception e) {
      return null;
    }
  }
  
  /**
	 * �������������ת����julian��ʽ������
	 * julian��ʽ��YYYYDDD������DDD�Ǵ�1/1��ʼ����������ֵ
	 * ����20050101->2005001,20050131->2005031
	 * 
	 * @param inputDate �������ڣ���ʽYYYYMMDD
	 * @return julian��ʽ���ڣ���ʽYYYYDDD,����DDD�Ǵ�1/1��ʼ����������ֵ
	 * @throws ParseException
	 */
	public static String getJulianDate(String inputDate) throws ParseException{
		SimpleDateFormat inputFormatter=new SimpleDateFormat("yyyyMMdd");
		inputFormatter.setLenient(false);	// strict check the date string
		return new SimpleDateFormat("yyyyDDD").format( inputFormatter.parse(inputDate));
	}
  
	public static java.sql.Timestamp stringToTimestamp(String str,String format) {

	      if (str==null||format==null) {
	          return null;
	      }

	      SimpleDateFormat sdf = new  SimpleDateFormat(format);

	      java.util.Date date = null;
	      try
	      {
	          date = sdf.parse(str);
	      }
	      catch(Exception e)
	      {
	          return null;
	      }
	      return new java.sql.Timestamp(date.getTime());
	  }
	
	/**
	 * ��ָ���ĸ�ʽ���������ַ���
	 * @author Kevin
	 * @param dateString
	 * @param format
	 * @return Date null�������ʧ��
	 *
	 */
	public static Date parseDateString( String dateString, String format ){
		try{
			SimpleDateFormat formatter = new SimpleDateFormat( format );
			formatter.setLenient(true);
			Date temp = formatter.parse( dateString );
			return temp;
		}catch( Exception ex ){
			return null;
		}
	}
	
	/** 
	* Description:�����������ڼ������ 
	* @author MIAOJIYONG001
	* @param fromDate 
	*            ��ʼ���� 
	* @param toDate 
	*            �������� 
	* @return 
	* Create Time:20081107
	* @throws ParseException 
	*/ 
	public static long dateDiff(String fromDate, String toDate) throws ParseException{ 
		long days = 0; 
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd"); 
		Date from = df.parse(fromDate); 
		Date to = df.parse(toDate); 
		days = (long) ((to.getTime() - from.getTime())/(24 * 60 * 60 * 1000)); 
		return days; 
	}
	
	
	/**
	 * Description:�Ƿ���context-creditcard�����õ���֮��
	 * @author MIAOJIYONG001
	 * @return
	 */
	public static boolean turnOnDate(String onDate){
		//ȡ��ǰʱ��
		String currentDate = DateUtil.getDate();		
		//ȡ������Ϣ���Ƚ����ڡ�
		ResourceBundle ms = null;
		if (ms == null)
			ms = PropertyResourceBundle.getBundle("context-creditcard");

		String toDate = ms.getString(onDate).trim();
		long on = 0;
		try {
			on = DateUtil.dateDiff(toDate, currentDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(on >= 0){
			return true;
		}
		return false;
	}
	
	/**
	 * Description:�˵����Ƿ���context-creditcard�����õ���֮ǰ
	 * @author MIAOJIYONG001
	 * @return
	 */
	public static boolean turnByBillDate(String onDate, String billDate) {
		//ȡ������Ϣ���Ƚ����ڡ�
		ResourceBundle ms = null;
		if (ms == null)
			ms = PropertyResourceBundle.getBundle("context-creditcard");

		String fromDate = ms.getString(onDate).trim();
		long on = 0;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date billDateFormat = sdf.parse(billDate);
			on = DateUtil.dateDiff(fromDate, formatDate(billDateFormat, "yyyyMMdd"));
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		if(on >= 0){
			return false;
		}
		return true;
	}
	/**
	 * Description:���ƴ���Ŀ���
	 * @author MIAOJIYONG001
	 * @return
	 */
	public static boolean getTurnOnOrOff(String key){
		ResourceBundle ms = null;
		if (ms == null)
			ms = PropertyResourceBundle.getBundle("context-creditcard");
		String value = ms.getString(key).trim();
		return Boolean.valueOf(value).booleanValue(); 
	}
	
	/**
	 * ��õ�ǰ���ڵ��ַ�������ʽĬ�� YYYY-MM-DD
	 * @param datePattern
	 * @return ���������ʽҪ���ʱ������
	 * @author ex_jinjie 2009/1/12
	 */
	public static String getDateForFormat(String datePattern){	
		if(StringUtil.isNullOrBlank(datePattern)){
			datePattern="yyyy-MM-dd";
		}
		return new SimpleDateFormat(datePattern).format( Calendar.getInstance().getTime());
	}
	
	/**
	 * ��ʽת�� ��ƽ��������趨ʱ��'20021111111111'ת����ʹ��ָ���ָ����ַ�����
	 * ��ָ�Ϊ'.'�򷵻�Ϊ'2002.11.11',���������ա�
	 * @param dateString
	 * @param flag
	 * @return ת�����ַ���
	 * @author ex_jinjie 2009/1/12
	 */
	public static String changeStringFormat(String dateString,String flag){
		if(StringUtil.isNullOrBlank(dateString)){
			dateString="00000000000000";
		}
		if(StringUtil.isNullOrBlank(flag)){
			dateString=".";
		}
		String year=dateString.substring(0, 4);
		String month=dateString.substring(4, 6);
		String day=dateString.substring(6, 8);
		String res=year+flag+month+flag+day;
		return res;
	}
	/**
	 * ���JCB�����������Ƿ�����18-40��
	 * @param year
	 * @return
	 */
	public static boolean checkAgeForJCBByYeay(String year){
		int yearInt=Integer.parseInt(year);
		int nowYearInt=Calendar.getInstance().get(Calendar.YEAR);
		int age=nowYearInt-yearInt+1;
		if(age<18||age>40){
			return false;
		}else{
			return true;
		}		
	}
	
	/**
	 * @return
	 */
	public static String getYear(Date date){
		DateFormat strDate = new SimpleDateFormat("yyyy");
		return strDate.format(date);		
	} 
	
	/**
	 * @param date
	 * @param format
	 * @return
	 */
	public static String getDateString(Date date, String format){
	        DateFormat df = new SimpleDateFormat(format);
	        return df.format(date);		
	}
	
	/** 
	* @author MIAOJIYONG001
	* @param fromDate 
	* @param toDate 
	* Create Time:20081107
	* @throws ParseException 
	*/ 
	public static long dateDiffToMinute(String fromDate, String toDate) throws ParseException{ 
		long minutes = 0; 
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Date from = df.parse(fromDate); 
		Date to = df.parse(toDate); 
		minutes = (long) ((to.getTime() - from.getTime())/(60 * 1000)); 
		return minutes; 
	}
	
	public static String getDateSS(Date now){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(now);
	}
	/** 
	* @author MIAOJIYONG001
	* @param fromDate 
	* @param toDate 
	*            �������� 
	* @return 
	* Create Time:20081107
	* @throws ParseException 
	*/ 
	public static long dateDiffToSecond(String fromDate, String toDate) throws ParseException{ 
		long seconds = 0; 
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Date from = df.parse(fromDate); 
		Date to = df.parse(toDate); 
		seconds = (long) ((to.getTime() - from.getTime())/1000); 
		return seconds; 
	}
	
	/**���䷶Χ[minage,maxage],������㾫ȷ����
	 * @param date
	 * @return
	 */
	public static boolean checkage(String date,int minage,int maxage){
		boolean flag = false;		
		try {
			Date now = Calendar.getInstance().getTime();
			int nowtime = Integer.parseInt(DateUtil.formatDate(now,"yyyyMMdd"));
			if(date.length()!=8){
				return false;
			}
			int oldtime = Integer.parseInt(date);
			int age = nowtime-oldtime;
			
			if(age < minage*10000 || age > maxage*10000){
				flag=false;
			}else{
				flag=true;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			flag = false;
		}	
		return flag;
	}
	
	/**
	 * 
	 * @param mgmApplyCardDTOInTable
	 * @return
	 * @author EX-YUXIAO001 2014-08-25
	 * ���ݿ��sysdate����ӡ����������"2014-08-25 13:25:22.0"����"2014/08/25 13:25:22.0"�����ĸ�ʽ
	 * �����string�����������뱾������Ȼ��Ա�2014-08-25����2014/08/25�ǲ��ǵ�������
	 * ����ǵ������ڣ�����true�����򷵻�false
	 */
	public static boolean ifIsToday(String updateTime) {
		
		if(StringUtil.isNullOrBlank(updateTime)){
			return false;
		}
		
		try{
			String today=DateUtil.getDate("yyyyMMdd");
			  StringBuffer sb=new StringBuffer();
			  sb.append(updateTime.substring(0,4));
			  sb.append(updateTime.substring(5, 7));
			  sb.append(updateTime.substring(8, 10));
			  
			  return today.equals(sb.toString());
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * @param String
	 * @author EX-YUXIAO001 2014-09-01
	 * @return boolean
	 * description: ���������ַ������Ƿ���ϡ�yyyyMMdd�����ָ�ʽ
	 * ���� "20140922",���ϡ�yyyyMMdd����ʽ������true��
	 * ���� "99999999",������"yyyyMMdd"��ʽ������false
	 */
	 public static boolean ifMatchyyyyMMdd(String str) {
		 		if(StringUtil.isNullOrBlank(str)){
		 			return false;
		 		}
		 		String tmp="";
				try {
					Format f = new SimpleDateFormat("yyyyMMdd");
					Date d = (Date) f.parseObject(str);
					tmp = f.format(d);
				} catch (ParseException e) {
					return false;
				}
				return tmp.equals(str);
	 }
 
	 /**
		 * ��õ�ǰ���ڵ��ַ�������ʽʾ�� YYYY��MM��DD��
		 * @return
		 */
	public static String getDate1(){
		String datePattern="yyyy��MM��dd��HHʱmm��ss��";		
		return new SimpleDateFormat(datePattern).format( Calendar.getInstance().getTime());
	}
	 /**
		 * ��õ�ǰ���ڵ��ַ�������ʽʾ�� YYYY��MM��DD��
		 * @return
		 */
	public static String getDate2(){
		String datePattern="yyyy-MM-dd HH:mm:ss";			
		return new SimpleDateFormat(datePattern).format( Calendar.getInstance().getTime());
	}	
	public static String getDateSms(String date){
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		DateFormat df = new SimpleDateFormat("yyyy��MM��dd��");
		String tmp="";
	    try {
	    	tmp = df.format(sdf.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return tmp;
		
	}
	
 
	 
	
	 public static void main(String[] args){
		 System.out.println(getDate1());
 
	 }
	
}





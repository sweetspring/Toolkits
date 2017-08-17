package shutil;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class TimeUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Timestamp d = new Timestamp(System.currentTimeMillis()); 
		Date date = new Date();       
		Timestamp nousedate = new Timestamp(date.getTime());
		System.out.println(d);
		Calendar now = Calendar.getInstance();  
        TimeZone timeZoneUS = TimeZone.getTimeZone("America/Whitehorse");  
        Calendar us_now =  new GregorianCalendar(timeZoneUS);  
        System.err.println(" China timestamp: " + now.getTimeInMillis());  
        System.err.println(" U timestamp: " + us_now.getTimeInMillis());  
          
        System.err.println(" China hour: " + now.get(Calendar.HOUR_OF_DAY));  
        System.err.println(" US Hour: " + us_now.get(Calendar.HOUR_OF_DAY));  
	}

}


/*
相互转换 
1. 使用getTime()函数
这两个类都提供了getTime()函数，用于返回对应的毫秒数（long类型）。利用这个函数可以实现转换：
    java.util.Date utilDate = new java.util.Date(sqlDate.getTime());   // sql -> util
    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());   // util -> sql

2. 使用SimpleDateFormat类实现转换
SimpleDateFormat 是一个以国别敏感的方式格式化和分析数据的具体类。 它允许格式化 (date -> text)、语法分析 (text -> date)和标准化。
SimpleDateFormat dateFormat = new SimpleDateFormate("yyyy-MM-dd HH:mm:ss");
java.util.Date utilDate = dateFormat.parse(sqlDate.toString());

3. 直接转换
由于java.sql.Date是从java.util.Date中继承过来的，所以可以直接用：
utilDate = sqlDate;

4. 另类获得日期的方法：
SimpleDateFormat sy=new SimpleDateFormat("yyyy");
SimpleDateFormat sm=new SimpleDateFormat("MM");
SimpleDateFormat sd=new SimpleDateFormat("dd");
String syear=sy.format(date);
String smon=sm.format(date);
String sday=sd.format(date);

ps： java.util.Date类中的getYear()要加上1900才可得到实际值，getMonth()则要加上1      
*/
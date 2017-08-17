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
�໥ת�� 
1. ʹ��getTime()����
�������඼�ṩ��getTime()���������ڷ��ض�Ӧ�ĺ�������long���ͣ������������������ʵ��ת����
    java.util.Date utilDate = new java.util.Date(sqlDate.getTime());   // sql -> util
    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());   // util -> sql

2. ʹ��SimpleDateFormat��ʵ��ת��
SimpleDateFormat ��һ���Թ������еķ�ʽ��ʽ���ͷ������ݵľ����ࡣ �������ʽ�� (date -> text)���﷨���� (text -> date)�ͱ�׼����
SimpleDateFormat dateFormat = new SimpleDateFormate("yyyy-MM-dd HH:mm:ss");
java.util.Date utilDate = dateFormat.parse(sqlDate.toString());

3. ֱ��ת��
����java.sql.Date�Ǵ�java.util.Date�м̳й����ģ����Կ���ֱ���ã�
utilDate = sqlDate;

4. ���������ڵķ�����
SimpleDateFormat sy=new SimpleDateFormat("yyyy");
SimpleDateFormat sm=new SimpleDateFormat("MM");
SimpleDateFormat sd=new SimpleDateFormat("dd");
String syear=sy.format(date);
String smon=sm.format(date);
String sday=sd.format(date);

ps�� java.util.Date���е�getYear()Ҫ����1900�ſɵõ�ʵ��ֵ��getMonth()��Ҫ����1      
*/
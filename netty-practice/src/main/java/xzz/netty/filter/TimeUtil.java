package xzz.netty.filter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
	
    public static String stampToDate(long s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(s);
        res = simpleDateFormat.format(date);
        return res;
    }       
    public static String getCurrentTimeString(){
    	
    	return stampToDate(System.currentTimeMillis());
    }
 
    public static long DateTostamp(String date){
        long res = -1;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dt1;  
        try {  
                 dt1 = simpleDateFormat.parse(date);  
                 long ts1 = dt1.getTime();
                 res = ts1;
                 System.out.println(date + ": " + ts1);
                 return res;
                 
        } catch (ParseException e) {  
                    // TODO 自动生成的 catch 块  
                 e.printStackTrace();
                 return res;
        }  
    }
    
	public static long timeTostamp3(String strTime) {
		
		String res;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMddHHmmss");
		Date date;
		try {
			date = simpleDateFormat.parse(strTime);
			long ts = Long.valueOf(date.getTime());
			return ts;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		
	}
    
	public static String getSDeiviceTime(byte[] buff){
		String sDeviceTime = "";
		String tmpStr;
		for(int i=0;i<buff.length;i++){
			if(buff[i]<10){
				tmpStr = "0"+buff[i];
			}else{
				tmpStr = ""+buff[i];
			}
			sDeviceTime = sDeviceTime+tmpStr;
		}
		
		return sDeviceTime;
	}
    
    
    
    
    
    public static void main(String args[]){
    	
    	System.out.println(getCurrentTimeString());
    	//System.out.println(TimeUtil.timeTostamp3("181225185123"));
		System.out.println(TimeUtil.DateTostamp("2019-06-17 02:42:06"));
    }

}

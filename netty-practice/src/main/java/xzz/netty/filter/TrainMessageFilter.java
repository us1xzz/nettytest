package xzz.netty.filter;

import xzz.netty.ByteUtil;
import xzz.netty.StringHexUtil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TrainMessageFilter {
	
	   public static void  readFile_WriteMessage(String input_filename,String output_filename,int trainNum){
	    	
	        File input_file = new File(input_filename);
	        File output_file = new File(output_filename);
	        
	        BufferedReader reader = null;
	        BufferedWriter writer = null; 
	       
	        try {
		        System.out.println("以行为单位读取文件内容，一次读一行");
		        reader = new BufferedReader(new FileReader(input_file));
		        writer = new BufferedWriter(new FileWriter(output_file));
		        String tempString = null;
		        int line = 1;
		        byte[] buff;

		        
		        int count = 0;
		        //一次读一行，读入null时文件结束
		        
		        while ((tempString = reader.readLine()) != null) {
			        //把当前行号显示出来
//			        System.out.println("line " + line + ": " + tempString);
			        if(tempString.contains("recieve message-")){
			        	
			        	String[] Str = tempString.split(":");
			        	String message_head = Str[0];
			        	String message = Str[1];			        	
			        	buff = StringHexUtil.StringToBytes(message);
			        	
			        	Str = message_head.split("-");
			        	String timeStampStr = Str[1];
			        	
			        	long timeStamp = Long.parseLong(timeStampStr);
			        	
			        	byte sDevice = ByteUtil.getByte(buff, 4);
			        	int lineNum = ByteUtil.getShort(buff, 10);
			        	int messageType = ByteUtil.getShort(buff, 6);
			        	int train_num = ByteUtil.getInt(buff, 14);
			        	
			        	String outStr;
			        	
			        	if(train_num == trainNum){
			        		
			        		outStr = TimeUtil.stampToDate(timeStamp)+
				        			"-> package_type: "+messageType+",  sDevice: "+sDevice+
				        			",  lineNum: "+lineNum+",  trainNum: "+train_num;
				        	writer.write(tempString+"\n");				        	
				        	System.out.println("keepMessage ####:"+outStr);
			        		
			        	}else{
			        		
/*			        		outStr = TimeUtil.stampToDate(timeStamp)+
				        			"-> package_type: "+messageType+",  sDevice: "+sDevice+
				        			",  lineNum: "+lineNum+",  trainNum: "+train_num;
			        		writer.write(tempString+"\n");
			        		System.out.println("reoveMessage ####:"+outStr);
*/
			        	}
			        	
	
			        }
			        line++;
		        }
		        reader.close();
		        writer.flush();
		        writer.close();
	        } catch (IOException e) {
	        	e.printStackTrace();
	        } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
		        if (reader != null) {
			        try {
			        	reader.close();
			        } catch (IOException e1) {
			        }
		        }
	        }
	    	
	    }
	   
	   public static void main(String args[]){
		   
		   String input_filename;
		   String output_filename;
		   int trainNum = 0;
		   
		   if(args.length < 3){
			   System.out.println("error paramaters");
			   trainNum = 20;
			   input_filename = "D:\\netty-practice\\nc_message_0616_night-1.log";
			   output_filename = "D:\\netty-practice\\nc_message_0616_night-1"+trainNum+".log";

			   
		   }else{
			   input_filename = args[0];
			   output_filename = args[1];
			   trainNum = Integer.parseInt(args[2]);
			   
		   } 
		   
		  
		   readFile_WriteMessage(input_filename,output_filename,trainNum);
	    }
	   
	   



}

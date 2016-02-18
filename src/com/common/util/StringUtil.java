package com.common.util;

public class StringUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           String a="1111111111";
           
           String b=""+(Integer.valueOf(a)+1);
           
           int maxLength=10;
           
           if(10>=b.length()){
        	   StringBuffer bf=new StringBuffer(); 
        	   for(int i=0;i<maxLength-b.length();i++){
        		   bf.append("0");
        		   
        	   }
        	   
        	   bf.append(b);
        	   System.out.println(bf.toString());
        	   
        	   }
           
	}
	/**
	 * 前补零 
	 * @param 
	 * @return
	 */
	public static String fullNumberByLength(String b){
          
           int maxLength=10;
           StringBuffer bf=new StringBuffer(); 
           if(maxLength>=b.length()){
        	   for(int i=0;i<maxLength-b.length();i++){
        		   bf.append("0");
        	   }
        	   bf.append(b);
        	}
           
           return bf.toString();
	}
	/**
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isNullOrBlank(Object obj){
		if(obj==null||String.valueOf(obj).equals("null")||String.valueOf(obj).equals("")){
			return true;
		}
		return false;
	}
	/**
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isNotNullOrBlank(Object obj){
		if(obj==null||String.valueOf(obj).equals("null")||String.valueOf(obj).equals("")){
			return false;
		}
		return true;
	}
}

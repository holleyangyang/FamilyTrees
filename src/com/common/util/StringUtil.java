package com.yy.util;

public class StringUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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

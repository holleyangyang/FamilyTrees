package com.common.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Test {
  public  static void main(String []a){
	   
	    Map map =new HashMap();
	    map.put("a","a");
	    map.put("b","b");
	    Iterator  iterator =   map.keySet().iterator();
	    
	    
	    while(iterator.hasNext()){
	    	Object obj=iterator.next();
	    	 System.out.println(obj);
	    	 
	    	 
	    }
	      iterator =   map.keySet().iterator();
	    if(iterator.hasNext()){
	    	Object obj=iterator.next();
	    	 System.out.println("if=="+obj);
	    }
   }
   
}

package com.monocept.model;

import java.util.LinkedList;
import java.util.Map;

public class LeastFrequentlyUsed implements IStrategy{

	@Override
	public void operation(Map<String, Integer> memorymap, LinkedList<String> readingorder) {
		int minCount=memorymap.get(readingorder.getFirst());
		String key=null;
		for(String i:readingorder) {
			String key1=i;
			int count=memorymap.get(key1);
			if (count < minCount) {
				minCount=count;
				key=key1;	
			}
			
		}
		   if (key == null && !readingorder.isEmpty()) {
	            key = readingorder.getFirst();
	            
		   }
		   
		   if(key!=null) {
			   memorymap.remove(key);
			   readingorder.remove(key);
		   }
		
	}

}

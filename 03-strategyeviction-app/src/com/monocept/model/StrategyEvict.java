package com.monocept.model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class StrategyEvict {
	
	
	LinkedList<String> readingorder;
	LinkedHashMap<String,Integer> memorymap;
	IStrategy istrategy;
	
	public StrategyEvict(  IStrategy istrategy) {
		super();
		this.readingorder =new LinkedList<String>();
		this.memorymap = new LinkedHashMap<String, Integer>() ;
		this.istrategy = istrategy;
	}
	
	public void get(String key) {
		if(memorymap.containsKey(key)) {
			memorymap.put(key, memorymap.get(key)+1);
			readingorder.add(key);
		}
		
	}
	public void put(String key,int value) {
		if(memorymap.size()>=3) {
			istrategy.operation(memorymap, readingorder);
		}
		memorymap.put(key, value);
		memorymap.get(key);
		
	}

	@Override
	public String toString() {
		return "MemoryMap [readingorder=" + readingorder + ", memorymap=" + memorymap + ", istrategy=" + istrategy.getClass().getSimpleName()
				+ "]";
	}

	

}

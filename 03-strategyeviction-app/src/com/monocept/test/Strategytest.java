package com.monocept.test;

import com.monocept.model.FirstInFirstOut;
import com.monocept.model.LeastFrequentlyUsed;
import com.monocept.model.LeastRecentlyUsed;
import com.monocept.model.StrategyEvict;

public class Strategytest {

	public static void main(String[] args) {
		StrategyEvict memorymap = new StrategyEvict (new LeastRecentlyUsed());
		memorymap.put("a", 0);
		memorymap.put("b", 0);
        memorymap.put("c", 0);
        memorymap.get("b");
        memorymap.get("b");
        memorymap.get("a");
        memorymap.get("a");
        memorymap.get("c");
        memorymap.get("a");
        memorymap.put("d", 0);
        System.out.println(memorymap);
        memorymap = new StrategyEvict (new FirstInFirstOut());
		memorymap.put("a", 0);
		memorymap.put("b", 0);
        memorymap.put("c", 0);
        memorymap.get("b");
        memorymap.get("b");
        memorymap.get("a");
        memorymap.get("a");
        memorymap.get("c");
        memorymap.get("a");
        memorymap.put("d", 0);
        System.out.println(memorymap);
        memorymap = new StrategyEvict (new LeastFrequentlyUsed());
		memorymap.put("a", 0);
		memorymap.put("b", 0);
        memorymap.put("c", 0);
        memorymap.get("b");
        memorymap.get("b");
        memorymap.get("a");
        memorymap.get("a");
        memorymap.get("c");
        memorymap.get("a");
        memorymap.put("d", 0);
        System.out.println(memorymap);
        
	}
	

}

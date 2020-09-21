package com.yueqian.tickets.common;

import java.util.HashMap;
import java.util.Map;

public class ParamCreater {
	
	public static Map<String, Object> createParamMap(String[] keys, Object[] vals){
		Map<String, Object> result = new HashMap<String, Object>();
		if(keys == null || keys.length == 0 ||
				vals == null || vals.length == 0 ||
				keys.length != vals.length) {
			return result;
		}
		
		for (int i = 0; i < vals.length; i++) {
			result.put(keys[i], vals[i]);
		}
		return result;
		
	}

}

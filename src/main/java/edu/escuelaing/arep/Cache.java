package edu.escuelaing.arep;

import java.util.concurrent.ConcurrentHashMap;

public class Cache {
	private ConcurrentHashMap<String,String> dic = new ConcurrentHashMap<String,String>();
	private ConnectionService cs;
	
	Cache(){
		cs = new ConnectionService();
	}
	
	public String inCache(String lugar) {
		
		if (!dic.containsKey(lugar)) {
			 dic.put(lugar, cs.HTTPConnection(lugar));
		}
		System.out.println(dic.size());
		return dic.get(lugar);	
	}

}

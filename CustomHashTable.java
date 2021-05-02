package HashTables;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class CustomHashTable {
	
	Map<Integer, Integer> data;

	CustomHashTable(int size){
		data= new HashMap<Integer, Integer>(size);
	}
	
	public int hash(String key) {
		int hash=0;
		
		for(int i=0; i<key.length(); i++) {
			hash= (hash+ ((int)key.charAt(i))*i);
		}
		return hash;
	}
	
	public void set(String key, int value) {
		int address= hash(key);
		if(!data.containsKey(address)) {
			data.put(address, value);
		}else {
			data.replace(address, data.get(address),data.get(address)+value);
		}
	}
	
	public int get(String key) {
		int value=0;
		int address=hash(key);
		if(!data.containsKey(address))
			return 0;
		else
			value= data.get(address);
		return value;
	}
	
	
	
	public static void main(String[] args) {
		CustomHashTable c= new CustomHashTable(5);
		System.out.println(c.hash("hello"));
		
		c.set("hello", 2);
		System.out.println(c.get("hello"));
		System.out.println(c.hash("world"));
		
		c.set("world", 5);
		System.out.println(c.get("world"));
	}
	
}

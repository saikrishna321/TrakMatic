package thoughtworks.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonSearch {
	
	private boolean find(JSONObject jObject,Entry<String, String> search) throws JSONException {
		if(jObject.has(search.getKey())) {
			if(jObject.get(search.getKey()).equals(search.getValue())){
				return true;
			}
		}
		return false;
	}
	
	public List<JSONObject> findAll(List<JSONObject> jObjectList, Map<String, String> searchMap ) throws JSONException{
		
		List<JSONObject> resultJson = new ArrayList<JSONObject>();
		for(JSONObject jObject : jObjectList) {
			for(Entry<String, String> set : searchMap.entrySet()) {
				if(find(jObject, set))
					resultJson.add(jObject);
			}
		}
	
		return resultJson;
	}

}

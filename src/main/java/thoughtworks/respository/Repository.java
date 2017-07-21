package thoughtworks.respository;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import thoughtworks.utils.JsonSearch;

import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * Created by bsneha on 21/07/17.
 */
@Component
public class Repository implements IRepository<LinkedList<JSONObject>> {
	private LinkedList<JSONObject> data;
	private JsonSearch jsonSearch;

	public Repository() {
		this.data = new LinkedList<>();
		this.jsonSearch = new JsonSearch();
	}

	@Override
	public void store(String json) {
		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(json);
			this.data.add(jsonObject);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@Override
	public LinkedList<JSONObject> readData(Map<String, String> parameters) throws JSONException {
		if (parameters.size() == 0) {
			return data;
		}
		Set<JSONObject> json = jsonSearch.findAll(data, parameters);
		LinkedList<JSONObject> list = new LinkedList<>();
		list.addAll(json);
		return list;
	}

	@Override
	public void deleteData(Map<String, String> parameters) throws JSONException {
		if (parameters == null || parameters.size() == 0) {
			this.data.clear();
			return;
		}
		Set<JSONObject> deleteObjects = jsonSearch.findAll(data, parameters);
		this.data.removeAll(deleteObjects);
	}

}

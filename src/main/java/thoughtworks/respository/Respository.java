package thoughtworks.respository;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import thoughtworks.utils.JsonSearch;

import java.util.LinkedList;
import java.util.Map;

/**
 * Created by bsneha on 21/07/17.
 */
@Component
public class Respository implements IRepository<LinkedList<JSONObject>> {
    private LinkedList<JSONObject> data;
    private JsonSearch jsonSearch;
    public Respository() {
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
    public LinkedList<JSONObject> readData( Map<String, String> parameters) {
        try {
            return jsonSearch.findAll(data,parameters);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteData( Map<String, String> parameters) {
        if( parameters==null || parameters.size() == 0){
            this.data.clear();
            return;
        }
        try {
            LinkedList<JSONObject> deleteObjects = jsonSearch.findAll(data,parameters);
            this.data.removeAll(deleteObjects);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}

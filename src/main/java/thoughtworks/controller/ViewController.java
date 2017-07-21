package thoughtworks.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import thoughtworks.respository.IRepository;
import thoughtworks.utils.JsonStringConvertor;

import java.util.LinkedList;
import java.util.Map;

@RestController
@RequestMapping("/view")
public class ViewController {

    @Autowired
    private IRepository<LinkedList<JSONObject>> repository;

    @RequestMapping(method = RequestMethod.GET)
    public String getHandler(@RequestParam Map<String, String> query){
        
    	LinkedList<JSONObject> data;
    	LinkedList<String> dataString = new LinkedList<>();
		try {
			data = repository.readData(query);
			data.forEach((value)->{
	            dataString.add(value.toString());
	        });
			return JsonStringConvertor.convert(dataString);
		} catch (JSONException e) {
			e.printStackTrace();
			return "Not a valid json";
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "Json coversion failed";
		}
    }
	
}

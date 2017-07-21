package thoughtworks.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
    public String getHandler(@RequestParam Map<String, String> query) throws Exception {
        LinkedList<JSONObject> data = repository.readData(query);
        LinkedList<String> dataString = new LinkedList<>();
        data.forEach((value)->{
            dataString.add(value.toString());
        });
        return JsonStringConvertor.convert(dataString);
    }
	
}

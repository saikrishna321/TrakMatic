package thoughtworks.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import thoughtworks.respository.IRepository;
import thoughtworks.utils.JsonStringConvertor;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.Map;

@RestController
@RequestMapping("/")
public class RequestHandlerController {

    @Autowired
    private IRepository<LinkedList<JSONObject>> repository;

    @RequestMapping(value="**", method = RequestMethod.POST)
    public void postHandler(HttpServletRequest request) {
        String json;
		try {
			json = JsonStringConvertor.convert(request.getParameterMap());
			repository.store(json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    }

    @RequestMapping(value="**", method = RequestMethod.GET)
    public void getHandler(@RequestParam Map<String, String> query) {
        String json;
		try {
			json = JsonStringConvertor.convert(query);
	        repository.store(json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    }

}

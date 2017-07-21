package thoughtworks.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import thoughtworks.respository.IRepository;
import thoughtworks.utils.JsonStringConvertor;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;

@RestController
@RequestMapping("/")
public class RequestHandlerController {

    @Autowired
    private IRepository<LinkedList<Object>> repository;

    @RequestMapping(value="**", method = RequestMethod.POST)
    public void postHandler(HttpServletRequest request) throws JsonProcessingException {
        String json = JsonStringConvertor.convert(request.getParameterMap());
        repository.store(json);
    }

    @RequestMapping(value="**", method = RequestMethod.GET)
    public void getHandler(HttpServletRequest request) throws JsonProcessingException {
        String json = JsonStringConvertor.convert(request.getParameterMap());
        repository.store(json);
    }

}

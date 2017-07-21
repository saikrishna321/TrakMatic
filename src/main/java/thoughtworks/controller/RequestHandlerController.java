package thoughtworks.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import thoughtworks.utils.JsonStringConvertor;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/")
public class RequestHandlerController {

    @RequestMapping(value="**", method = RequestMethod.POST)
    public String postHandler(HttpServletRequest request) throws JsonProcessingException {
        return JsonStringConvertor.convert(request.getParameterMap());
    }

    @RequestMapping(value="**", method = RequestMethod.GET)
    public String getHandler(HttpServletRequest request) throws JsonProcessingException {
        return JsonStringConvertor.convert(request.getParameterMap());
    }

}

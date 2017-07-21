package thoughtworks.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/")
public class RequestHandlerController {

    @RequestMapping(value = "**", method = RequestMethod.POST)
    public String postHandler(HttpServletRequest request) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String response = mapper.writeValueAsString(request.getParameterMap());
        System.out.println(request.getParameterMap().size());
        return response;
    }

    @RequestMapping(value = "**", method = RequestMethod.GET)
    public String getHandler(HttpServletRequest httpServletRequest) {
        System.out.println(httpServletRequest.getQueryString());
        return "omg";
    }

}

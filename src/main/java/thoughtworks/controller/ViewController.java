package thoughtworks.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/view")
public class ViewController {

	
	@RequestMapping(value = "**", method = RequestMethod.GET)
    public String getHandler(HttpServletRequest request) throws Exception {
        
        return "View";
    }
	
}

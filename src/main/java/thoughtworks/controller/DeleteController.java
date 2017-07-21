package thoughtworks.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delete")
public class DeleteController {
	
	@RequestMapping(value = "**", method = RequestMethod.GET)
    public String deleteHandler(HttpServletRequest request) throws Exception {
        return "Delete";
    }
	
}

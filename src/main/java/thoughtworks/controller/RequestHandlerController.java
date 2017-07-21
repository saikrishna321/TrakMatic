package thoughtworks.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import thoughtworks.service.JsonWriter;

@RestController
public class RequestHandlerController {
	@Autowired
	JsonWriter jsonWriter;

	@RequestMapping(value = "/recieveData", method = RequestMethod.POST)
	public void acceptRequest(HttpServletRequest request, @RequestBody String body) {
		System.out.println(request.getContentType());
		System.out.println(body);
		if (request.getContentType().equals("application/json")) {
			jsonWriter.writeJson(body, "C://Git/abc.json");
		} else if (request.getContentType().equals("application/")) {
			System.out.println("else");
		} else {
			System.out.println("Data Received in Invalid Format");
		}
	}

}

package thoughtworks.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import thoughtworks.respository.IRepository;

import java.util.LinkedList;
import java.util.Map;

@RestController
@RequestMapping("/delete")
public class DeleteController {

    @Autowired
    private IRepository<LinkedList<Object>> repository;

    @RequestMapping(method = RequestMethod.GET)
    public void getHandler(@RequestParam Map<String, String[]> query) throws Exception {
        repository.deleteData(query);
    }

}

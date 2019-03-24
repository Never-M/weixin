package weixin.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import weixin.dao.PersonRepository;
import weixin.entity.Person;

/**
 *
 * @author zjz20
 */
@RestController
public class UserController {
    
    @Autowired
    private PersonRepository personRepo;
    
    @RequestMapping(value = "user/{userId}", 
                    method = RequestMethod.GET,
                    produces = {"application/json"})
    @ResponseBody
    public Person me(@PathVariable("userId") Long userId) throws Exception {
        Optional<Person> foundPerson = personRepo.findById(userId);
        if (foundPerson.isPresent())
            return foundPerson.get();
        else
            throw new Exception("User with id " + userId + " does not exist.");
    }
}

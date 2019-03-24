package weixin.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.Optional;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Data
    public static class UserCreationRequest implements Serializable {

        private String userName;
        private String password;

    }

    @RequestMapping(value = "user/create",
                    method = RequestMethod.POST,
                    produces = {"application/json"})
    public void createUser(@RequestBody UserCreationRequest request) throws Exception {

        Optional<Person> temp = personRepo.findByUserName(request.getUserName());
        if (temp.isPresent()) {
            throw new Exception("This person is already exsit");
        } else {
            Person p = new Person(request.getUserName(),
                                  request.getPassword(),
                                  new Date(),
                                  null);
            personRepo.save(p);
        }
    }

    @RequestMapping(value = "user/login",
                    method = RequestMethod.PUT,
                    produces = {"application/json"})
    public void loginUser(@RequestBody UserCreationRequest request) throws Exception {
    }
    
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

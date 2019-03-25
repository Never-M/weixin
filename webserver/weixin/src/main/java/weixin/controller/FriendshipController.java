
package weixin.controller;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import weixin.dao.UserHasFriendRepository;
import weixin.entity.UserHasFriend;

/**
 *
 * @author zjz20
 */
@RestController
public class FriendshipController {
        
        @Autowired
        private UserHasFriendRepository uhfRepo;
        
        @Data
        public static class UserAddFriend implements Serializable {
                private long user1Id;
                private long user2Id;
        }
        
        @RequestMapping(value = "user/add",
                        method = RequestMethod.PUT,
                        produces = {"application/json"})
        public void userAddFriend(@RequestBody UserAddFriend request) throws Exception {
                uhfRepo.save(new UserHasFriend(request.user1Id, request.user2Id, new Date()));
        }
}
